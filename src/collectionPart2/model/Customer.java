package collectionPart2.model;

public class Customer {
    private String customerName;
    private String storeLocation;
    private Integer date;
    private String productName;
    private Integer price;
    private String paymentType;

    public Customer(String customerName, String storeLocation, Integer date, String productName, Integer price, String paymentType) {
        this.customerName = customerName;
        this.storeLocation = storeLocation;
        this.date = date;
        this.productName = productName;
        this.price = price;
        this.paymentType = paymentType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public Integer getDate() {
        return date;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format("Customer:{0},StoreLocation:{1},Date:{2}," +
                "ProductName:{3},Price:{4},paymentType:{5}",
                customerName,storeLocation,date,productName,price,paymentType);
    }
}
