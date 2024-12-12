package Model;

import java.util.Date;

public class KennelPlace {
    private Date dateIn;
    private Date dateOut;
    private boolean isOccupied;
    private int kennelPlaceId;
    private Pet pet;
    private Price price;

    public KennelPlace(Price price) {
        this.price = price;
    }


    public Date getDateOut() {
        return dateOut;
    }

    public int getKennelPlaceId() {
        return kennelPlaceId;
    }

    public Pet getPet() {
        return pet;
    }

    public Price getPrice() {
        return price;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public boolean getIsOccupied(){
        return this.isOccupied;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setKennelPlaceId(int kennelPlaceId) {
        this.kennelPlaceId = kennelPlaceId;
    }

    public void setPet(Pet pet) {
        if (pet.getClass() == Bird.class || pet.getClass() == Dog.class || pet.getClass() == Cat.class)
            this.pet = pet;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if (getIsOccupied() == false)
            return "Model.Kennel place ID: " + getKennelPlaceId() + ", status: is free, price: " + getPrice().toString();
        else
            return "Model.Kennel place ID: " + getKennelPlaceId() + ", status: is occupied from " + dateIn.toString() + " til " + getDateOut().toString() + ", price: " + getPrice().toString();
    }
    public KennelPlace copy(){
        KennelPlace copy =   new KennelPlace(new Price(0));
        copy.setDateIn(this.getDateIn());
        copy.setDateOut(this.getDateOut());
        copy.setPet(this.getPet());
        copy.setKennelPlaceId(this.getKennelPlaceId());
        copy.setOccupied(this.getIsOccupied());
        copy.setPrice(this.getPrice());
        return copy;

    }
}
