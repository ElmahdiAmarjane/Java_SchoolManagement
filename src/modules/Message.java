package modules;

import java.sql.Timestamp;

public class Message {
    private int id;
    private String senderId; //cni user
    private String receiverId; // cni user
    private String content;
    private Timestamp timestamp;

    public Message(int id, String senderId, String receiverId, String content, Timestamp timestamp) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() { return id; }
    public String getSenderId() { return senderId; }
    public String getReceiverId() { return receiverId; }
    public String getContent() { return content; }
    public Timestamp getTimestamp() { return timestamp; }

	public void setId(int id) {
		this.id = id;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
    
    
}

