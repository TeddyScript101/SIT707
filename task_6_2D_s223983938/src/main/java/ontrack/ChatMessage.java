package ontrack;

public class ChatMessage {

    public enum SenderRole { STUDENT, TUTOR }

    private final String messageId;
    private final String senderId;
    private final String content;
    private final SenderRole senderRole;
    private final long timestamp;

    public ChatMessage(String messageId, String senderId, SenderRole senderRole, String content) {
        if (messageId == null || messageId.trim().isEmpty())
            throw new IllegalArgumentException("Message ID cannot be null or empty.");
        if (senderId == null || senderId.trim().isEmpty())
            throw new IllegalArgumentException("Sender ID cannot be null or empty.");
        if (senderRole == null)
            throw new IllegalArgumentException("Sender role cannot be null.");
        if (content == null || content.trim().isEmpty())
            throw new IllegalArgumentException("Content cannot be null or empty.");

        this.messageId = messageId.trim();
        this.senderId = senderId.trim();
        this.senderRole = senderRole;
        this.content = content.trim();
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessageId() { return messageId; }
    public String getSenderId() { return senderId; }
    public SenderRole getSenderRole() { return senderRole; }
    public String getContent() { return content; }
    public long getTimestamp() { return timestamp; }
}
