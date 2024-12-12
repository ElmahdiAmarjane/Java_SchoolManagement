package network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;
    private String userEmail;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

  
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Receive and register username
            userEmail = in.readLine();
            System.out.println(userEmail + " has joined.");

            synchronized (ChatServer2.clients) {
                ChatServer2.clients.add(this);
            }

            // Broadcast the updated user list
            ChatServer2.broadcastUserList();

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("HISTORY:")) {
                    String receiver = message.substring(8).trim();
                    ChatServer2.fetchChatHistory(userEmail, receiver, this);
                } else {
                    String[] parts = message.split(":", 2);
                    if (parts.length == 2) {
                        String receiver = parts[0].trim();
                        String content = parts[1].trim();
                        ChatServer2.sendMessageToClient(userEmail, receiver, content);
                    } else {
                        sendMessage("Invalid message format. Use: recipient:message");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Connection with client " + userEmail + " lost: " + e.getMessage());
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

    public String getUserEmail() {
        return userEmail;
    }
    
    public void sendMessage(String message) {
        out.println(message);
    }
    
}