package info;

import info.interfaces.IInfo;

import java.util.Date;

public class ShippingInfo implements IInfo<ShippingInfo> {
    private String shippingId; // "SHIPPING-32427230572395"
    private String shippingType;
    private double shippingCost;
    private int zipCodeOrigin;
    private int zipCodeRecipient;
    private Date dateCreated;
    private Date dateShipped;

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getZipCodeOrigin() {
        return zipCodeOrigin;
    }

    public void setZipCodeOrigin(int zipCodeOrigin) {
        this.zipCodeOrigin = zipCodeOrigin;
    }

    public int getZipCodeRecipient() {
        return zipCodeRecipient;
    }

    public void setZipCodeRecipient(int zipCodeRecipient) {
        this.zipCodeRecipient = zipCodeRecipient;
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

    @Override
    public ShippingInfo getInfo() {
        return this;
    }

    @Override
    public String toString() {
        return "shippingId: " + shippingId + "\n"
                + "zipCodeOrigin: " + zipCodeOrigin + "\n"
                + "zipCodeRecipient: " + zipCodeRecipient + "\n"
                + "dateCreated: " + dateCreated + "\n"
                + "dateShipped: " + dateShipped + "\n"
                + "shippingType: " + shippingType + "\n"
                + "shippingCost:" + shippingCost  + "\n";
    }

    
}
