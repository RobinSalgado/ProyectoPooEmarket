package user;

import util.InitializeUsers;
import util.Session;

public class TestUser {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		initializeUsers u = new initializeUsers();
		Customer Cstmr = new Customer();
		Cstmr.signUp();
		System.out.println(u.users.keySet());
		Cstmr.logIn();

=======
		Session session = new Session();
		session.signUp();
		session.logIn();
>>>>>>> 855a8f0533c71636859f5e30a2e53f1d78c1d20c
	}

}
