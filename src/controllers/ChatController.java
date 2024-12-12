//package controllers;
//
//import javafx.application.Platform;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import modules.User;
//import network.ChatClient;
//
//import java.util.*;
//
//public class ChatController  {
//    @FXML
//    private ListView<String> listViewUsers;
//    @FXML
//    private TextArea textAreaMessages;
//    @FXML
//    private TextField txtMessage;
//    @FXML
//    private Button btnSend;
//    @FXML
//    private Label labelUserChat;
//    
//    @FXML
//    private VBox chatBox;
//
//    private User loggedInUser;
//    private ChatClient chatClient;
//    private ObservableList<String> onlineUsers = FXCollections.observableArrayList();
//    private Map<String, StringBuilder> chatHistories = new HashMap<>();
//
//   
//    @FXML
//    public void initialize() {
//    	System.out.println("ChatController instance created: " + this.hashCode());
//        listViewUsers.setItems(onlineUsers);
//        btnSend.setDisable(true);
//        chatBox.setVisible(true);
//
//        listViewUsers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                chatBox.setVisible(true);
//                btnSend.setDisable(false);
//
//                // Request chat history for the selected user
//                System.out.println("newValue--> "+newValue);
//                System.out.println("oldValue--> "+newValue);
//                requestChatHistory(newValue);
//            } else {
//                chatBox.setVisible(false);
//            }
//        });
//        txtMessage.setOnAction(event -> sendMessage());
//    }
//
//    public void setLoggedInUser2(User user) {
//        System.out.println("Updating Label in ChatController instance: " + this.hashCode());
//        Platform.runLater(() -> {
//            labelUserChat.setText("Logged in as: " + user.getCni());
//            System.out.println("Label text updated to: " + labelUserChat.getText());
//        });
//    }
//
//    
//    public void setLoggedInUser1(User user) {
//        System.out.println("Label instance: " + labelUserChat);
//        if (labelUserChat != null) {
//            labelUserChat.setText("Logged in as: " + user.getCni());
//            System.out.println("Label text set to: " + labelUserChat.getText());
//        } else {
//            System.out.println("labelUserChat is null! Check your FXML and FXMLLoader setup.");
//        }
//    }
//
//    
//    public void setLoggedInUser(User user) {
//    	 
//       this.loggedInUser = user;
//        labelUserChat.setText("Logged in as: " + user.getCni());
//         System.out.println(" user.Cni : "+user.getCni());
//        chatClient = new ChatClient(user.getCni(), this::receiveMessage, this::updateOnlineUsers);
//        new Thread(chatClient).start();  
//    }
//
//    private void updateOnlineUsers(String[] users) {
//        Platform.runLater(() -> {
//            onlineUsers.clear();
//            Set<String> uniqueUsers = new HashSet<>(Arrays.asList(users));
//            uniqueUsers.remove(loggedInUser.getCni());
//            onlineUsers.addAll(uniqueUsers);
//        });
//    }
//
//    private void displayChatHistory(String user) {
//        textAreaMessages.clear();
//        StringBuilder history = chatHistories.getOrDefault(user, new StringBuilder());
//        textAreaMessages.appendText(history.toString());
//    }
//
//
//    public void sendMessage() {
//        String message = txtMessage.getText().trim();
//        String recipient = listViewUsers.getSelectionModel().getSelectedItem();
//
//        if (!message.isEmpty() && recipient != null) {
//            chatClient.sendMessage(recipient + ":" + message);
//            txtMessage.clear();
//
//            chatHistories.putIfAbsent(recipient, new StringBuilder());
//            chatHistories.get(recipient).append("You: ").append(message).append("\n");
//        }
//    }
//
//    public void requestChatHistory(String recipient) {
//        if (recipient != null && !recipient.isEmpty()) {
//            chatClient.requestHistory(recipient);
//        }
//    }
//
//    
//    public void onUserSelected() {
//        String selectedUser = listViewUsers.getSelectionModel().getSelectedItem();
//        if (selectedUser != null) {
//            chatClient.requestHistory(selectedUser); // Request chat history from the server
//        }
//    }
//
//    public void receiveMessage(String message) {
//        Platform.runLater(() -> {
//            if (message.startsWith("HISTORY:")) {
//                // Handle history response
//                String[] historyLines = message.substring(8).split("\n");
//                String recipient = listViewUsers.getSelectionModel().getSelectedItem();
//
//                if (recipient != null) {
//                    StringBuilder history = chatHistories.getOrDefault(recipient, new StringBuilder());
//                    history.setLength(0); // Clear any existing chat history for this user
//
//                    for (String line : historyLines) {
//                        history.append(line).append("\n");
//                    }
//
//                    chatHistories.put(recipient, history);
//                    displayChatHistory(recipient);
//                }
//            } else {
//                // Handle real-time messages
//                String[] parts = message.split(":", 2);
//                if (parts.length == 2) {
//                    String sender = parts[0].replace("From ", "").trim();
//                    String content = parts[1].trim();
//
//                    // Append message to chat history
//                    chatHistories.putIfAbsent(sender, new StringBuilder());
//                    chatHistories.get(sender).append(sender).append(": ").append(content).append("\n");
//
//                    // If the sender is selected, update the chat zone
//                    if (sender.equals(listViewUsers.getSelectionModel().getSelectedItem())) {
//                        displayChatHistory(sender);
//                    }
//                }
//            }
//        });
//    }
//
//
//
//}


