package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {


	public static boolean login(String username, String password, String dob) {
		//
		if ("teddy".equals(username) && "123".equals(password)) {
			return true;
		}
		return false;
	}
	
	
}
