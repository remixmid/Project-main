package Model;

import java.io.Serializable;

public class Purchase implements Serializable {
    private Customer customer;
    private Pet pet;
    private Date dateOfPurchase;
    private Price price;

    public Purchase(Customer customer, Pet pet, Date dateOfPurchase, Price price){
        this.customer = customer;
        this.pet = pet;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String toString(){
        return "Client info: " +  customer.toString() +"Pet info: " +  pet.toString() + "final price: " + price.toString() + "Date of purchase: " + dateOfPurchase;
    }
}
