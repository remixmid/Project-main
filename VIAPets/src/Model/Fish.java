package Model;

public class Fish extends Pet
{
  private String waterType;
  private String predatorStatus;
  private String type;

  // Constructor to initialize Fish with details
  public Fish(String name, int age, String gender, String color, String comment,
      boolean isForSale, Price price, String waterType, String predatorStatus)
  {
    super(name, age, gender, color, comment, isForSale, price);
    this.waterType = waterType;
    this.predatorStatus = predatorStatus;
    this.type = this.getClass().getSimpleName();
  }

  // Returns the type of animal, which is "Fish"
  public String getType()
  {
    return type;
  }

  // Returns the type of water the fish lives in
  public String getWaterType()
  {
    return waterType;
  }

  // Returns the predator status of the fish
  public String getPredatorStatus()
  {
    return predatorStatus;
  }

  // Converts the Fish object to a string format
  @Override public String toString()
  {
    return "Fish " + super.toString();
  }

  // Checks equality of two Fish objects based on water type, predator status, and superclass
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object)
    {
      return false;
    }
    Fish fish = (Fish) object;
    return super.equals(fish) && fish.getWaterType().equals(getWaterType())
        && fish.getPredatorStatus().equals(getPredatorStatus());
  }

  // Sets the water type of the fish
  public void setWaterType(String waterType)
  {
    this.waterType = waterType;
  }

  // Sets the predator status of the fish
  public void setPredatorStatus(String predatorStatus)
  {
    this.predatorStatus = predatorStatus;
  }
}
