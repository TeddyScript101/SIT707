package ontrack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ontrack.AssignmentSubmission.SubmissionStatus;

public class AssignmentSubmissionTest {

    private static final byte[] VALID_PDF = new byte[]{1, 2, 3};

    private AssignmentSubmission submission;

    @Before
    public void setUp() {
        submission = new AssignmentSubmission("SIT707", "223983938", "1.1P", "report.pdf", VALID_PDF, "First attempt");
    }

    // [RIGHT] Default status is READY_FOR_FEEDBACK
    @Test
    public void testDefaultStatusIsReadyForFeedback() {
        assertEquals(SubmissionStatus.READY_FOR_FEEDBACK, submission.getStatus());
    }

    // [RIGHT] All fields stored correctly
    @Test
    public void testSubmissionFieldsCorrect() {
        assertEquals("SIT707", submission.getUnitCode());
        assertEquals("223983938", submission.getStudentId());
        assertEquals("1.1P", submission.getTaskId());
        assertEquals("report.pdf", submission.getFileName());
        assertEquals("First attempt", submission.getComment());
    }

    // [RIGHT] Null comment is accepted
    @Test
    public void testNullCommentIsAccepted() {
        AssignmentSubmission s = new AssignmentSubmission("SIT707", "111", "1.1P", "a.pdf", VALID_PDF, null);
        assertNull(s.getComment());
    }

    // [BOUNDARY] Non-PDF file throws
    @Test(expected = IllegalArgumentException.class)
    public void testNonPdfFileThrows() {
        new AssignmentSubmission("SIT707", "111", "1.1P", "report.docx", VALID_PDF, null);
    }

    // [BOUNDARY] Null unit code throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullUnitCodeThrows() {
        new AssignmentSubmission(null, "111", "1.1P", "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Empty unit code throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyUnitCodeThrows() {
        new AssignmentSubmission("  ", "111", "1.1P", "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Null student ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullStudentIdThrows() {
        new AssignmentSubmission("SIT707", null, "1.1P", "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Empty student ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyStudentIdThrows() {
        new AssignmentSubmission("SIT707", " ", "1.1P", "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Null task ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullTaskIdThrows() {
        new AssignmentSubmission("SIT707", "111", null, "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Empty task ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTaskIdThrows() {
        new AssignmentSubmission("SIT707", "111", "  ", "a.pdf", VALID_PDF, null);
    }

    // [BOUNDARY] Null file name throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullFileNameThrows() {
        new AssignmentSubmission("SIT707", "111", "1.1P", null, VALID_PDF, null);
    }

    // [BOUNDARY] Null file content throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullFileContentThrows() {
        new AssignmentSubmission("SIT707", "111", "1.1P", "a.pdf", null, null);
    }

    // [BOUNDARY] Empty byte array throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFileContentThrows() {
        new AssignmentSubmission("SIT707", "111", "1.1P", "a.pdf", new byte[0], null);
    }

    // [INVERSE] Status can be changed and reverted
    @Test
    public void testStatusCanBeChangedBack() {
        submission.setStatus(SubmissionStatus.RESUBMIT);
        assertEquals(SubmissionStatus.RESUBMIT, submission.getStatus());
        submission.setStatus(SubmissionStatus.READY_FOR_FEEDBACK);
        assertEquals(SubmissionStatus.READY_FOR_FEEDBACK, submission.getStatus());
    }

    // [CROSS-CHECK] All status transitions are valid
    @Test
    public void testAllStatusTransitionsAreValid() {
        for (SubmissionStatus st : SubmissionStatus.values()) {
            submission.setStatus(st);
            assertEquals(st, submission.getStatus());
        }
    }

    // [CROSS-CHECK] submittedAt is set to a positive timestamp
    @Test
    public void testSubmittedAtIsSetOnCreation() {
        assertTrue(submission.getSubmittedAt() > 0);
    }

    // [ERROR] setStatus with null throws
    @Test(expected = IllegalArgumentException.class)
    public void testSetStatusNullThrows() {
        submission.setStatus(null);
    }

    // [PERFORMANCE] Creating 1000 submissions completes within 2 seconds
    @Test
    public void testCreating1000SubmissionsIsWithin2Seconds() {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
            new AssignmentSubmission("SIT707", "s" + i, "T" + i, "f.pdf", VALID_PDF, null);
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertTrue("Took too long: " + ms + "ms", ms < 2000);
    }
}
