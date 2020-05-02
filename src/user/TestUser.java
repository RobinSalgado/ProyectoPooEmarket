package user;

import util.initializeUsers;

public class TestUser {

	public static void main(String[] args) {
		
		initializeUsers u = new initializeUsers();
		Customer Cstmr = new Customer();
		Cstmr.signUp();
		System.out.println(u.users.keySet());
		Cstmr.logIn();

	}

}
