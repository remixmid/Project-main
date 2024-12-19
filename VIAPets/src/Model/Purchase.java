package Model;

public class Purchase
{
  private Customer customer;  // The customer making the purchase
  private Pet pet;            // The pet being purchased
  private Date dateOfPurchase;  // The date of the purchase
  private Price price;        // The price of the pet

  // Constructor to initialize all fields
  public Purchase(Customer customer, Pet pet, Date dateOfPurchase, Price price)
  {
    this.customer = customer;
    this.pet = pet;
    this.price = price;
    this.dateOfPurchase = dateOfPurchase;
  }

  // Getter and Setter for customer
  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  // Getter and Setter for pet
  public Pet getPet()
  {
    return pet;
  }

  public void setPet(Pet pet)
  {
    this.pet = pet;
  }

  // Getter and Setter for date of purchase
  public Date getDateOfPurchase()
  {
    return dateOfPurchase;
  }

  public void setDateOfPurchase(Date dateOfPurchase)
  {
    this.dateOfPurchase = dateOfPurchase;
  }

  // Getter and Setter for price
  public Price getPrice()
  {
    return price;
  }

  public void setPrice(Price price)
  {
    this.price = price;
  }

  // toString method to return purchase details as a string
  public String toString()
  {
    return "Client info: " + customer.toString() + " Pet info: "
        + pet.toString() + " Final price: " + price.toString()
        + " Date of purchase: " + dateOfPurchase;
  }
}
