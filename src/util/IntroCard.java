package util;

import enums.BankType;
import enums.CardType;
import info.CardInfo;
import user.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntroCard extends genID{
    public IntroCard(){}

    public void RegCard(Customer customer){
        CardInfo newCard = new CardInfo();
        newCard.setCardID(genID("Card"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca nombre de tarjetahabiente: ");
        String sCard = sc.nextLine();
        newCard.setCardName(sCard);

        System.out.println("Introduzca numero de la tarjeta: ");
        sCard = sc.nextLine();
        while(sCard.length() < 16 || sCard.length() > 16) {
            System.out.println("el numero de tarjeta debe contener 16 digitos");
            System.out.println("Introduzca numero de la tarjeta: ");
            sCard = sc.nextLine();
        }
        newCard.setCardNumber(sCard);

        System.out.println("Introduzca numero de seguridad: ");
        String iCard = sc.nextLine();
        while(iCard.length() < 3 || iCard.length() > 3) {
            System.out.println("el numero de seguridad debe contener 3 digitos");
            System.out.println("Introduzca numero de seguridad: ");
            iCard = sc.nextLine();
        }
        newCard.setCvvNumber(Integer.valueOf(iCard));

        cardType(newCard);

        System.out.println("Introduzca fecha de expiracion: ");
        sCard = sc.nextLine();
        newCard.setExpirationDate(sCard);

        System.out.println("Introduzca direccion de factura: ");
        sCard = sc.nextLine();
        newCard.setAddressCard(sCard);

        emisorBank(newCard);

        System.out.println("Introduzca modo de pago: ");
        sCard = sc.nextLine();
        newCard.setPaymentType(sCard);
        System.out.println(newCard);
        customer.addCard(newCard);
    }

    private void cardType(CardInfo newCard){
        System.out.println("Introduzca tipo de tarjeta: \n1) DEBITO\n2) CREDITO");
        Scanner sc = new Scanner(System.in);
        Integer iCard = sc.nextInt();
        switch (iCard){
            case 1:
                newCard.setCardType(CardType.DEBITO);
                break;
            case 2:
                newCard.setCardType(CardType.CREDITO);
                break;
        }
    }

    private void emisorBank(CardInfo newCard){
        System.out.println("Introduzca banco emisor: \n1) BBVA\n2) BANAMEX \n3) SANTANDER");
        Scanner sc = new Scanner(System.in);
        Integer iCard = sc.nextInt();
        switch (iCard){
            case 1:
                newCard.setBankEmisor(BankType.BBVA);
                break;
            case 2:
                newCard.setBankEmisor(BankType.BANAMEX);
                break;
            case 3:
                newCard.setBankEmisor(BankType.SANTANDER);
                break;
        }
    }


}
