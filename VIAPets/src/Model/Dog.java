package Model;

public class Dog extends Pet {
    private String breed;
    private String breeder;

    public Dog(String name, int age, String gender, String color, String comment,
               boolean isForSale, Price price, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale, price);
        this.breed = breed;
        this.breeder = breeder;
    }

    public Dog(String name, int age, String gender, String color, String comment, boolean isForSale, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale);
        this.breed = breed;
        this.breeder = breeder;
    }

    public String getBreed() {
        return breed;
    }

    public String getBreeder() {
        return breeder;
    }

    @Override
    public String toString() {
        return "Dog " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Dog dog = (Dog) object;
        if (super.equals(dog) && dog.getBreed().equals(getBreed()) && dog.getBreeder().equals(getBreeder())) {
            return true;
        }
        return false;
    }

}
