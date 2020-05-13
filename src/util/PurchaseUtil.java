package util;

import details.PurchaseDetails;
import info.PaymentInfo;
import info.ProductInfo;
import info.PurchaseInfo;
import info.ShippingInfo;
import user.Menus;

import java.util.*;

public class PurchaseUtil extends genID{
    public void buyProduct(InitializeUsers usr, String usrName, InitializeProducts products) {
        PaymentInfo paymentInfo = new PaymentInfo();
        ShippingInfo sendInfo = new ShippingInfo();
        IntroCard cards = new IntroCard();
        PurchaseInfo purchase = new PurchaseInfo();
        PurchaseDetails purchaseDetails = new PurchaseDetails();
        System.out.println("Los productos que vas a comprar, son: ");
        int a = 1;
        double subTotal = 0;
        String purchaseInformation = "";
        for(String product : products.addProdToCar.keySet()) {
            purchaseInformation = purchaseInformation + " " + product;
            System.out.println(a + ".-" + product);
            subTotal += products.addProdToCar.get(product).getCost();
            a++;
        }
        System.out.println();
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Ingrese el tipo de envio:\n"
                + "1) Envio Rapido\n"
                + "2) Normal\n");
        String inpUsr = keyBoard.nextLine();
        while(!Menus.isNumber(inpUsr.charAt(0), keyBoard)) {
            System.out.println("Ingrese el tipo de envio:\n"
                    + "1) Envio Rapido\n"
                    + "2) Normal\n");
            inpUsr = keyBoard.nextLine();
        }
        // se genera el id del shipping
        sendInfo.setShippingId(genID("shipping"));
        // se genera el id de paymentInfo
        paymentInfo.setTransactionId("paymentInfo");
        // se pone la fecha de creacion como el dia de hoy
        sendInfo.setDateCreated(new Date());
        // se lee el input del usuario
        Integer intInpUsr = Integer.parseInt(inpUsr);

        // se usa la clase calendar nativa de java para que nos ayude a sumar dias para la fecha de recibo del envio
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        switch(intInpUsr) {
            case 1: sendInfo.setShippingType("Envio Rapido");
                    // si es envio rapido, es un dia despues del que se creo
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    sendInfo.setDateShipped(calendar.getTime());
                    sendInfo.setShippingCost(230.00);
                    subTotal += 230.00;
                    break;
            case 2:
                sendInfo.setShippingType("Normal");
                // si es envio rapido, es un cinco dias despues del que se creo
                calendar.add(Calendar.DAY_OF_YEAR, 5);
                sendInfo.setDateShipped(calendar.getTime());
                sendInfo.setShippingCost(120.00);
                subTotal += 120.00;
                break;
            default:
                System.out.println("opcion invalida");
                Menus.enterToContinue(keyBoard);
        }
        // se crea la fecha de realizacion por default, como la fecha de hoy

        System.out.println("Ingrese su Codigo Postal:");
        inpUsr = keyBoard.nextLine();
        while(inpUsr.length() < 5 || inpUsr.length() > 5){
            System.out.println("El codigo postal debe contener 5 digitos");
            System.out.println("Ingrese su Codigo Postal:");
            inpUsr = keyBoard.nextLine();
        }
        sendInfo.setZipCodeOrigin(45507);
        sendInfo.setZipCodeRecipient(Integer.parseInt(inpUsr));

        System.out.println("Ingrese su direccion:\n"
                + "e.g.(4467 de la calle Thompson,Col. Valle Verde)");
        inpUsr = keyBoard.nextLine();
        usr.getUsers().get(usrName).setCustomerAddress(inpUsr);

        // Si no tiene tarjetas registradas
        if(usr.getUsers().get(usrName).getCardsInfo().size() == 0) {
            System.out.println("no hay tarjetas registradas");
            paymentInfo.setCardInfo(cards.RegCard(usr.getUsers().get(usrName)));
        } else { // si si tiene tarjetas registradas
            for(int i = 1; i <usr.getUsers().get(usrName).getCardsInfo().size(); i++) {
                System.out.println(i + ".- " + usr.getUsers().get(usrName).getCardsInfo().get(i));
            }
        }

        paymentInfo.setPaymentDetails(paymentInfo.getCardInfo().toString());
        paymentInfo.setPaymentStatus(true);
        paymentInfo.setPromotionCode("No promotion code added");
        paymentInfo.setSubTotal(subTotal);
        paymentInfo.setTotal(subTotal + subTotal*.16);
        // se le setea la informacion de la compra + los detalles de la misma
        purchaseDetails.setOrderDescription("You bought:" + purchaseInformation);
        purchaseDetails.setOrderId(genID("purchaseDetails"));
        purchaseDetails.setPaymentInfo(paymentInfo);
        purchaseDetails.setQuantity(a - 1);
        List<ProductInfo> productInfoList = new ArrayList<>();
        productInfoList.add(products.addProdToCar.get(usrName));
        purchaseDetails.setProductInfo(productInfoList);
        // se le setea toda la informacion de la compra
        purchase.setDateCreated(sendInfo.getDateCreated());
        purchase.setDateShipped(sendInfo.getDateShipped());
        purchase.setOrderId(genID("purchase"));
        purchase.setShippingInfo(sendInfo);
        purchase.setPurchaseDetails(purchaseDetails);
        // se le adjunta al usuario toda la informacion de la compra realizada
        usr.getUsers().get(usrName).setPurchaseInfo(purchase);
        System.out.println("La compra fue un exito");
    }
}
