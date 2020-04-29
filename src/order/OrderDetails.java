package order;

import info.PaymentInfo;
import info.ProductInfo;

import java.util.List;

public class OrderDetails {
    private String orderId;
    private String orderDate;
    private String orderDescription;
    private int quantity;
    private List<ProductInfo> productInfo;
    private PaymentInfo paymentInfo;

}
