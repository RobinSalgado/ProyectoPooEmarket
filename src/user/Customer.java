package user;

import enums.AccountType;
import info.CardInfo;
import util.initializeUsers;

import java.util.List;
import java.util.Scanner; // I use scanner because it's command line.


public class Customer extends User {
	private String name;
	private String lastName;
	private String email;
	private List<CardInfo> cardsInfo; // puede registrar una o más tarjetas
	private double accountBalance;
	private String customerAddress;
	private AccountType accountType;

	// Inicio de setters & getters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CardInfo> getCardsInfo() {
		return cardsInfo;
	}

	public void setCardsInfo(List<CardInfo> cardsInfo) {
		this.cardsInfo = cardsInfo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	// Fin de setters & getters.

	public void logIn() {
		/*Cargamos los usuarios registrados.*/
		initializeUsers u = new initializeUsers();
		u.loadUsers();
		/*Se registra el nombre de usuario.*/
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Introduzca su usuario: ");
		String inpUser = keyBoard.nextLine();
		/*Validamos que el usuario est� registrado.*/
		boolean validUser = u.users.containsKey(inpUser);
		/*Si no est� registrado se le vuelve a pedir el nombre de usuario.*/
		while( !validUser ) {
			System.out.println();
			System.err.println("Nombre de usuario "+ "(--'"+inpUser+"'--)"
					+" NO registrado"); 
			System.out.println("Introduzca nuevamente el usuario: ");
			inpUser = keyBoard.nextLine();
			validUser =(u.users.containsKey(inpUser));		
		}

		/*Se registra la contrase�a.*/
		System.out.println("Introduzca su contrase�a: ");
		String inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
		/*Cargamos la contrase�a que est� en nuestro sistema.*/
		Customer current = u.users.get(inpUser);
		/*Se valida que concuerden las contrase�as introduzida vs sistema.*/
		boolean validPass = current.getPassword().equalsIgnoreCase(inpPass); 

		while ( !validPass ) {
			System.out.println();
			System.err.println("Contrase�a INCORRECTA");
			System.out.println("Introduzca nuevamente su contrase�a: ");
			inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
			validPass = current.getPassword().equalsIgnoreCase(inpPass);
		}
		System.out.println();
		System.out.println("Login EXITOSO");
		
		Menus m = new Menus();
		m.menuPrincipal();
		keyBoard.close();
	}//Fin de logIn.

	public void signUp() {
		Customer newCstmr = new Customer();
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Introduzca un nombre de usuario: ");
		String inpUser = keyBoard.nextLine();
		newCstmr.setUser(inpUser);

		System.out.println("Introduzca su nueva contrase�a: ");
		inpUser = keyBoard.nextLine();
		newCstmr.setPassword(inpUser);

		System.out.println("Registre su nombre real: ");
		inpUser = keyBoard.nextLine();
		newCstmr.setName(inpUser);

		System.out.println("Registre sus apellidos: ");
		inpUser = keyBoard.nextLine();
		newCstmr.setLastName(inpUser);

		System.out.println("Ingrese su correo electr�nico: ");
		inpUser = keyBoard.nextLine();
		newCstmr.setEmail(inpUser);

		newCstmr.setRegisterDate("30-04-2020");
//		keyBoard.close();

		initializeUsers newUsr = new initializeUsers();
		newUsr.addUser(newCstmr);
	}//Fin de signUp.
	
	
} // Fin de la clase.



