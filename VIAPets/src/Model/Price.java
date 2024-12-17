package Model;

import java.io.Serializable;
import java.util.Objects;

public class Price implements Serializable {
    private int price;
    private int discount;

    public Price(int price) {
        this.price = price;
        this.discount = 0;
    }

    public int getPrice() {
        return price;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price && discount == price1.discount;
    }
}
