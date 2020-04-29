package info;

import enums.ProductBrands;
import enums.ProductType;
import info.interfaces.IInfo;

public class ProductInfo implements IInfo {
    private String orderID;
    private String productName;
    private double cost;
    private String description;
    private ProductBrands productBrand;
    private ProductType productType;
    @Override
    public Object getInfo() {
        return null;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductBrands getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrands productBrand) {
        this.productBrand = productBrand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
