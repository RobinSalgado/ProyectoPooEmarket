package order;

import java.util.Scanner;
import info.ShippingInfo;
import util.InitializeUsers;
import util.IntroCard;



public class Order {
    private String orderId;
    private String dateCreated;
    private String dateShipped;
    private ShippingInfo shippingInfo;
    private OrderDetails orderDetails;
    
    public void SendProd(InitializeUsers usr, String usrName) {
    	IntroCard cards = new IntroCard();
    	Scanner keyBoard = new Scanner(System.in);
    	System.out.println("Ingrese el tipo de envio:\n"
    			+ "1) Envio Rapido\n"
    			+ "2) Normal\n");
    	String inpUsr = keyBoard.nextLine();
    	Integer intInpUsr = Integer.parseInt(inpUsr);
    	ShippingInfo sendInfo = new ShippingInfo();
    	switch(intInpUsr) {
    	case 1: sendInfo.setShippingType("Envio Rapido");break;
    	case 2: sendInfo.setShippingType("Normal");break;
    	}
    	
    	System.out.println("Ingrese su Codigo Postal:");
    	inpUsr = keyBoard.nextLine();
    	intInpUsr = Integer.parseInt(inpUsr);
    	sendInfo.setZipCodeRecipient(intInpUsr);
    	
    	System.out.println("Ingrese su direccion:\n"
    			+ "e.g.(4467 de la calle Thompson,Col. Valle Verde)");
    	inpUsr = keyBoard.nextLine();

    	//Modificar el Address que está en customer y hasmp
    	System.out.println(usr.getUsers().get(usrName));

    	cards.RegCard();
    	//Agregando tarjetas
    	
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
