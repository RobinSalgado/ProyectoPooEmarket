package user;

import java.util.Scanner;

import user.Customer;
import exception.IlegalParseIntException;
import util.InitializeUsers;
import util.InitializeProducts;
import util.IntroProduct;
import util.PurchaseUtil;


public class Menus {
	InitializeProducts containsProd;
	InitializeUsers u; 
	private String nombreUsrActual;//Para registrar el key del usurio que ha iniciado sesion


	public Menus() {
		containsProd = new InitializeProducts();
		this.u = new InitializeUsers();
		this.setNombreUsrActual("");
	}
	private void cleanConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/*No hacer nada*/
		}
	}

	public void inicio() {
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingerese opcion de sesion:\n"
				+ "1) Iniciar sesion\n"
				+ "2) Registrar cuenta nueva\n");
		String inpUsr = keyBoard.nextLine();
		char charcter = inpUsr.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			inicio();
		Integer intInpUsr = Integer.parseInt(inpUsr);
		switch(intInpUsr) {
		case 1: logIn();break;
		case 2: signUp();break;
		default: 
			System.err.println("Opcion invalida");
			enterToContinue(keyBoard);
			inicio();
			break;
		}
	}
	public static boolean isNumber(char c, Scanner keyBoard) {
		try {
			if(!Character.isDigit(c)){
				throw new IlegalParseIntException();
			}
		}catch (IlegalParseIntException ex) {

			System.err.println("Se ingreso opcion invalida");
			enterToContinue(keyBoard);
			return false;
		}
		return true;
	}

	public static void enterToContinue(Scanner keyBoard) {
		System.out.println("Presione 'ENTER' para regresar...");
		String inpUsr = keyBoard.nextLine();
		if (!inpUsr.isEmpty()) {
			System.err.println("Presione 'ENTER' para regresar...\n");
			inpUsr = keyBoard.nextLine();
			while (!inpUsr.isEmpty()) {
				System.err.println("Presione 'ENTER' para regresar...\n");
				inpUsr = keyBoard.nextLine();
			}
		}
	}// Fin de enterToContinue.

	public void logIn() {
		/*Se registra el nombre de usuario.*/
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Introduzca su usuario: ");
		String inpUser = keyBoard.nextLine();
		setNombreUsrActual(inpUser);
		/*Validamos que el usuario este registrado.*/
		boolean validUser = this.u.getUsers().containsKey(inpUser);
		/*Si no esta registrado se le vuelve a pedir el nombre de usuario.*/
		while( !validUser ) {
			System.out.println();
			System.err.println("Nombre de usuario "+ "(--'"+inpUser+"'--)"
					+" NO registrado");
			System.out.println("Introduzca nuevamente el usuario: ");
			inpUser = keyBoard.nextLine();
			validUser =(this.u.getUsers().containsKey(inpUser));
		}

		/*Se registra la contrasena.*/
		System.out.println("Introduzca su contrasena: ");
		String inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
		/*Cargamos la contrasena que esta en nuestro sistema.*/
		Customer current = (Customer) this.u.getUsers().get(inpUser);
		/*Se valida que concuerden las contrasenas introduzida vs sistema.*/
		boolean validPass = current.getPassword().equalsIgnoreCase(inpPass);

		while ( !validPass ) {
			System.out.println();
			System.err.println("Contrasena INCORRECTA");
			System.out.println("Introduzca nuevamente su contrasena: ");
			inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
			validPass = current.getPassword().equalsIgnoreCase(inpPass);
		}
		System.out.println();
		System.out.println("Login EXITOSO");

		menuPrincipal();
		keyBoard.close();
	}//Fin de logIn.

	public void signUp() {
		Customer newCustomer = new Customer();

		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Introduzca usuario: ");
		String inpUser = keyBoard.nextLine();
		/* Validamos que no este previamente registrado el nombre de usuario.*/
		while(u.getUsers().containsKey(inpUser)) {
			System.err.println("El usuario que intentas registrar �Ya existe!");
			System.out.println("Introduzca otro usuario: ");
			inpUser = keyBoard.nextLine();
		}
			
		newCustomer.setUser(inpUser.trim());

		System.out.println("Introduzca contrasena: ");
		inpUser = keyBoard.nextLine();
		newCustomer.setPassword(inpUser);

		System.out.println("Registre su nombre: ");
		inpUser = keyBoard.nextLine();
		newCustomer.setName(inpUser);

		System.out.println("Registre sus apellidos: ");
		inpUser = keyBoard.nextLine();
		newCustomer.setLastName(inpUser);

		System.out.println("Ingrese su correo electronico: ");
		inpUser = keyBoard.nextLine();
		newCustomer.setEmail(inpUser);

		newCustomer.setRegisterDate("30-04-2020");
		this.u.addUser(newCustomer);
		System.out.println("SingUp EXITOSO");
		System.out.println("\n"); // Espaciado para dar formato en consola
		cleanConsole();
		inicio();
		keyBoard.close();
	}//Fin de signUp.

	public void menuPrincipal() {
		cleanConsole();
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion:\n"
				+"-------------------\n"
				+"1) Hacer una compra\n"
				+"2) Actualizar perfil\n"
				+"3) Poner producto a la venta");
		String inpUsr = keyBoard.nextLine();
		char charcter = inpUsr.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			menuPrincipal();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		if ( intInpUsr > 3 || intInpUsr < 1) {
			System.err.println("Opcion no valida\n");
			menuPrincipal();
		} else {
			switch(intInpUsr) {
			case 1: menuCompra();break;
			case 2: updateProfileMenu();break;
			case 3:
				addNewProductToSell();
				break;
			}
		}	
		keyBoard.close();
	}// Fin de menuPrincipal

	public void menuCompra() {
		PurchaseUtil purchase = new PurchaseUtil();
		cleanConsole();
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de compra:\n"
				+"----------------------------\n"
				+"1) Regresar\n"
				+"2) Ver productos - Agregar al carrito\n"
				+"3) Ver carrito\n"
				+"4) Ordenar/Enviar\n");
		String inpUsr = keyBoard.nextLine();
		char charcter = inpUsr.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			menuCompra();
		Integer intInpUsr = Integer.parseInt(inpUsr);
		switch(intInpUsr) {
		case 1: 
			menuPrincipal();
			break;
		case 2:
			menuProductos();
			break;
		case 3:
			if( containsProd.addProdToCar.isEmpty()) {
				System.err.println("El carrito esta vacio");
				enterToContinue(keyBoard);
				menuProductos();
			}else {
				menuCarrito();
			}
			break;
		case 4:
			if(this.containsProd.addProdToCar.isEmpty()) {
				System.out.println("no puedes comprar aun, agrega al menos un producto al carrito para comprar");
				enterToContinue(keyBoard);
				menuCompra();
			} else {
				Scanner keyBoard2 = new Scanner(System.in);
				System.out.println("1.- Regresar al menu anterior \n" +
						"2.- Comprar");
				String inpUsr2 = keyBoard.nextLine();
				while (!isNumber(inpUsr2.charAt(0), keyBoard2)) {
					System.out.println("opcion invalida, por favor ingresa opcion nuevamente");
					System.out.println("1) Regresar al menu anterior \n" +
							"2) Comprar");
					inpUsr2 = keyBoard.nextLine();
				}
				switch (Integer.valueOf(inpUsr2)) {
					case 1:
						menuCompra();
						break;
					case 2:
						purchase.buyProduct(this.u, this.nombreUsrActual, this.containsProd);
						System.out.println(this.u.getUsers().get(nombreUsrActual).getPurchaseInfo());
						enterToContinue(keyBoard);
						menuPrincipal();
						break;
					default:
						System.out.println("opcion invalida, por favor ingresa opcion nuevamente");
						menuCompra();
						break;
				}
				keyBoard2.close();
			}
			break;
		default: 
			System.err.println("Opcion invalida");
			break;
		}

	}// Fin de menuCompra

	public void menuProductos() {
		cleanConsole();
		PurchaseUtil purchase = new PurchaseUtil();
		System.out.println(); //Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de productos:\n"
				+"--------------------------------\n"
				+"1) Regresar al menu de compras\n"
				+"2) Lista de productos - Agregar a carrito\n"
				+"3) Ver carrito\n"
				+"4) Ordenar/Enviar");
		String inpUsr = keyBoard.nextLine();
		char charcter = inpUsr.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			menuProductos();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		if ( intInpUsr < 1 || intInpUsr > 4) {
			System.err.println("Opcion no valida\n");
			menuProductos();
		}else {
			switch(intInpUsr) {
			case 1: menuCompra();break;
			case 2: 
				containsProd.showProducts();
				menuProductos();
				break;

			case 3: 
				if( containsProd.addProdToCar.isEmpty()) {
					System.out.println("El carrito esta vacio");
					enterToContinue(keyBoard);
					menuProductos();
				}else {
					menuCarrito();
				}break;
			case 4:
				if( containsProd.addProdToCar.isEmpty()) {
					System.out.println("El carrito esta vacio");
					enterToContinue(keyBoard);
					menuProductos();
				}else {
					Scanner keyBoard2 = new Scanner(System.in);
					System.out.println("1) Regresar al menu anterior \n" +
							"2) Comprar");
					String inpUsr2 = keyBoard.nextLine();
					while (!isNumber(inpUsr2.charAt(0), keyBoard2)) {
						System.out.println("opcion invalida, por favor ingresa opcion nuevamente");
						System.out.println("1.- Regresar al menu anterior \n" +
								"2.- Comprar");
						inpUsr2 = keyBoard.nextLine();
					}
					switch (Integer.valueOf(inpUsr2)) {
						case 1:
							menuProductos();
							break;
						case 2:
							purchase.buyProduct(this.u, this.nombreUsrActual, this.containsProd);
							System.out.println(this.u.getUsers().get(nombreUsrActual).getPurchaseInfo());
							enterToContinue(keyBoard);
							menuPrincipal();
							break;
						default:
							System.out.println("opcion invalida, por favor ingresa opcion nuevamente");
							menuCompra();
							break;
					}
					keyBoard2.close();
				}
				break;
			}
		}
	}// Fin menuProductos

	public void menuCarrito() {
		cleanConsole();

		System.out.println();
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de carrito:\n"
				+"------------------------------\n"
				+"1) Regresar al menu productos\n"
				+"2) Ver productos en el carrito\n"
				+"3) Eliminar productos del carrito\n"
				+"4) Quitar TODOS los productos en el carrito\n");
		String inpUser = keyBoard.nextLine();
		char charcter = inpUser.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			menuCarrito();
		Integer intInpUser = Integer.parseInt(inpUser);

		switch ( intInpUser) {
		case 1: menuProductos();
		case 2: 
			containsProd.seeCar();
			System.out.println();
			enterToContinue(keyBoard);
			menuCarrito();
			break;

		case 3:
			deleteProduct();
			enterToContinue(keyBoard);
			menuCarrito();
			break;
		case 4:
			containsProd.eliminateCarr();
			enterToContinue(keyBoard);
			menuCarrito();
			break;

		}
	}

	public void menuUpdateProfile() {
		cleanConsole();
		System.out.println("Ingrese que datos desea cambiar:\n"
				+"--------------------------------\n"
				+"1) Regresar Menu Principal\n"
				+"2) Cambiar nombre de usuario\n"
				+"3) Modificar contrasena\n"
				+"4) Cambiar correo elctronico\n");
	}

	public void addNewProductToSell() {
		IntroProduct newProduct = new IntroProduct();
		newProduct.RegProduct(this.containsProd);
		menuPrincipal();
	}

	public void deleteProduct() {
		cleanConsole();
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese el num de producto que desea eliminar:\n");
		containsProd.seeCar();
		String inpUser = keyBoard.nextLine(); 
		char charcter = inpUser.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(!isNumber( charcter,keyBoard )) {
			menuCarrito();
		}

		Integer intInpUser = Integer.parseInt(inpUser);
		containsProd.eliminateProduct(intInpUser);
	}

	public void updateProfileMenu() {
		cleanConsole();
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese su nombre de usuario actual:");
		String usrName = keyBoard.nextLine();
		//-------------VALIDACION-------------------------------------------------- 	
		/*Validamos que el usuario este registrado.*/
		boolean validUser = this.u.getUsers().containsKey(usrName);
		/*Si no esta registrado se le vuelve a pedir el nombre de usuario.*/
		while( !validUser ) {
			System.out.println();
			System.err.println("Nombre de usuario "+ "(--'"+usrName+"'--)"
					+" INCORRECTO");
			System.out.println("Introduzca nuevamente el usuario actual: ");
			usrName = keyBoard.nextLine();
			validUser = this.u.getUsers().containsKey(usrName);
		}
		//-------------VALIDACION--------------------------------------------- 
		menuUpdateProfile();
		String inpUsr = keyBoard.nextLine();
		char charcter = inpUsr.charAt(0);
		/* Implementacion de excepci�n de parseo.*/ 
		if(! isNumber( charcter,keyBoard ) )
			updateProfileMenu();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		switch ( intInpUsr ) {
		case 1: menuPrincipal();   

		case 2:
			System.out.println("Ingrese nuevo nombre de usuario:");
			inpUsr = keyBoard.nextLine();
			u.updateProfile(intInpUsr,usrName,inpUsr);
			this.nombreUsrActual = inpUsr;
			menuPrincipal();
			break;
		case 3: 
			System.out.println("Ingrese una nueva contrasena:");
			inpUsr = keyBoard.nextLine();
			u.updateProfile(intInpUsr,usrName,inpUsr);
			menuPrincipal();
			break;
		case 4: 
			System.out.println("Ingrese un nuevo correo elctronico:");
			inpUsr = keyBoard.nextLine();
			u.updateProfile(intInpUsr,usrName,inpUsr);
			menuPrincipal();
			break;
		}
		//	        u.updateProfile(this.u);

	}
	public String getNombreUsrActual() {
		return nombreUsrActual;
	}
	public void setNombreUsrActual(String nombreUsrActual) {
		this.nombreUsrActual = nombreUsrActual;
	}
}//Fin de clase
