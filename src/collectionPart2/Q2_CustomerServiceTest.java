package collectionPart2;


import collectionPart2.mapper.CustomerMapper;
import collectionPart2.model.Customer;
import collectionPart2.parser.InputParser;
import collectionPart2.services.CustomerService;

import java.util.List;

public class Q2_CustomerServiceTest {
    public static void main(String[] args) {
        String[] customerInfo = {
                "Rajan Patil, Aundh, 1, Phone Cover, 170, Cash",
                "Mohit Gupta, Baner, 1, Samsung Battery, 900, Credit Card",
                "Rajan Patil, Aundh, 3, Samsung Battery, 1000, Cash",
                "Nina Kothari, Baner, 4, Earphones, 500, Credit Card",
                "T Sunitha, Shivajinagar, 5, Earphones, 550, Credit Card",
                "Rohan Gade, Aundh, 10, Motorola Battery, 1000, Credit Card",
                "Rajan Patil, Shivajinagar, 21, Earphones, 550, Credit Card",
                "Rajan Patil, Aundh, 22, USB Cable, 150, UPI",
                "Meena Kothari, Baner, 23, USB Cable,  100, Cash",
                "Nina Kothari, Baner, 24, USB Cable,  200, UPI",
                "Mohit Gupta, Baner, 25, USB Cable,  150, UPI"
        };

        CustomerMapper mapper = new CustomerMapper();
        List<Customer> customers;
        InputParser parser = new InputParser<>(mapper);
        customers = parser.parseArray(customerInfo);

        CustomerService customerService = new CustomerService(customers);
        List<String> customersWhoBroughtItemWithMaxDis = customerService.getCustomersWithMaxDis();

        System.out.println(" --- lists the names of customers who have bought  \n" +
                            " at least one item at the most discounted price. ----");
        customersWhoBroughtItemWithMaxDis.stream()
                .forEach(System.out::println);
    }
}
