package savepackages;

import Model.*;
import Utils.MyFileHandler;

public class CustomerListModelManager {
    private String fileName;

    public CustomerListModelManager() {
        this.fileName = "Customers.bin";
    }

    public CustomerList getAllCustomers() {
        CustomerList customerList = new CustomerList();
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            for (Object object : objects) {
                Customer customer = (Customer) object;
                customerList.addCustomer(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void saveCustomerList(CustomerList customerList) {
        try {
            MyFileHandler.writeArrayToBinaryFile(fileName, customerList.getAllCustomers().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        try {
            CustomerList customerList = getAllCustomers();
            for (Customer c : customerList.getAllCustomers()) {
                if (c.equals(customer)) {
                    return;
                }
            }
            customerList.addCustomer(customer);
            saveCustomerList(customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(Customer customerToEdit, Customer editedCustomer) {
        try {
            // Read all existing pets from the file
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);

            CustomerList customerList = new CustomerList();
            boolean customerEdited = false;

            for (Object obj : objects) {
                Customer customer = (Customer) obj;

                // More lenient comparison to help diagnose matching issues
                if (customer.getName().equals(customerToEdit.getName())) {
                    System.out.println("Found matching pet by name");

                    // Update all basic pet attributes
                    customer.setName(editedCustomer.getName());
                    customer.setEmail(editedCustomer.getEmail());
                    customer.setAddress(editedCustomer.getAddress());
                    customer.setPhoneNumber(editedCustomer.getPhoneNumber());

                    customerList.addCustomer(customer);
                    customerEdited = true;
                } else {
                    customerList.addCustomer(customer);
                }
            }

            if (!customerEdited) {
                customerList.addCustomer(editedCustomer);
            }

            // Save the updated pet list
            saveCustomerList(customerList);

        } catch (Exception e) {
            System.out.println("Error during edit process:");
            e.printStackTrace();
        }
    }
}
