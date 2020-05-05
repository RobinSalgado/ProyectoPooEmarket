package info;

import info.interfaces.IInfo;

public class ShippingInfo implements IInfo {
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
    public Object getInfo() {
        return null;
    }

    public String showInfo(){
        return "ID de entrega: " + getShippingId() + "\nTipo de entrega: " + getShippingType() + "\nCosto de entrega: " + getShippingCost() + "\nCP Origen: " + getZipCodeOrigin() + "\nCP Entrega: " + getZipCodeRecipient() +
                "\nFecha de registro: " + getDateCreated() + "\nFecha de envío: " + getDateShipped();
    }
}
