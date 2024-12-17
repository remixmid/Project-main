package Model;

public class Fish extends Pet {
    private String waterType;
    private String predatorStatus;
    private String type;

    public Fish(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String waterType, String predatorStatus) {
        super(name, age, gender, color, comment, isForSale, price);
        this.waterType = waterType;
        this.predatorStatus = predatorStatus;
        this.type = this.getClass().getSimpleName();
    }

    public String getType() {
        return type;
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

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public void setPredatorStatus(String predatorStatus) {
        this.predatorStatus = predatorStatus;
    }
}
