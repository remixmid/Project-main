package Model;

import java.util.ArrayList;

public class PurchaseList {
    private ArrayList<Purchase> purchases;  // List to hold all purchases

    // Constructor initializes the list
    public PurchaseList() {
        this.purchases = new ArrayList<>();
    }

    // Getter for all purchases
    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    // Method to add a purchase to the list
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    // Setter to update the list of purchases
    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }
}
