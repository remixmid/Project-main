package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable {
    private ArrayList<Customer> customerList = new ArrayList<>();

    // Constructor initializing the customer list
    public CustomerList() {
        customerList = new ArrayList<>();
    }

    // Adds a customer to the list
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Returns the list of all customers
    public ArrayList<Customer> getAllCustomers() {
        return customerList;
    }

    // Converts all customer details to a string representation
    public String kennelPetsToString() {
        ArrayList<Customer> customers = getAllCustomers();
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customers) {
            stringBuilder.append(customer.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    // Returns a string representation of the customer list
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerList) {
            stringBuilder.append(customer.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
