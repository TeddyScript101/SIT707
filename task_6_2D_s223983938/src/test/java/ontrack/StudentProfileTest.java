package ontrack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentProfileTest {

    private StudentProfile profile;

    @Before
    public void setUp() {
        profile = new StudentProfile("223983938", "Tsz Hin", "Yee", "s223983938@deakin.edu.au");
    }

    // [RIGHT] Correct values stored after construction
    @Test
    public void testProfileCreatedWithCorrectValues() {
        assertEquals("223983938", profile.getStudentId());
        assertEquals("Tsz Hin", profile.getFirstName());
        assertEquals("Yee", profile.getLastName());
        assertEquals("s223983938@deakin.edu.au", profile.getEmail());
    }

    // [RIGHT] Preferred name defaults to first name
    @Test
    public void testPreferredNameDefaultsToFirstName() {
        assertEquals(profile.getFirstName(), profile.getPreferredName());
    }

    // [RIGHT] Notifications default to true
    @Test
    public void testNotificationsDefaultToTrue() {
        assertTrue(profile.isNotifyMessages());
        assertTrue(profile.isNotifyPortfolio());
        assertTrue(profile.isNotifyNewTasks());
    }

    // [BOUNDARY] Null student ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullStudentIdThrows() {
        new StudentProfile(null, "Alice", "Smith", "a@b.com");
    }

    // [BOUNDARY] Empty student ID throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyStudentIdThrows() {
        new StudentProfile("   ", "Alice", "Smith", "a@b.com");
    }

    // [BOUNDARY] Null first name throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstNameThrows() {
        new StudentProfile("123", null, "Smith", "a@b.com");
    }

    // [BOUNDARY] Empty first name throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFirstNameThrows() {
        new StudentProfile("123", "", "Smith", "a@b.com");
    }

    // [BOUNDARY] Null last name throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullLastNameThrows() {
        new StudentProfile("123", "Alice", null, "a@b.com");
    }

    // [BOUNDARY] Empty last name throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyLastNameThrows() {
        new StudentProfile("123", "Alice", "", "a@b.com");
    }

    // [BOUNDARY] Null email throws
    @Test(expected = IllegalArgumentException.class)
    public void testNullEmailThrows() {
        new StudentProfile("123", "Alice", "Smith", null);
    }

    // [BOUNDARY] Email missing '@' throws
    @Test(expected = IllegalArgumentException.class)
    public void testEmailMissingAtSignThrows() {
        new StudentProfile("123", "Alice", "Smith", "invalidemail");
    }

    // [INVERSE] Preferred name can be changed and reset to original
    @Test
    public void testPreferredNameCanBeResetToOriginal() {
        String original = profile.getPreferredName();
        profile.setPreferredName("Teddy");
        profile.setPreferredName(original);
        assertEquals(original, profile.getPreferredName());
    }

    // [INVERSE] Notification setting can be toggled off and back on
    @Test
    public void testNotificationCanBeToggled() {
        profile.setNotifyMessages(false);
        assertFalse(profile.isNotifyMessages());
        profile.setNotifyMessages(true);
        assertTrue(profile.isNotifyMessages());
    }

    // [CROSS-CHECK] toString contains email
    @Test
    public void testToStringContainsEmail() {
        assertTrue(profile.toString().contains(profile.getEmail()));
    }

    // [CROSS-CHECK] toString contains student ID
    @Test
    public void testToStringContainsStudentId() {
        assertTrue(profile.toString().contains(profile.getStudentId()));
    }

    // [ERROR] setPreferredName with null throws
    @Test(expected = IllegalArgumentException.class)
    public void testSetPreferredNameNullThrows() {
        profile.setPreferredName(null);
    }

    // [ERROR] setPreferredName with blank string throws
    @Test(expected = IllegalArgumentException.class)
    public void testSetPreferredNameEmptyThrows() {
        profile.setPreferredName("   ");
    }
}
