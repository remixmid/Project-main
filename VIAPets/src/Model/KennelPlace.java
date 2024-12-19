package Model;

import java.io.Serializable;
import java.util.Date;

public class KennelPlace implements Serializable
{
  private Date dateIn;
  private Date dateOut;
  private boolean isOccupied;
  private int kennelPlaceId;
  private String pet;
  private Price price;

  // Constructor to initialize the kennel place with a price
  public KennelPlace(Price price)
  {
    this.price = price;
  }

  // Returns the date the pet checks out
  public Date getDateOut()
  {
    return dateOut;
  }

  // Returns the unique kennel place ID
  public int getKennelPlaceId()
  {
    return kennelPlaceId;
  }

  // Returns the name of the pet in the kennel place
  public String getPet()
  {
    return pet;
  }

  // Returns the price for the kennel place
  public Price getPrice()
  {
    return price;
  }

  // Returns the date the pet checks in
  public Date getDateIn()
  {
    return dateIn;
  }

  // Returns whether the kennel place is occupied
  public boolean getIsOccupied()
  {
    return this.isOccupied;
  }

  // Sets the check-in date for the pet
  public void setDateIn(Date dateIn)
  {
    this.dateIn = dateIn;
  }

  // Sets the check-out date for the pet
  public void setDateOut(Date dateOut)
  {
    this.dateOut = dateOut;
  }

  // Sets the occupancy status of the kennel place
  public void setOccupied(boolean occupied)
  {
    isOccupied = occupied;
  }

  // Sets the unique ID for the kennel place
  public void setKennelPlaceId(int kennelPlaceId)
  {
    this.kennelPlaceId = kennelPlaceId;
  }

  // Sets the pet name for the kennel place
  public void setPet(String pet)
  {
    this.pet = pet;
  }

  // Sets the price for the kennel place
  public void setPrice(Price price)
  {
    this.price = price;
  }

  // Converts the kennel place details to a string representation
  @Override public String toString()
  {
    if (getIsOccupied() == false)
      return "Model.Kennel place ID: " + getKennelPlaceId()
          + ", status: is free, price: " + getPrice().toString();
    else
      return "Model.Kennel place ID: " + getKennelPlaceId()
          + ", status: is occupied from " + dateIn.toString() + " til "
          + getDateOut().toString() + ", price: " + getPrice().toString();
  }

  // Creates a copy of the current kennel place
  public KennelPlace copy()
  {
    KennelPlace copy = new KennelPlace(new Price(0));
    copy.setDateIn(this.getDateIn());
    copy.setDateOut(this.getDateOut());
    copy.setPet(this.getPet());
    copy.setKennelPlaceId(this.getKennelPlaceId());
    copy.setOccupied(this.getIsOccupied());
    copy.setPrice(this.getPrice());
    return copy;
  }
}
