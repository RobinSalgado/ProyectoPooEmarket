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

public class initializeUsers {
    Map<String, Customer> users;
    public initializeUsers() {
        this.users = new HashMap<>();
    }

    public void loadUsers() {
        Customer c1 = new Customer();
        c1.setUserID("User-1");
        c1.setPassword("123456789");
        c1.setLoginStatus(true);
        c1.setRegisterDate("28-04-2020");
        c1.setName("Juan Pablo");
        c1.setLastName("Jaime Gonzales");
        c1.setEmail("juanpablo@avansys.com");

        //----Card Info del primer usuario ----
        CardInfo cardInfoC1 = new CardInfo();
        cardInfoC1.setCardID("CARD-1");
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
        List<CardInfo> cards = new ArrayList<>();
        cards.add(cardInfoC1);
        //-------fin del list

        c1.setAccountBalance(1200.78);
        c1.setCustomerAddress("Zapopan, Jalisco");
        c1.setAccountType(AccountType.PREMIUM);
        // Fin del seteo del customer 1
        users.put(c1.getUserID(), c1);
    }

    public void addUser(Customer customer) {
        users.put(customer.getUserID(), customer);
    }
}
