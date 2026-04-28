package ontrack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static ontrack.ChatMessage.SenderRole.*;

public class ChatTest {

    private ChatInbox inbox;

    @Before
    public void setUp() {
        inbox = new ChatInbox("1.1P", "223983938");
    }

    // [RIGHT] Messages are stored and order is preserved
    @Test
    public void testMessagesPreserveOrder() {
        inbox.addMessage(new ChatMessage("M001", "s1", STUDENT, "Msg 1"));
        inbox.addMessage(new ChatMessage("M002", "t1", TUTOR, "Msg 2"));
        inbox.addMessage(new ChatMessage("M003", "s1", STUDENT, "Msg 3"));
        assertEquals("Msg 1", inbox.getMessages().get(0).getContent());
        assertEquals("Msg 3", inbox.getMessages().get(2).getContent());
    }

    // [RIGHT] getLatestMessage returns the last added message
    @Test
    public void testGetLatestMessageReturnsLastAdded() {
        inbox.addMessage(new ChatMessage("M001", "s1", STUDENT, "Hello"));
        inbox.addMessage(new ChatMessage("M002", "t1", TUTOR, "Reply"));
        assertEquals("Reply", inbox.getLatestMessage().getContent());
    }

    // [RIGHT] Single message can be added and retrieved
    @Test
    public void testAddSingleMessage() {
        inbox.addMessage(new ChatMessage("M001", "s1", STUDENT, "Hello"));
        assertEquals(1, inbox.getMessageCount());
    }

    // [RIGHT] ChatMessage fields are stored correctly
    @Test
    public void testChatMessageFieldsCorrect() {
        ChatMessage msg = new ChatMessage("M001", "s1", STUDENT, "Hello tutor");
        assertEquals("M001", msg.getMessageId());
        assertEquals("s1", msg.getSenderId());
        assertEquals("Hello tutor", msg.getContent());
    }

    // [RIGHT] Sender role is stored correctly
    @Test
    public void testSenderRoleIsCorrect() {
        ChatMessage msg = new ChatMessage("M001", "t1", TUTOR, "Good work");
        assertEquals(TUTOR, msg.getSenderRole());
    }

    // [BOUNDARY] Empty inbox returns null for latest message
    @Test
    public void testGetLatestMessageOnEmptyInboxReturnsNull() {
        assertNull(inbox.getLatestMessage());
    }

    // [BOUNDARY] Adding null message throws
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullMessageThrows() {
        inbox.addMessage(null);
    }

    // [BOUNDARY] Null message ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullMessageIdThrows() {
        new ChatMessage(null, "s1", STUDENT, "Hello");
    }

    // [BOUNDARY] Empty message ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMessageIdThrows() {
        new ChatMessage("  ", "s1", STUDENT, "Hello");
    }

    // [BOUNDARY] Null sender ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullSenderIdThrows() {
        new ChatMessage("M001", null, STUDENT, "Hello");
    }

    // [BOUNDARY] Null sender role throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullSenderRoleThrows() {
        new ChatMessage("M001", "s1", null, "Hello");
    }

    // [BOUNDARY] Null content throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullContentThrows() {
        new ChatMessage("M001", "s1", STUDENT, null);
    }

    // [BOUNDARY] Whitespace-only content throws
    @Test(expected = IllegalArgumentException.class)
    public void testWhitespaceContentThrows() {
        new ChatMessage("M001", "s1", STUDENT, "   ");
    }

    // [BOUNDARY] Null task ID in ChatInbox throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullTaskIdInInboxThrows() {
        new ChatInbox(null, "223983938");
    }

    // [BOUNDARY] Null student ID in ChatInbox throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullStudentIdInInboxThrows() {
        new ChatInbox("1.1P", null);
    }

    // [INVERSE] Message count matches list size after multiple additions
    @Test
    public void testMessageCountMatchesManualCount() {
        for (int i = 0; i < 5; i++)
            inbox.addMessage(new ChatMessage("M" + i, "s1", STUDENT, "msg " + i));
        assertEquals(inbox.getMessageCount(), inbox.getMessages().size());
    }

    // [ERROR] getMessages returns an unmodifiable list
    @Test
    public void testGetMessagesIsUnmodifiable() {
        inbox.addMessage(new ChatMessage("M001", "s1", STUDENT, "Hello"));
        try {
            inbox.getMessages().add(new ChatMessage("M999", "s1", STUDENT, "Injected"));
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // expected
        }
    }

    // [CROSS-CHECK] getMessageCount matches getMessages().size()
    @Test
    public void testGetMessageCountMatchesGetMessagesSize() {
        inbox.addMessage(new ChatMessage("M001", "s1", STUDENT, "A"));
        inbox.addMessage(new ChatMessage("M002", "t1", TUTOR, "B"));
        assertEquals(inbox.getMessageCount(), inbox.getMessages().size());
    }

    // [RIGHT] ChatInbox fields are stored correctly
    @Test
    public void testChatInboxFieldsCorrect() {
        assertEquals("1.1P", inbox.getTaskId());
        assertEquals("223983938", inbox.getStudentId());
    }

    // [PERFORMANCE] Sending 500 messages completes within 1 second
    @Test
    public void testSending500MessagesWithin1Second() {
        long start = System.nanoTime();
        for (int i = 0; i < 500; i++)
            inbox.addMessage(new ChatMessage("M" + i, "s1", STUDENT, "message " + i));
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertTrue("Took too long: " + ms + "ms", ms < 1000);
    }
}
