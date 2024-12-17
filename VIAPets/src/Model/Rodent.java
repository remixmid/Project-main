package Model;

public class Rodent extends Pet {
    private String bitingTendency;
    private String type;

    public Rodent(String name, int age, String gender, String color, String comment, boolean isForSale, Price price, String bitingTendency) {
        super(name, age, gender, color, comment, isForSale, price);
        this.bitingTendency = bitingTendency;
        this.type = this.getClass().getSimpleName();
    }

    public String getType() {
        return type;
    }

    public String getBitingTendency() {
        return bitingTendency;
    }

    @Override
    public String toString() {
        return "Rodent " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object) {
            return false;
        }
        Rodent rodent = (Rodent) object;
        if (super.equals(rodent) && rodent.getBitingTendency().equals(getBitingTendency())) {
            return true;
        }
        return false;
    }

    public void setBitingTendency(String bitingTendency) {
        this.bitingTendency = bitingTendency;
    }
}
