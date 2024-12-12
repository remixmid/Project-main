package Model;

public class Fish extends Pet {
    private String waterType;
    private String predatorStatus;

    public Fish(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String waterType, String predatorStatus) {
        super(name, age, gender, color, comment, isForSale, price);
        this.waterType = waterType;
        this.predatorStatus = predatorStatus;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getPredatorStatus() {
        return predatorStatus;
    }

    @Override
    public String toString() {
        return "Fish " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Fish fish = (Fish) object;
        if (super.equals(fish) && fish.getWaterType().equals(getWaterType()) && fish.getPredatorStatus().equals(getPredatorStatus())) {
            return true;
        }
        return false;
    }

}
