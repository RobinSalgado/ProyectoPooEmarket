package info;

import enums.BankType;
import enums.CardType;
import info.interfaces.IInfo;

public class CardInfo implements IInfo {
    private String cardID;
    private String cardName;
    private String cardNumber;
    private Integer cvvNumber;
    private CardType cardType;
    private String expirationDate;
    private String addressCard;
    private BankType bankEmisor;
    private String paymentType;

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(Integer cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAddressCard() {
        return addressCard;
    }

    public void setAddressCard(String addressCard) {
        this.addressCard = addressCard;
    }

    public BankType getBankEmisor() {
        return bankEmisor;
    }

    public void setBankEmisor(BankType bankEmisor) {
        this.bankEmisor = bankEmisor;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public Object getInfo() {
        return null;
    }
}
