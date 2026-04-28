package ontrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatInbox {

    private final String taskId;
    private final String studentId;
    private final List<ChatMessage> messages = new ArrayList<>();

    public ChatInbox(String taskId, String studentId) {
        if (taskId == null || taskId.trim().isEmpty())
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        this.taskId = taskId.trim();
        this.studentId = studentId.trim();
    }

    public String getTaskId() { return taskId; }
    public String getStudentId() { return studentId; }

    public void addMessage(ChatMessage msg) {
        if (msg == null) throw new IllegalArgumentException("Message cannot be null.");
        messages.add(msg);
    }

    public List<ChatMessage> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public ChatMessage getLatestMessage() {
        return messages.isEmpty() ? null : messages.get(messages.size() - 1);
    }

    public int getMessageCount() {
        return messages.size();
    }
}
