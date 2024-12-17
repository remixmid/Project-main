package Model;

public class Bird extends Pet {
    private String preferredFood;
    private String type;

    public Bird(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String preferredFood) {
        super(name, age, gender, color, comment, isForSale, price);
        this.preferredFood = preferredFood;
        this.type = this.getClass().getSimpleName();
    }

    public Bird(String name, int age, String gender, String color, String comment, boolean isForSale, String preferredFood) {
        super(name, age, gender, color, comment, isForSale);
        this.preferredFood = preferredFood;
    }

    public String getType() {
        return type;
    }

    public String getPreferredFood() {
        return preferredFood;
    }

    public void setPreferredFood(String preferredFood) {
        this.preferredFood = preferredFood;
    }

    @Override
    public String toString() {
        return "Bird " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Bird bird = (Bird) object;
        if (super.equals(bird) && bird.getPreferredFood().equals(getPreferredFood())) {
            return true;
        }
        return false;
    }

}
