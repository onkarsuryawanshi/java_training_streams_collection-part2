package collectionPart2.mapper;

import collectionPart2.model.Customer;


public class CustomerMapper implements CSVToPojoMapper{
    @Override
    public Object map(String[] values) {

        if (values == null || values.length!=6) {
            throw new RuntimeException("Invalid input values");
        }
        String customerName;
        String storeLocation;
        Integer date;
        String productName;
        Integer price;
        String paymentType;
        customerName = values[0].trim();
        storeLocation = values[1].trim();
        try {
            date = Integer.parseInt(values[2].trim());
        }
        catch (NumberFormatException e){
            throw new RuntimeException("Invalid date  ", e);
        }
        productName = values[3].trim();
        try {
            price = Integer.parseInt(values[4].trim());
        }
        catch (NumberFormatException e){
            throw new RuntimeException("Invalid Price Entered ", e);
        }
        paymentType = values[5].trim();
        Customer customer = new Customer(customerName,storeLocation,date,productName,price,paymentType);
        return customer;
    }
}