package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modules.User;
import network.ChatClient2;

import java.net.URL;
import java.util.*;

public class ChatController implements Initializable {
    @FXML
    private ListView<String> listViewUsers;
    @FXML
    private TextField txtMessage;
    @FXML
    private Button btnSend;
    @FXML
    private Label lblLoggedInUser;
    @FXML
    private VBox chatBox;
    @FXML
    private ScrollPane scrollPaneMessages;
    @FXML
    private VBox vboxMessages;

    private User loggedInUser;
    private ChatClient2 chatClient;
    private ObservableList<String> onlineUsers = FXCollections.observableArrayList();
    private Map<String, List<HBox>> chatHistories = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewUsers.setItems(onlineUsers);
        btnSend.setDisable(true);
        chatBox.setVisible(false);

        // User selection listener
        listViewUsers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                chatBox.setVisible(true);
                btnSend.setDisable(false);

                // Request chat history for the selected user
                chatClient.requestHistory(newValue);

                // Display existing chat history
                displayChatHistory(newValue);
            } else {
                chatBox.setVisible(false);
            }
        });

        // Handle sending messages when pressing Enter
        txtMessage.setOnAction(event -> sendMessage());
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        lblLoggedInUser.setText("Logged in as: " + user.getEmail());
        chatClient = new ChatClient2(user, this::receiveMessage, this::updateOnlineUsers);
        new Thread(chatClient).start();
    }

    private void updateOnlineUsers(String[] users) {
        Platform.runLater(() -> {
            onlineUsers.clear();
            Set<String> uniqueUsers = new HashSet<>(Arrays.asList(users));
            uniqueUsers.remove(loggedInUser.getEmail());
            onlineUsers.addAll(uniqueUsers);
        });
    }

    private void displayChatHistory(String user) {
        Platform.runLater(() -> {
            vboxMessages.getChildren().clear();

            List<HBox> history = chatHistories.getOrDefault(user, new ArrayList<>());
            for (HBox messageBox : history) {
                vboxMessages.getChildren().add(messageBox);
            }

            // Scroll to the bottom
            scrollPaneMessages.layout();
            scrollPaneMessages.setVvalue(1.0);
        });
    }



    public void sendMessage() {
        String message = txtMessage.getText().trim();
        String recipient = listViewUsers.getSelectionModel().getSelectedItem();

        if (!message.isEmpty() && recipient != null) {
            // Send the message to the server
            chatClient.sendMessage(recipient + ":" + message);
            txtMessage.clear();

            // Create the message bubble for the sent message
            HBox messageBox = createMessageBubble(message, true);

            // Add the sent message to the chat history
            chatHistories.putIfAbsent(recipient, new ArrayList<>());
            chatHistories.get(recipient).add(messageBox);

            // Display the message immediately if the recipient is selected
            if (recipient.equals(listViewUsers.getSelectionModel().getSelectedItem())) {
                vboxMessages.getChildren().add(messageBox);
                scrollPaneMessages.setVvalue(1.0);
            }
        }
    }

    public void receiveMessage(String message) {
        Platform.runLater(() -> {
            System.out.println("Received message: " + message);  // Log message for debugging

            // Handle History messages
            if (message.startsWith("HISTORY:")) {
                System.out.println("History detected.");  // Debug: Log that we're handling history
                String[] parts = message.split(":", 3);  // Split into three parts: HISTORY, recipient, chat history
                if (parts.length >= 3) {
                    String recipient = parts[1].trim();  // Extract recipient name (e.g., FATIHA)
                    String chatHistory = parts[2].trim();  // Get the chat history part

                    // Debug: Log extracted recipient and chat history
                    System.out.println("Recipient: " + recipient);
                    System.out.println("Chat History: " + chatHistory);

                    // Ensure the history list exists for the recipient
                    chatHistories.putIfAbsent(recipient, new ArrayList<>());
                    List<HBox> history = chatHistories.get(recipient);
                    history.clear();  // Clear any existing history for this recipient

                    // Process each line in the chat history
                    String[] lines = chatHistory.split("\n");
                    for (String line : lines) {
                        if (!line.isBlank()) {
                            boolean isSentByUser = line.startsWith("You:");
                            String content = isSentByUser
                                    ? line.substring(4).trim()  // Remove "You:" prefix for sent messages
                                    : line.substring(line.indexOf(":") + 1).trim();  // Remove "Username:" for received messages

                            HBox messageBox = createMessageBubble(content, isSentByUser);
                            history.add(messageBox);
                        }
                    }

                    // Update UI if the recipient is selected
                    if (recipient.equals(listViewUsers.getSelectionModel().getSelectedItem())) {
                        displayChatHistory(recipient);
                    }
                }
            } else {
                // Handle Real-Time messages
                String[] parts = message.split(":", 2);
                if (parts.length == 2) {
                    String sender = parts[0].replace("From ", "").trim();
                    String content = parts[1].trim();

                    // Debug: Log sender and message content
                    System.out.println("Sender: " + sender);
                    System.out.println("Message Content: " + content);

                    if (!content.isEmpty()) {
                        HBox messageBox = createMessageBubble(content, false);
                        chatHistories.putIfAbsent(sender, new ArrayList<>());
                        chatHistories.get(sender).add(messageBox);

                        // Display message if the sender is selected
                        if (sender.equals(listViewUsers.getSelectionModel().getSelectedItem())) {
                            vboxMessages.getChildren().add(messageBox);
                            scrollPaneMessages.layout();
                            scrollPaneMessages.setVvalue(1.0);  // Scroll to the bottom
                        }
                    }
                }
            }
        });
    }



    private HBox createMessageBubble(String message, boolean isSentByUser) {
        HBox hbox = new HBox();
        hbox.setSpacing(10);

        Text text = new Text(message);
        text.setStyle("-fx-font-size: 14px; -fx-padding: 10;");

        StackPane bubble = new StackPane(text);
        bubble.setStyle(isSentByUser
                ? "-fx-background-color: #0084ff; -fx-text-fill: white; -fx-background-radius: 10;"
                : "-fx-background-color: #e5e5ea; -fx-text-fill: black; -fx-background-radius: 10;");
        bubble.setPadding(new Insets(10));
        bubble.setMaxWidth(250);

        if (isSentByUser) {
            hbox.setAlignment(Pos.CENTER_RIGHT);
        } else {
            hbox.setAlignment(Pos.CENTER_LEFT);
        }

        hbox.getChildren().add(bubble);
        return hbox;
    }
}

