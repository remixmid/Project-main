package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PurchaseList implements Serializable {
    private ArrayList<Purchase> purchases;

    public PurchaseList() {
        this.purchases = new ArrayList<>();
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }
}
