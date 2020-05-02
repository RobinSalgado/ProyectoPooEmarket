package user;

import java.util.Scanner;

public class Menus {

	public void menuPrincipal() {
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opción:\n"
				+"1) Hacer una compra\n"
				+"2) Actualizar perfil\n"
				+"3) Ver historial de compras\n");
		String inpUsr = keyBoard.nextLine();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		if ( intInpUsr > 3 || intInpUsr < 1) {
			System.err.println("Opción no valida\n");
			menuPrincipal();
		} else {
			switch(intInpUsr) {
			case 1: menuCompra();
			case 2: menuProductos();
			}
		}	
	}// Fin de menuPrincipal

	public void menuCompra() {
		System.out.println();//Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opción de compra:\n"
				+"1) Regresar\n"
				+"2) Ver productos - hacer compra\n "
				+"3) Ordenar compra\n"
				+"4) Ver carrito\n");
		String inpUsr = keyBoard.nextLine();
		Integer intInpUsr = Integer.parseInt(inpUsr);

		if ( intInpUsr < 0 || intInpUsr > 4) {

		}
		switch(intInpUsr) {
		case 1: menuPrincipal();
		case 2: 
		}
	}// Fin de menuCompra

	public void menuProductos() {
		System.out.println(); //Espaciado--
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Ingrese una opción de productos:\n"
				+"1) Regresar\n"
				+"2) Lista de productos\n"
				+"3) Agregar a carrito\n"
				+"4) Ver carrito\n");
		String inpUsr = keyBoard.nextLine();
		Integer intInpUsr = Integer.parseInt(inpUsr);
		
		if ( intInpUsr < 1 || intInpUsr > 4) {
			System.err.println("Opción no valida\n");
			menuProductos();
		}else {
			switch(intInpUsr) {
			case 1: menuCompra();
			case 2: System.out.println("Que se muestren todos los productos que faltan");
			case 3: System.out.println("Crear un HshMp para almacenar productos");
			case 4: System.out.println("Mostrar los productos que hay en carrito");
			}
		}
	}// Fin menuProductos


}
