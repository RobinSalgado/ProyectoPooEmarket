package util;

import user.Customer;
import user.Menus;

import java.util.Scanner;

public class Session {
    private InitializeUsers users;

    public Session() {
        users = new InitializeUsers();
    }
    public void logIn() {
        /*Se registra el nombre de usuario.*/
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Introduzca su usuario: ");
        String inpUser = keyBoard.nextLine();
        /*Validamos que el usuario estï¿½ registrado.*/
        boolean validUser = this.users.getUsers().containsKey(inpUser);
        /*Si no estï¿½ registrado se le vuelve a pedir el nombre de usuario.*/
        while( !validUser ) {
            System.out.println();
            System.err.println("Nombre de usuario "+ "(--'"+inpUser+"'--)"
                    +" NO registrado");
            System.out.println("Introduzca nuevamente el usuario: ");
            inpUser = keyBoard.nextLine();
            validUser =(this.users.getUsers().containsKey(inpUser));
        }

        /*Se registra la contraseï¿½a.*/
        System.out.println("Introduzca su contraseï¿½a: ");
        String inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
        /*Cargamos la contraseï¿½a que estï¿½ en nuestro sistema.*/
        Customer current = (Customer) this.users.getUsers().get(inpUser);
        /*Se valida que concuerden las contraseï¿½as introduzida vs sistema.*/
        boolean validPass = current.getPassword().equalsIgnoreCase(inpPass);

        while ( !validPass ) {
            System.out.println();
            System.err.println("Contraseï¿½a INCORRECTA");
            System.out.println("Introduzca nuevamente su contraseï¿½a: ");
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
        Customer newCustomer = new Customer();
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Introduzca un nombre de usuario: ");
        String inpUser = keyBoard.nextLine();
        newCustomer.setUser(inpUser);

        System.out.println("Introduzca su nueva contraseña: ");
        inpUser = keyBoard.nextLine();
        newCustomer.setPassword(inpUser);

        System.out.println("Registre su nombre real: ");
        inpUser = keyBoard.nextLine();
        newCustomer.setName(inpUser);

        System.out.println("Registre sus apellidos: ");
        inpUser = keyBoard.nextLine();
        newCustomer.setLastName(inpUser);

        System.out.println("Ingrese su correo electrï¿½nico: ");
        inpUser = keyBoard.nextLine();
        newCustomer.setEmail(inpUser);

        newCustomer.setRegisterDate("30-04-2020");
//		keyBoard.close();
        System.out.println(this);
        this.users.addUser(newCustomer);
        //System.out.println("\n");
    }//Fin de signUp.
}
