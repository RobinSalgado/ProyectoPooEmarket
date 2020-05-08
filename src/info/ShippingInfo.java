package info;

import info.interfaces.IInfo;

public class ShippingInfo implements IInfo<ShippingInfo> {
    private String shippingId; // "SHIPPING-32427230572395"
    private String shippingType;
    private double shippingCost;
    private int zipCodeOrigin;
    private int zipCodeRecipient;
    private String dateCreated;
    private String dateShipped;

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

    @Override
    public ShippingInfo getInfo() {
        return this;
    }

    @Override
    public String toString() {
        return "shippingId: " + shippingId
                + "zipCodeOrigin: " + zipCodeOrigin 
                + "zipCodeRecipient: " + zipCodeRecipient
                + "dateCreated: " + dateCreated 
                + "dateShipped: " + dateShipped 
                + "shippingType: " + shippingType 
                + "shippingCost:" + shippingCost  ;
    }

    
}
