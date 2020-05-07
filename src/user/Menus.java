package user;

import java.util.Scanner;

import util.InitializeUsers;
import util.InitilizeProducts;
import util.IntroProduct;

public class Menus {
	InitilizeProducts containsProd = new InitilizeProducts();
	public void menuPrincipal() {
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion:\n"
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
			case 1: menuCompra();
			case 2: menuProductos();
			case 4: addNewProductToSell();
			}
		}	
	}// Fin de menuPrincipal

	public void menuCompra() {
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de compra:\n"
				+"1) Regresar\n"
				+"2) Ver productos - Agregar al carrito\n"
				+"3) Ordenar compra\n"
				+"4) Ver carrito\n");
		String inpUsr = keyBoard.nextLine();
		Integer intInpUsr = Integer.parseInt(inpUsr);
		switch(intInpUsr) {
			case 1: 
				menuPrincipal();
				break;
			case 2: 
				menuProductos();
				break;
			default: 
				System.err.println("Opcion invalida");
				break;
		}
		
	}// Fin de menuCompra

	public void menuProductos() {
		System.out.println(); //Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opcion de productos:\n"
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
			case 1: menuCompra();
			case 2: 
				containsProd.showProducts();
				menuProductos();
				break;

			case 3: 
				containsProd.seeCar();
				break;
			case 4: System.out.println("Mostrar los productos que hay en carrito");break;
			}
		}
	}// Fin menuProductos

	public void addNewProductToSell() {
		IntroProduct newProduct = new IntroProduct();
		newProduct.RegProduct(this.containsProd);
		menuPrincipal();
	}
}
