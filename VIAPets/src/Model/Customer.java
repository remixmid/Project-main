package Model;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Name: " + name +
                "Phone number: " + phoneNumber +
                "Email: " + email +
                "Address: " + address;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Customer customer = (Customer) object;
        if (super.equals(customer) && customer.getEmail().equals(getEmail()) && customer.getName().equals(getName()) && customer.getAddress().equals(getAddress()) && customer.getPhoneNumber().equals(getPhoneNumber())) {
            return true;
        }
        return false;
    }
}
