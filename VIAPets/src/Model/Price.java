package Model;

import java.io.Serializable;

public class Price implements Serializable {
    private int price;
    private int discount;

    public Price(int price) {
        this.price = price;
        this.discount = 0;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
