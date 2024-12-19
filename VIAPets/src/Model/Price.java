package Model;

import java.io.Serializable;
import java.util.Objects;

public class Price implements Serializable
{
  private int price;  // The price of the item (pet)
  private int discount;  // Discount applied to the price

  // Constructor to initialize price with no discount
  public Price(int price)
  {
    this.price = price;
    this.discount = 0;  // Default discount is 0
  }

  // Getter for price
  public int getPrice()
  {
    return price;
  }

  // Setter for price
  public void setPrice(int price)
  {
    this.price = price;
  }

  // Setter for discount
  public void setDiscount(int discount)
  {
    this.discount = discount;
  }

  // Returns the price as a String for easier display
  @Override public String toString()
  {
    return String.valueOf(price);
  }

  // Checks equality between two Price objects based on price and discount
  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    Price price1 = (Price) o;
    return price == price1.price && discount == price1.discount;
  }
}
