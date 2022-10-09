package collectionPart2.services;
import collectionPart2.model.Customer;
import java.util.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


/*
finds out which items have sold for a discount
 (i.e. there was at least one sale of the item at a price lower than the highest price of the item), and then lists

the names of customers who have bought at least one item at the most discounted price.
 */
public class CustomerService {
    List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }


    public List<String> getCustomersWithMaxDis(){
        List<String> customersWhoBroughtItemWithMaxDis = new ArrayList<>();
        Map<String,Customer> maxMap = customers.stream()
                .collect(groupingBy(Customer::getProductName,
                        collectingAndThen(
                                maxBy(comparingInt(Customer::getPrice)),
                                Optional::get
                        )));
        Map<String,Customer> minMap = customers.stream()
                .collect(groupingBy(Customer::getProductName,
                        collectingAndThen(
                                minBy(comparingInt(Customer::getPrice)),
                                Optional::get
                        )));


        //if values are different put the value of minMap in res
        // i.e. this is customer who have maximum discount on the purchase

        //if only one item bought then that will not in put in result map

        //if value of min and max price is different, it will be added in list<Customers>
        maxMap.keySet().stream()
                .filter(minMap::containsKey)
                .filter(key -> maxMap.get(key) != minMap.get(key))
                .forEach(key->customersWhoBroughtItemWithMaxDis.add(minMap.get(key).getCustomerName()));


        return customersWhoBroughtItemWithMaxDis;
    }
}
