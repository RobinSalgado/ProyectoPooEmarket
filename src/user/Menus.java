package user;

import java.util.Scanner;

import order.Order;
import util.InitializeUsers;
import util.InitializeProducts;
import util.IntroProduct;


public class Menus {
	InitializeProducts containsProd;
	InitializeUsers u; 
	private String nombreUsrActual;//Para registrar el key del usurio que ha iniciado sesion


	public Menus() {
		containsProd = new InitializeProducts();
		this.u = new InitializeUsers();
		this.setNombreUsrActual("");
	}
	public void cleanConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/*No hacer nada*/
		}
	}
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
		Menus m = new Menus();
		Customer newCustomer = new Customer();

		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Introduzca usuario: ");
		String inpUser = keyBoard.nextLine();
		newCustomer.setUser(inpUser);

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
		m.cleanConsole();
	}//Fin de signUp.

	public void menuPrincipal() {
		cleanConsole();
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion:\n"
				+"-------------------\n"
				+"1) Hacer una compra\n"
				+"2) Actualizar perfil\n"
				+"3) Ver historial de compras\n"
				+"4) Poner producto a la venta");
		String inpUsr = keyBoard.nextLine();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		if ( intInpUsr > 4 || intInpUsr < 1) {
			System.err.println("Opcion no valida\n");
			menuPrincipal();
		} else {
			switch(intInpUsr) {
			case 1: menuCompra();break;
			case 2: updateProfileMenu();break;
			case 4: addNewProductToSell();break;
			}
		}	
	}// Fin de menuPrincipal

	public void menuCompra() {
		Order o = new Order();
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
		Integer intInpUsr = Integer.parseInt(inpUsr);
		switch(intInpUsr) {
		case 1: 
			menuPrincipal();
			break;
		case 2: 
			menuProductos();
			break;
		case 3:
			menuCarrito();
			break;
		case 4:
			o.SendProd(this.u, this.nombreUsrActual);
		default: 
			System.err.println("Opcion invalida");
			break;
		}

	}// Fin de menuCompra

	public void menuProductos() {
		cleanConsole();
		System.out.println(); //Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de productos:\n"
				+"--------------------------------\n"
				+"1) Regresar\n"
				+"2) Lista de productos - Agregar a carrito\n"
				+"3) Ver carrito\n");
		String inpUsr = keyBoard.nextLine();
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
				menuCarrito();
				System.out.println("Presione 'ENTER' para regresar...");
				inpUsr = keyBoard.nextLine();
				if (inpUsr.isEmpty()) {
					menuProductos();
				}else {
					System.err.println("Presione 'ENTER' para regresar...\n");
					inpUsr = keyBoard.nextLine();
					while(  !inpUsr.isEmpty()) {
						System.err.println("Presione 'ENTER' para regresar...\n");
						inpUsr = keyBoard.nextLine();
					}
					menuProductos();

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
				+"1) Regresar\n"
				+"2) Ver productos en el carrito\n"
				+"3) Eliminar productos del carrito\n"
				+"4) Quitar TODOS los productos en el carrito\n");
		String inpUser = keyBoard.nextLine();
		Integer intInpUser = Integer.parseInt(inpUser);

		switch ( intInpUser) {
		case 1: menuProductos();
		case 2: 
			containsProd.seeCar();
			System.out.println();
			System.out.println("Presione 'ENTER' para regresar...\n");
			inpUser = keyBoard.nextLine();
			if (inpUser.isEmpty()) { 
				menuProductos();
			}else {
				System.err.println(" Presione ENTER para regresar:\n");
				inpUser = keyBoard.nextLine();
				while(!inpUser.isEmpty() ) {
					System.err.println(" Presione ENTER para regresar:\n");
					inpUser = keyBoard.nextLine();
				}
				menuCarrito();
			}break;

		case 3: deleteProduct();break;
		case 4: containsProd.eliminateCarr();break;

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
		Integer intInpUsr = Integer.parseInt(inpUsr);

		switch ( intInpUsr ) {
		case 1: menuPrincipal();   

		case 2:
			System.out.println("Ingrese nuevo nombre de usuario:");
			inpUsr = keyBoard.nextLine();
			u.updateProfile(intInpUsr,usrName,inpUsr);		
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
