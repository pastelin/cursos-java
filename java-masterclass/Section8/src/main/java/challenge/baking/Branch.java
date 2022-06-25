package challenge.baking;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String name;

    private List<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {

        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingcustomer = findCustomer(customerName);

        if(existingcustomer != null) {
            existingcustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName) {

        for(int i = 0; i < customers.size(); i++) {

            Customer checkedCustomer = this.customers.get(i);

            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

}
