//package network;
//
//import java.io.*;
//import java.net.*;
//import java.sql.*;
//import java.util.*;
//
//import db_connect.JDBC;
//
//public class ChatServer {
//    private static final int PORT = 12348;
//    static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
//    private static  Connection dbConnection ;
//
//    public static  void runServer() {
//        try {
//           
//        	 dbConnection = JDBC.getConnection();
//
//            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//                System.out.println("Chat server started on port " + PORT);
//
//                while (true) {
//                    Socket clientSocket = serverSocket.accept();
//                    ClientHandler clientHandler = new ClientHandler(clientSocket);
//                    new Thread(clientHandler).start();
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error starting server: " + e.getMessage());
//        }
//    }
//
//    // Broadcast the list of connected users to all clients
//    static void broadcastUserList() {
//        synchronized (clients) {
//            StringBuilder userList = new StringBuilder("USERLIST:");
//            for (ClientHandler client : clients) {
//                userList.append(client.getCni()).append(",");
//            }
//
//            // Remove trailing comma, if present
//            if (userList.length() > 9) {
//                userList.setLength(userList.length() - 1);
//            }
//
//            for (ClientHandler client : clients) {
//                client.sendMessage(userList.toString());
//            }
//        }
//    }
//
//    // Send a message to a specific client
//    static void sendMessageToClient(String sender, String receiver, String content) {
//        synchronized (clients) {
//            boolean foundReceiver = false;
//
//            for (ClientHandler client : clients) {
//                if (client.getCni().equals(receiver)) {
//                    client.sendMessage("From " + sender + ": " + content);
//                    foundReceiver = true;
//                    break;
//                }
//            }
//
//            if (!foundReceiver) {
//                System.out.println("User " + receiver + " is not connected.");
//            }
//            
//            // Send an acknowledgment back to the sender
//            for (ClientHandler client : clients) {
//                if (client.getCni().equals(sender)) {
//                    client.sendMessage("To " + receiver + ": " + content); // Echo back to sender
//                    break;
//                }
//            }
//        }
//
//        // Save the message in the database
//        saveMessageToDatabase(sender, receiver, content);
//    }
//
//    // Get user ID from the database by username
//    private static String getUserIdByUsername(String cni) {
//        try {
//            String sql = "SELECT cni FROM user WHERE cni = ?";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//            statement.setString(1, cni);
//
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getString("cni");
//            } else {
//                System.err.println("User not found: " + cni);
//                return ""; // Return invalid ID
//            }
//        } catch (SQLException e) {
//            System.err.println("Error fetching user ID for username: " + cni);
//            e.printStackTrace();
//            return ""; // Return invalid ID in case of error
//        }
//    }
//
//    // Save message to the database
//    private static void saveMessageToDatabase(String sender, String receiver, String content) {
//        try  {
//            String sql = "INSERT INTO messages (sender_id, receiver_id, message_content, timestamp) VALUES (?, ?, ?, ?)";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//
//            String senderId = getUserIdByUsername(sender);
//            String receiverId = getUserIdByUsername(receiver);
//
//            if (senderId.equals("") || receiverId.equals("")) {
//                System.err.println("Error: Unable to save message. Invalid sender or receiver ID.");
//                return;
//            }
//
//            statement.setString(1, senderId);
//            statement.setString(2, receiverId);
//            statement.setString(3, content);
//            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
//
//            statement.executeUpdate();
//            System.out.println("Message saved successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error saving message to database: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    
//    
//    static void fetchChatHistory(String sender, String receiver, ClientHandler clientHandler) {
//        try {
//        	 String sql = "SELECT sender_id, receiver_id, message_content, timestamp " +
//                     "FROM messages WHERE (sender_id = ? AND receiver_id = ?) " +
//                     "OR (sender_id = ? AND receiver_id = ?) ORDER BY timestamp ASC";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//
//            String senderId = getUserIdByUsername(sender);
//            String receiverId = getUserIdByUsername(receiver);
//
//            if (senderId.equals("") || receiverId.equals("")) {
//                clientHandler.sendMessage("Error fetching chat history. Invalid sender or receiver.");
//                return;
//            }
//
//            statement.setString(1, senderId);
//            statement.setString(2, receiverId);
//            statement.setString(3, receiverId);
//            statement.setString(4, senderId);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            StringBuilder chatHistory = new StringBuilder("HISTORY:");
//            while (resultSet.next()) {
//                String senderUsername = sender.equals(getUsernameById(resultSet.getString("sender_id"))) ? "You" : receiver;
//                String message = resultSet.getString("message_content");
//                Timestamp timestamp = resultSet.getTimestamp("timestamp");
//
//                chatHistory.append("\n").append(senderUsername).append(" (")
//                           .append(timestamp).append("): ").append(message);
//            }
//
//            clientHandler.sendMessage(chatHistory.toString());
//        } catch (SQLException e) {
//            System.err.println("Error fetching chat history: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    
//    private static String getUsernameById(String cni) {
//        try {
//            String sql = "SELECT cni FROM user WHERE cni = ?"; // a corriger , just pour testet 
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//            statement.setString(1, cni);
//
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getString("cni");
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            System.err.println("Error fetching username for user ID: " + cni);
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
//
//
