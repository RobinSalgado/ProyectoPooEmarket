package user;

import details.PurchaseDetails;
import enums.AccountType;
import info.CardInfo;
import info.PurchaseInfo;

import java.util.ArrayList;
import java.util.List;


public class Customer extends User {
	private String name;
	private String lastName;
	private String email;
	private List<CardInfo> cardsInfo; // puede registrar una o mas tarjetas
	private double accountBalance;
	private String customerAddress;
	private AccountType accountType;
	private PurchaseInfo purchaseInfo;

	public PurchaseInfo getPurchaseInfo() {
		return purchaseInfo;
	}

	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}

	public Customer() {
		this.cardsInfo = new ArrayList<>();
	}
	// Inicio de setters & getters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CardInfo> getCardsInfo() {
		return cardsInfo;
	}

	public void setCardsInfo(List<CardInfo> cardsInfo) {
		this.cardsInfo = cardsInfo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void addCard(CardInfo newCard){
		this.cardsInfo.add(newCard);
	}


	// Fin de setters & getters.
} // Fin de la clase.



