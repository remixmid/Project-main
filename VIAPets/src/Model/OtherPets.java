package Model;

public class OtherPets extends Pet
{
  private String type;
  private String breed;

  // Constructor to initialize OtherPets with necessary attributes
  public OtherPets(String name, int age, String gender, String color,
      String comment, boolean isForSale, Price price, String type, String breed)
  {
    super(name, age, gender, color, comment, isForSale, price);
    this.type = type;
    this.breed = breed;
  }

  // Returns the type of the other pet
  public String getType()
  {
    return type;
  }

  // Returns the breed of the other pet
  public String getBreed()
  {
    return breed;
  }

  // Converts the other pet's details into a string representation
  @Override public String toString()
  {
    return getType() + " " + super.toString();
  }

  // Checks if two other pets are equal by comparing their attributes
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object)
    {
      return false;
    }
    OtherPets otherPets = (OtherPets) object;
    if (super.equals(otherPets) && otherPets.getBreed().equals(getBreed())
        && otherPets.getType().equals(getType()))
    {
      return true;
    }
    return false;
  }

  // Sets the type of the other pet
  public void setType(String type)
  {
    this.type = type;
  }

  // Sets the breed of the other pet
  public void setBreed(String breed)
  {
    this.breed = breed;
  }
}
