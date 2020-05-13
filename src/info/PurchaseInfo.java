package info;

import details.PurchaseDetails;
import info.interfaces.IInfo;

import java.util.Date;

public class PurchaseInfo implements IInfo<PurchaseInfo> {
    private String orderId;
    private Date dateCreated;
    private Date dateShipped;
    private ShippingInfo shippingInfo;
    private PurchaseDetails purchaseDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PurchaseDetails getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(PurchaseDetails purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    @Override
    public PurchaseInfo getInfo() {
        return this;
    }

    @Override
    public String toString() {
        return "PurchaseInfo: " + orderId + '\n' +
                "dateCreated: " + dateCreated + '\n' +
                "dateShipped: " + dateShipped + '\n' +
                shippingInfo + "\n" +
                purchaseDetails;
    }
}
