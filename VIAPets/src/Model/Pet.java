package Model;

import java.io.Serializable;

public abstract class Pet implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String color;
    private String comment;
    private boolean isForSale;
    private Price price;

    public Pet(String name, int age, String gender, String color, String comment, boolean isForSale, Price price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.comment = comment;
        this.isForSale = isForSale;
        this.price = price;
    }

    public Pet(String name, int age, String gender, String color, String comment, boolean isForSale) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.comment = comment;
        this.isForSale = isForSale;
        this.price = new Price(0);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getColor() {
        return color;
    }

    public String getComment() {
        return comment;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public Price getPrice() {
        return price;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String toString() {
        return "name: " + getName() + "price: " + price.toString();
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Pet pet = (Pet) object;
        if (getName().equals(pet.getName()) && getAge() == pet.getAge() &&
        getColor().equals(pet.getColor()) && getGender().equals(pet.getGender()) &&
        getComment().equals(pet.getComment()) && getPrice().equals(pet.getPrice()) && isForSale == pet.isForSale) {
            return true;
        }
        return false;
    }
}
