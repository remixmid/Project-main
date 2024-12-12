import Model.Customer;
import Model.PetList;
import Utils.MyFileHandler;

public class CustomerListModelManager {
    private String fileName;

    public CustomerListModelManager() {
        this.fileName = "Customers.bin";
    }

    public PetList.CustomerList getAllCustomers() {
        PetList.CustomerList customerList = new PetList.CustomerList();
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

    public void saveCustomerList(PetList.CustomerList customerList) {
        try {
            MyFileHandler.writeArrayToBinaryFile(fileName, customerList.getAllCustomers().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        try {
            PetList.CustomerList customerList = getAllCustomers();
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
            PetList.CustomerList customerList = getAllCustomers();
            for (Customer customer : customerList.getAllCustomers()) {
                if (customer.equals(customerToEdit)) {
                    customer = editedCustomer;
                    break;
                }
            }
            saveCustomerList(customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
