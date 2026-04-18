package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
        if ("teddy".equals(username) && 
            "password".equals(password) && 
            "2026-04-18".equals(dob)) {
            return true;
        }
        return false;
    }
	
	
}
