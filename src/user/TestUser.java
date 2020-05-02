package user;

import util.initializeUsers;

public class TestUser {

	public static void main(String[] args) {
		
		initializeUsers u = new initializeUsers();
		u.loadUsers();
		Customer Cstmr = new Customer();
//		Cstmr.signUp();
//		System.out.println(u.users.entrySet());
		Cstmr.logIn();

	}

}
