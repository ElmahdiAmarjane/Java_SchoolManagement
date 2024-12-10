package network;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ChatServer2 {
    private static final int PORT = 12345;
    static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    static Connection dbConnection;

    public static void main(String[] args) {
        try {
           
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "admin");
            System.out.println("Database connection established.");

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Chat server started on port " + PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    new Thread(clientHandler).start();
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Broadcast the list of connected users to all clients
    static void broadcastUserList() {
        synchronized (clients) {
            StringBuilder userList = new StringBuilder("USERLIST:");
            for (ClientHandler client : clients) {
                userList.append(client.getUsername()).append(",");
            }

            // Remove trailing comma, if present
            if (userList.length() > 9) {
                userList.setLength(userList.length() - 1);
            }

            for (ClientHandler client : clients) {
                client.sendMessage(userList.toString());
            }
        }
    }

    // Send a message to a specific client
    static void sendMessageToClient(String sender, String receiver, String content) {
        boolean foundReceiver = false;

        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client.getUsername().equals(receiver)) {
                    client.sendMessage("From " + sender + ": " + content); // Send to receiver
                    foundReceiver = true;
                    break;
                }
            }
        }

        // Always save the message to the database
        saveMessageToDatabase(sender, receiver, content);

        // Inform the sender if the message was delivered or queued
        if (foundReceiver) {
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    if (client.getUsername().equals(sender)) {
                        client.sendMessage("You (to " + receiver + "): " + content);
                        break;
                    }
                }
            }
        } else {
            System.out.println("User " + receiver + " is not connected. Message saved.");
        }
    }


    // Get user ID from the database by username
    private static String getUserIdByUsername(String username) {
        try {
            String sql = "SELECT cni FROM users WHERE cni = ?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("cni");
            } else {
                System.err.println("User not found: " + username);
                return null; // Return invalid ID
            }
        } catch (SQLException e) {
            System.err.println("Error fetching user ID for username: " + username);
            e.printStackTrace();
            return null; // Return invalid ID in case of error
        }
    }

    // Save message to the database
    private static void saveMessageToDatabase(String sender, String receiver, String content) {
        try {
            String sql = "INSERT INTO messages (sender_id, receiver_id, message_content, timestamp) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            String senderId = getUserIdByUsername(sender);
            String receiverId = getUserIdByUsername(receiver);

            if (senderId == null || receiverId == null) {
                System.err.println("Error: Unable to save message. Invalid sender or receiver ID.");
                return;
            }

            statement.setString(1, senderId);
            statement.setString(2, receiverId);
            statement.setString(3, content);
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            statement.executeUpdate();
            System.out.println("Message saved successfully.");
        } catch (SQLException e) {
            System.err.println("Error saving message to database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    static void fetchChatHistory(String sender, String receiver, ClientHandler clientHandler) {
        try {
            String senderId = getUserIdByUsername(sender);
            String receiverId = getUserIdByUsername(receiver);

            if (senderId == null || receiverId == null) {
                clientHandler.sendMessage("HISTORY:" + receiver + ":ERROR:Invalid sender or receiver.");
                return;
            }

            // Fetch messages between the two users
            String sql = """
                         SELECT sender_id, message_content, timestamp
                         FROM messages
                         WHERE (sender_id = ? AND receiver_id = ?)
                         OR (sender_id = ? AND receiver_id = ?)
                         ORDER BY timestamp ASC
                         """;
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, senderId);
            statement.setString(2, receiverId);
            statement.setString(3, receiverId);
            statement.setString(4, senderId);

            ResultSet resultSet = statement.executeQuery();
            StringBuilder chatHistory = new StringBuilder("HISTORY:" + receiver + ":");
            while (resultSet.next()) {
                String messageSenderId = resultSet.getString("sender_id");
                String senderUsername = messageSenderId == senderId ? "You" : receiver;
                String messageContent = resultSet.getString("message_content");
                chatHistory.append("\n").append(senderUsername).append(": ").append(messageContent);
            }

            clientHandler.sendMessage(chatHistory.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            clientHandler.sendMessage("HISTORY:" + receiver + ":ERROR:Unable to fetch chat history.");
        }
    }



}



class ClientHandler implements Runnable {
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

  
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Receive and register username
            username = in.readLine();
            System.out.println(username + " has joined.");

            synchronized (ChatServer2.clients) {
                ChatServer2.clients.add(this);
            }

            // Broadcast the updated user list
            ChatServer2.broadcastUserList();

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("HISTORY:")) {
                    String receiver = message.substring(8).trim();
                    ChatServer2.fetchChatHistory(username, receiver, this);
                } else {
                    String[] parts = message.split(":", 2);
                    if (parts.length == 2) {
                        String receiver = parts[0].trim();
                        String content = parts[1].trim();
                        ChatServer2.sendMessageToClient(username, receiver, content);
                    } else {
                        sendMessage("Invalid message format. Use: recipient:message");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Connection with client " + username + " lost: " + e.getMessage());
        } finally {
            cleanup();
        }
    }


    // Remove client and broadcast updated user list
    private void cleanup() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        synchronized (ChatServer2.clients) {
            ChatServer2.clients.remove(this);
        }

        ChatServer2.broadcastUserList();
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
