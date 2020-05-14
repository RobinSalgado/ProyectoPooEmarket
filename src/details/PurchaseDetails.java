package details;

import info.PaymentInfo;
import info.ProductInfo;

import java.util.List;

public class PurchaseDetails {
    private String orderId;
    private String orderDescription;
    private int quantity;
    private List<ProductInfo> productInfo;
    private PaymentInfo paymentInfo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<ProductInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfo> productInfo) {
        this.productInfo = productInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "PurchaseDetails: \n" +
                "orderId: " + orderId + "\n" +
                "orderDescription: " + orderDescription + "\n" +
                "quantity: " + quantity + "\n" +
                "paymentInfo: " + paymentInfo + "\n";
    }
}
