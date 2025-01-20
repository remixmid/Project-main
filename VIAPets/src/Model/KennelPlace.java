package Model;

import java.io.Serializable;
import java.util.Date;

public class KennelPlace implements Serializable {
    private Date dateIn;
    private Date dateOut;
    private boolean isOccupied;
    private int kennelPlaceId;
    private String pet;
    private Price price;
    private String customerName; // Added customer name field

    public KennelPlace(Price price) {
        this.price = price;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        if (!getIsOccupied())
            return "Model.Kennel place ID: " + getKennelPlaceId() + ", status: is free, price: " + getPrice().toString();
        else
            return "Model.Kennel place ID: " + getKennelPlaceId() + ", status: is occupied from " + dateIn.toString() +
                    " til " + getDateOut().toString() + ", customer: " + customerName + ", price: " + getPrice().toString();
    }

    public Date getDateOut() {
        return dateOut;
    }

    public int getKennelPlaceId() {
        return kennelPlaceId;
    }

    public String getPet() {
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

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setPrice(Price price) {
        this.price = price;
    }


    public KennelPlace copy() {
        KennelPlace copy = new KennelPlace(new Price(0));
        copy.setDateIn(this.getDateIn());
        copy.setDateOut(this.getDateOut());
        copy.setPet(this.getPet());
        copy.setKennelPlaceId(this.getKennelPlaceId());
        copy.setOccupied(this.getIsOccupied());
        copy.setPrice(this.getPrice());
        copy.setCustomerName(this.getCustomerName()); // Copy customer name
        return copy;
    }
}
