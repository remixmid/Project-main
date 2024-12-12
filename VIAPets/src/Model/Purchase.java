package Model;

public class Purchase {
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
    public String toString(){
        return "Client info: " +  customer.toString() +"Pet info: " +  pet.toString() + "final price: " + price.toString() + "Date of purchase: " + dateOfPurchase;
    }
}
