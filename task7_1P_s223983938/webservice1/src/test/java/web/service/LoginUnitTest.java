package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginUnitTest {
	
	@Test
    public void testLoginServiceConstructor() {
     
        new LoginService();
    }


    @Test
    public void testLogin_ValidCredentials_ReturnsTrue() {

        Assert.assertTrue("Valid credentials should return true", 
            LoginService.login("teddy", "password", "2026-04-18"));
    }


    @Test
    public void testLogin_InvalidUsername_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("wrong_user", "password", "2026-04-18"));
    }

    @Test
    public void testLogin_InvalidPassword_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("teddy", "wrong_pass", "2026-04-18"));
    }

    @Test
    public void testLogin_InvalidDob_ReturnsFalse() {
    
        Assert.assertFalse(LoginService.login("teddy", "password", "1999-01-01"));
    }

    @Test
    public void testLogin_AllInvalidCredentials_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("admin", "123456", "2000-12-31"));
    }

    @Test
    public void testLogin_UsernameCaseSensitive_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("Teddy", "password", "2026-04-18"));
    }

    @Test
    public void testLogin_PasswordCaseSensitive_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("teddy", "PASSWORD", "2026-04-18"));
    }

  
    @Test
    public void testLogin_EmptyStrings_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testLogin_TrailingWhitespace_ReturnsFalse() {
        Assert.assertFalse(LoginService.login("teddy ", "password", "2026-04-18"));
    }

    @Test
    public void testLogin_NullValues_ReturnsFalse() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }


    @Test
    public void testLogin_IncorrectDobFormatSlash_ReturnsFalse() {
    
        Assert.assertFalse(LoginService.login("teddy", "password", "2026/04/18"));
    }
    
    @Test
    public void testLogin_IncorrectDobFormatReversed_ReturnsFalse() {

        Assert.assertFalse(LoginService.login("teddy", "password", "18-04-2026"));
    }
}