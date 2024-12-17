package Model;

import java.util.ArrayList;

public class CustomerList {
    private ArrayList<Customer> customerList = new ArrayList<>();

    public CustomerList() {
        customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return customerList;
    }

    public String kennelPetsToString() {
        ArrayList<Customer> customers = getAllCustomers();
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customers) {
            stringBuilder.append(customer.toString() + "\n");
        }
        return stringBuilder.toString();
    }

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