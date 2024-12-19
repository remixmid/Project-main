package Model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pet implements Serializable
{
  private String name;
  private int age;
  private String gender;
  private String color;
  private String comment;
  private boolean isForSale;
  private Price price;

  // Constructor to initialize Pet with all attributes
  public Pet(String name, int age, String gender, String color, String comment,
      boolean isForSale, Price price)
  {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.comment = comment;
    this.isForSale = isForSale;
    this.price = price;
  }

  // Constructor to initialize Pet without price (sets default price to 0)
  public Pet(String name, int age, String gender, String color, String comment,
      boolean isForSale)
  {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.comment = comment;
    this.isForSale = isForSale;
    this.price = new Price(0);
  }

  // Getter for name
  public String getName()
  {
    return name;
  }

  // Getter for age
  public int getAge()
  {
    return age;
  }

  // Getter for gender
  public String getGender()
  {
    return gender;
  }

  // Getter for color
  public String getColor()
  {
    return color;
  }

  // Getter for comment
  public String getComment()
  {
    return comment;
  }

  // Getter for sale status
  public boolean isForSale()
  {
    return isForSale;
  }

  // Getter for price
  public Price getPrice()
  {
    return price;
  }

  // Setter for age
  public void setAge(int age)
  {
    this.age = age;
  }

  // Setter for gender
  public void setGender(String gender)
  {
    this.gender = gender;
  }

  // Setter for comment
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  // Setter for sale status
  public void setForSale(boolean forSale)
  {
    isForSale = forSale;
  }

  // Setter for price
  public void setPrice(Price price)
  {
    this.price = price;
  }

  // Converts pet attributes to a string representation
  @Override public String toString()
  {
    return "Dog name: " + getName() + ", age: " + getAge() + ", price: "
        + price.getPrice() + ", color: " + getColor() + ", gender: "
        + getGender();
  }

  // Checks if two Pet objects are equal based on attributes
  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;

    Pet pet = (Pet) object;

    return Objects.equals(name, pet.name) && age == pet.age && Objects.equals(
        color, pet.color) && Objects.equals(gender, pet.gender)
        && Objects.equals(comment, pet.comment)
        && price.getPrice() == pet.price.getPrice();
  }

  // Generates a hash code based on pet attributes
  @Override public int hashCode()
  {
    return Objects.hash(name, age, color, gender, comment, price.getPrice());
  }

  // Setter for color
  public void setColor(String color)
  {
    this.color = color;
  }

  // Setter for name
  public void setName(String name)
  {
    this.name = name;
  }
}
