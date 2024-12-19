package Model;

import java.io.Serializable;

public class Customer implements Serializable
{
  private String name;
  private String phoneNumber;
  private String email;
  private String address;

  // Constructor initializing customer details
  public Customer(String name, String phoneNumber, String email, String address)
  {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }

  // Returns the customer's name
  public String getName()
  {
    return this.name;
  }

  // Returns the customer's phone number
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  // Returns the customer's email
  public String getEmail()
  {
    return this.email;
  }

  // Returns the customer's address
  public String getAddress()
  {
    return this.address;
  }

  // Sets a new address for the customer
  public void setAddress(String address)
  {
    this.address = address;
  }

  // Sets a new email for the customer
  public void setEmail(String email)
  {
    this.email = email;
  }

  // Sets a new name for the customer
  public void setName(String name)
  {
    this.name = name;
  }

  // Sets a new phone number for the customer
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  // Returns a string representation of the customer
  public String toString()
  {
    return "Name: " + name + " Phone number: " + phoneNumber + " Email: "
        + email + " Address: " + address;
  }

  // Compares this customer with another customer
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object)
    {
      return false;
    }
    Customer customer = (Customer) object;
    return super.equals(customer) && customer.getEmail().equals(getEmail())
        && customer.getName().equals(getName()) && customer.getAddress()
        .equals(getAddress()) && customer.getPhoneNumber()
        .equals(getPhoneNumber());
  }
}
