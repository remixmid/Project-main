package Model;

public class Dog extends Pet {
    private String breed;
    private String breeder;
    private String type;

    public Dog(String name, int age, String gender, String color, String comment,
               boolean isForSale, Price price, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale, price);
        this.breed = breed;
        this.breeder = breeder;
        this.type = this.getClass().getSimpleName();
    }

    public Dog(String name, int age, String gender, String color, String comment, boolean isForSale, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale);
        this.breed = breed;
        this.breeder = breeder;
    }

    public String getType() {
        return type;
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
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Dog dog = (Dog) object;
        return super.equals(dog) &&
                dog.getBreed().equals(getBreed()) &&
                dog.getBreeder().equals(getBreeder());
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
    }
}
