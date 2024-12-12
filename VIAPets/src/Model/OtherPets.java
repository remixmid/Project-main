package Model;

public class OtherPets extends Pet{
    private String type;
    private String breed;

    public OtherPets(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String type, String breed) {
        super(name, age, gender, color, comment, isForSale, price);
        this.type = type;
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return getType() + " " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        OtherPets otherPets = (OtherPets) object;
        if (super.equals(otherPets) && otherPets.getBreed().equals(getBreed()) && otherPets.getType().equals(getType())) {
            return true;
        }
        return false;
    }

}
