package sit707_week4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginFormTest {

    private static String USERNAME = "teddy";
    private static String PASSWORD = "tedd";
    private static String VALIDATION_CODE = "123456";

    @Test
    public void test01_StudentIdentity() {
        String studentId = "223983938";
        System.out.println("Running test01: Student Identity check...");
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void test02_StudentName() {
        String studentName = "Teddy";
        System.out.println("Running test02: Student Name check...");
        Assert.assertNotNull("Student name is null", studentName);
    }

    /* --- GROUP 1: Empty Username (R01 - R03) --- */

    @Test
    public void testR01_EmptyUser_EmptyPass() {
        System.out.println("Executing R01: Empty Username, Empty Password");
        LoginStatus status = LoginForm.login("", "");
        System.out.println("   Expected: Empty Username | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testR02_EmptyUser_WrongPass() {
        System.out.println("Executing R02: Empty Username, Wrong Password");
        LoginStatus status = LoginForm.login("", "wrong");
        System.out.println("   Expected: Empty Username | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testR03_EmptyUser_CorrectPass() {
        System.out.println("Executing R03: Empty Username, Correct Password");
        LoginStatus status = LoginForm.login("", PASSWORD);
        System.out.println("   Expected: Empty Username | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    /* --- GROUP 2: Wrong Username (R04 - R06) --- */

    @Test
    public void testR04_WrongUser_EmptyPass() {
        System.out.println("Executing R04: Wrong Username, Empty Password");
        LoginStatus status = LoginForm.login("wrong", "");
        // Note: Your code checks Empty Password before checking Wrong Username
        System.out.println("   Expected: Empty Password | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testR05_WrongUser_WrongPass() {
        System.out.println("Executing R05: Wrong Username, Wrong Password");
        LoginStatus status = LoginForm.login("wrong", "wrong");
        System.out.println("   Expected: Credential mismatch | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testR06_WrongUser_CorrectPass() {
        System.out.println("Executing R06: Wrong Username, Correct Password");
        LoginStatus status = LoginForm.login("wrong", PASSWORD);
        System.out.println("   Expected: Credential mismatch | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    /* --- GROUP 3: Correct Username (R07 - R08) --- */

    @Test
    public void testR07_CorrectUser_EmptyPass() {
        System.out.println("Executing R07: Correct Username, Empty Password");
        LoginStatus status = LoginForm.login(USERNAME, "");
        System.out.println("   Expected: Empty Password | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testR08_CorrectUser_WrongPass() {
        System.out.println("Executing R08: Correct Username, Wrong Password");
        LoginStatus status = LoginForm.login(USERNAME, "wrong");
        System.out.println("   Expected: Credential mismatch | Actual: " + status.getErrorMsg());
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    /* --- GROUP 4: Validation Code (R09 - R11) --- */

    @Test
    public void testR09_CorrectUser_CorrectPass_EmptyCode() {
        System.out.println("Executing R09: Correct Credentials, Empty Validation Code");
        LoginStatus status = LoginForm.login(USERNAME, PASSWORD);
        // Step 1 Success check
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals(VALIDATION_CODE, status.getErrorMsg());
        
        // Step 2 check
        boolean isCodeValid = LoginForm.validateCode("");
        System.out.println("   Code check: Expected false | Actual: " + isCodeValid);
        Assert.assertFalse(isCodeValid);
    }

    @Test
    public void testR10_CorrectUser_CorrectPass_WrongCode() {
        System.out.println("Executing R10: Correct Credentials, Wrong Validation Code");
        LoginStatus status = LoginForm.login(USERNAME, PASSWORD);
        Assert.assertTrue(status.isLoginSuccess());
        
        boolean isCodeValid = LoginForm.validateCode("0000");
        System.out.println("   Code check: Expected false | Actual: " + isCodeValid);
        Assert.assertFalse(isCodeValid);
    }

    @Test
    public void testR11_CorrectUser_CorrectPass_CorrectCode() {
        System.out.println("Executing R11: Correct Credentials, Correct Validation Code (SUCCESS PATH)");
        LoginStatus status = LoginForm.login(USERNAME, PASSWORD);
        Assert.assertTrue(status.isLoginSuccess());
        
        boolean isCodeValid = LoginForm.validateCode(VALIDATION_CODE);
        System.out.println("   Code check: Expected true | Actual: " + isCodeValid);
        Assert.assertTrue(isCodeValid);
    }
}