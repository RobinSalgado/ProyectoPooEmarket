package info;

import enums.GenderType;
import enums.ProductBrands;
import enums.ProductType;
import info.interfaces.IInfo;

public class ProductInfo implements IInfo<ProductInfo> {
    private String productID;
    private String productName;
    private double cost;
    private String description;
    private ProductBrands productBrand;
    private ProductType productType;
    private GenderType genderType;
    private int productStock; // para ver la existencia del producto
    
    @Override
    public ProductInfo getInfo() {
        return this;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String orderID) {
        this.productID = orderID;
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

    public GenderType getGenderType() { return genderType; }

    public void setGenderType(GenderType genderType) { this.genderType = genderType; }

    public String showInfo(){
        return "ID del producto: " + getProductID() + "\nNombre del producto: " + getProductName() + "\nPrecio: " + getCost() + "\nDescripción: " + getDescription() + "\nMarca: " + getProductBrand() +
                "\nTipo de producto: " + getProductType() + "\nGenero: " + getGenderType();
    }

    public int getProductStock() {
        return this.productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Override
    public String toString() {
        return "    cost: " + cost + "\n"
                + "    description: " + description + "\n" 
                + "    genderType: " + genderType + "\n"
                + "    productBrand: " + productBrand + "\n" 
                + "    productStock: " + productStock + "\n"
                + "    productType: " + productType + "\n"
                + "    productID: " + productID + "\n";
    }

    
}
