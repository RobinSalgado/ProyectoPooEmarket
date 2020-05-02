package util;

import enums.AccountType;
import enums.BankType;
import enums.CardType;
import info.CardInfo;
import user.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class initializeUsers extends genID{
    public Map<String, Customer> users;
    public initializeUsers() {
        this.users = new HashMap<>();
    }

    public void loadUsers() {
///////////////////////////CUSTOMER 3
        Customer c1 = new Customer();
        c1.setUserID(genID("User"));
        c1.setPassword("123");
        c1.setLoginStatus(true);
        c1.setRegisterDate("28-04-2020");
        c1.setName("Juan Pablo");
        c1.setLastName("Jaime Gonzales");
        c1.setEmail("juanpablo@avansys.com");

        //----Card Info del primer usuario ----
        CardInfo cardInfoC1 = new CardInfo();
        cardInfoC1.setCardID(genID("Card"));
        cardInfoC1.setCardName("Juan Pablo Jaime Gonzales");
        cardInfoC1.setCardNumber("1459 1789 7859 0981");
        cardInfoC1.setCvvNumber(123);
        cardInfoC1.setCardType(CardType.DEBITO);
        cardInfoC1.setExpirationDate("12/20");
        cardInfoC1.setAddressCard("Zapopan, Jalisco");
        cardInfoC1.setBankEmisor(BankType.SANTANDER);
        cardInfoC1.setPaymentType("Completo");
        //---- fin del card Info -------
        //----- List de tarjetas del usuario 1
        List<CardInfo> cardsc1 = new ArrayList<>();
        cardsc1.add(cardInfoC1);
        //-------fin del list

        c1.setAccountBalance(1200.78);
        c1.setCustomerAddress("Zapopan, Jalisco");
        c1.setAccountType(AccountType.PREMIUM);
        // Fin del seteo del customer 1
        addUser(c1);

///////////////////////////CUSTOMER 2
        Customer c2 = new Customer();
        c2.setUserID(genID("User"));
        c2.setPassword("123");
        c2.setLoginStatus(true);
        c2.setRegisterDate("28-04-2020");
        c2.setName("Moises Robin");
        c2.setLastName("Salgado de Anda");
        c2.setEmail("RobinSalgado@outlook.com");
//----Card Info del segundo usuario ----
        //TARJETA 1 DEL SEGUNDO USUARIO
        CardInfo cardInfoC2_1 = new CardInfo();
        cardInfoC2_1.setCardID(genID("Card"));
        cardInfoC2_1.setCardName("Robin Moises Salgado ");
        cardInfoC2_1.setCardNumber("1459 1789 7859 0982");
        cardInfoC2_1.setCvvNumber(111);
        cardInfoC2_1.setCardType(CardType.CREDITO);
        cardInfoC2_1.setExpirationDate("09/20");
        cardInfoC2_1.setAddressCard("Zapopan, Jalisco");
        cardInfoC2_1.setBankEmisor(BankType.BANAMEX);
        cardInfoC2_1.setPaymentType("Completo");
        //TARJETA 2 DEL SEGUNDO USUARIO
        CardInfo cardInfoC2_2 = new CardInfo();
        cardInfoC2_2.setCardID(genID("Card"));
        cardInfoC2_2.setCardName("Robin Moises Salgado ");
        cardInfoC2_2.setCardNumber("1459 1789 7859 0983");
        cardInfoC2_2.setCvvNumber(122);
        cardInfoC2_2.setCardType(CardType.CREDITO);
        cardInfoC2_2.setExpirationDate("07/20");
        cardInfoC2_2.setAddressCard("Zapopan, Jalisco");
        cardInfoC2_2.setBankEmisor(BankType.BBVA);
        cardInfoC2_2.setPaymentType("Completo");
//---- fin del card Info -------

//----- List de tarjetas del usuario 2
        List<CardInfo> cardsc2 = new ArrayList<>();
        cardsc2.add(cardInfoC2_1);
        cardsc2.add(cardInfoC2_2);
//-------fin del list

        c2.setAccountBalance(1900.89);
        c2.setCustomerAddress("Zapopan, Jalisco");
        c2.setAccountType(AccountType.PREMIUM_PLUS);
// Fin del seteo del customer 2
       addUser(c2);

///////////////////////////CUSTOMER 3
        Customer c3 = new Customer();
        c3.setUserID(genID("User"));
        c3.setPassword("123");
        c3.setLoginStatus(true);
        c3.setRegisterDate("28-04-2020");
        c3.setName("Rodrigo");
        c3.setLastName("Alvarez Teytud");
        c3.setEmail("Rodrigo_IGO1600@outlook.com");
        //----Card Info del segundo usuario ----
        //TARJETA 1 DEL TERCER USUARIO
        CardInfo cardInfoC3_1 = new CardInfo();
        cardInfoC3_1.setCardID(genID("Card"));
        cardInfoC3_1.setCardName("Rodrigo Alvarez Teytud");
        cardInfoC3_1.setCardNumber("1459 1789 7859 0945");
        cardInfoC3_1.setCvvNumber(145);
        cardInfoC3_1.setCardType(CardType.DEBITO);
        cardInfoC3_1.setExpirationDate("11/22");
        cardInfoC3_1.setAddressCard("Uruapan, Michoacan");
        cardInfoC3_1.setBankEmisor(BankType.BBVA);
        cardInfoC3_1.setPaymentType("Completo");
//---- fin del card Info -------

        //----- List de tarjetas del usuario 2
        List<CardInfo> cardsc4 = new ArrayList<>();
        cardsc4.add(cardInfoC3_1);
//-------fin del list

        c3.setAccountBalance(1500.89);
        c3.setCustomerAddress("Uruapan, Michoacan");
        c3.setAccountType(AccountType.FREE);
// Fin del seteo del customer 2
        addUser(c3);
    }
    public void addUser(Customer customer) {

        users.put(customer.getUser(), customer);

    }
}
