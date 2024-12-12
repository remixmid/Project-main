package Model;

public class Cat extends Pet {
    private  String Breed;
    private String Breeder;

    public Cat(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale, price);
        Breed = breed;
        Breeder = breeder;
    }

    public Cat(String name, int age, String gender, String color, String comment, boolean isForSale, String breed, String breeder) {
        super(name, age, gender, color, comment, isForSale);
        Breed = breed;
        Breeder = breeder;
    }

    public String getBreed() {
        return Breed;
    }

    public String getBreeder() {
        return Breeder;
    }

    @Override
    public String toString() {
        return "Cat " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Cat cat = (Cat) object;
        if (super.equals(cat) && cat.getBreed().equals(getBreed()) && cat.getBreeder().equals(getBreeder())) {
            return true;
        }
        return false;
    }

}
