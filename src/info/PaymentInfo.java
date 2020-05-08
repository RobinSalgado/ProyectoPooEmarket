package info;

import info.interfaces.IInfo;

public class PaymentInfo implements IInfo<PaymentInfo> {
    private String transactionId;
    private CardInfo cardInfo;
    private String promotionCode;
    private String paymentDetails;
    private Boolean paymentStatus;
    private double subTotal;
    private double total;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public PaymentInfo getInfo() {
        return this;
    }

    @Override
    public String toString() {
        return "transactionId:" + transactionId + "\n"
                + "paymentStatus:" + paymentStatus + "\n"
                + cardInfo + "\n"
                + "subTotal: " + subTotal + "\n"
                + "total=" + total + "\n";
    }

    
}
