package util;

import user.Customer;
import user.Menus;

import java.util.Map;
import java.util.Scanner;

import info.ProductInfo;

public class Session {
    private InitializeUsers users;
    public String nombreUsrActual;//Para registrar el key del usurio que ha iniciado sesion

    public Session() {
        users = new InitializeUsers();
    }
    public void logIn() {
        /*Se registra el nombre de usuario.*/
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Introduzca su usuario: ");
        String inpUser = keyBoard.nextLine();
        this.nombreUsrActual = inpUser;
        /*Validamos que el usuario este registrado.*/
        boolean validUser = this.users.getUsers().containsKey(inpUser);
        /*Si no esta registrado se le vuelve a pedir el nombre de usuario.*/
        while( !validUser ) {
            System.out.println();
            System.err.println("Nombre de usuario "+ "(--'"+inpUser+"'--)"
                    +" NO registrado");
            System.out.println("Introduzca nuevamente el usuario: ");
            inpUser = keyBoard.nextLine();
            validUser =(this.users.getUsers().containsKey(inpUser));
        }

        /*Se registra la contrasena.*/
        System.out.println("Introduzca su contrasena: ");
        String inpPass = keyBoard.nextLine(); // Obtiene entradas del usuario.
        /*Cargamos la contrasena que esta en nuestro sistema.*/
        Customer current = (Customer) this.users.getUsers().get(inpUser);
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

        Menus m = new Menus();
        m.menuPrincipal();
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
        this.users.addUser(newCustomer);
        System.out.println("SingUp EXITOSO");
        System.out.println("\n"); // Espaciado para dar formato en consola
        m.cleanConsole();
    }//Fin de signUp.
    

}
