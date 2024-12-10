//package network;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//class ClientHandler implements Runnable {
//    private final Socket socket;
//    private BufferedReader in;
//    private PrintWriter out;
//    private String cni;
//
//    public ClientHandler(Socket socket) {
//        this.socket = socket;
//    }
//
//  
//    @Override
//    public void run() {
//        try {
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//
//            // Receive and register username
//            cni = in.readLine();
//            System.out.println(cni + " has joined.");
//
//            synchronized (ChatServer.clients) {
//                ChatServer.clients.add(this);
//            }
//
//            // Broadcast the updated user list
//            ChatServer.broadcastUserList();
//
//            String message;
//            while ((message = in.readLine()) != null) {
//                if (message.startsWith("HISTORY:")) {
//                    String receiver = message.substring(8).trim();
//                  //  ChatServer.fetchChatHistory(cni, receiver, this);
//                } else {
//                    String[] parts = message.split(":", 2);
//                    if (parts.length == 2) {
//                        String receiver = parts[0].trim();
//                        String content = parts[1].trim();
//                        ChatServer.sendMessageToClient(cni, receiver, content);
//                    } else {
//                        sendMessage("Invalid message format. Use: recipient:message");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Connection with client " + cni + " lost: " + e.getMessage());
//        } finally {
//            cleanup();
//        }
//    }
//
//
//    // Remove client and broadcast updated user list
//    private void cleanup() {
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        synchronized (ChatServer.clients) {
//            ChatServer.clients.remove(this);
//        }
//
//        ChatServer.broadcastUserList();
//    }
//
//    public String getCni() {
//        return cni;
//    }
//
//    public void sendMessage(String message) {
//        out.println(message);
//    }
//}