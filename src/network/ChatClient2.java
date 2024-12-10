package network;

import java.io.*;
import java.net.Socket;
import java.util.function.Consumer;

public class ChatClient2 implements Runnable {
    private final String username;
    private final Consumer<String> messageReceiver;
    private final Consumer<String[]> userListUpdater;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient2(String username, Consumer<String> messageReceiver, Consumer<String[]> userListUpdater) {
        this.username = username;
        this.messageReceiver = messageReceiver;
        this.userListUpdater = userListUpdater;
    }

    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 12345);
            System.out.println("Connected to server");  // Debug line
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Send username to the server
            out.println(username);

            String serverMessage;
            while ((serverMessage = in.readLine()) != null) {
                System.out.println("Received from server: " + serverMessage);  // Debug line
                if (serverMessage.startsWith("USERLIST:")) {
                    String[] users = serverMessage.substring(9).split(",");
                    userListUpdater.accept(users);
                } else {
                    messageReceiver.accept(serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);  // Debug line
        out.println(message);
    }

    public void requestHistory(String recipient) {
        if (recipient != null && !recipient.isEmpty()) {
            out.println("HISTORY:" + recipient);
        }
    }

    public void close() {
        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
