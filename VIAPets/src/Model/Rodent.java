package Model;

public class Rodent extends Pet
{
  private String bitingTendency;  // Represents whether the rodent has a tendency to bite
  private String type;  // The type of pet, which is "Rodent"

  // Constructor with necessary fields
  public Rodent(String name, int age, String gender, String color,
      String comment, boolean isForSale, Price price, String bitingTendency)
  {
    super(name, age, gender, color, comment, isForSale, price);
    this.bitingTendency = bitingTendency;
    this.type = this.getClass().getSimpleName();  // Set the type as "Rodent"
  }

  // Getter for the pet type
  public String getType()
  {
    return type;
  }

  // Getter for biting tendency
  public String getBitingTendency()
  {
    return bitingTendency;
  }

  // Override toString() to return details of the rodent
  @Override public String toString()
  {
    return "Rodent " + super.toString();
  }

  // Override equals() to compare two Rodent objects
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object.getClass())
    {
      return false;
    }
    Rodent rodent = (Rodent) object;
    return super.equals(rodent) && rodent.getBitingTendency()
        .equals(getBitingTendency());
  }

  // Setter for biting tendency
  public void setBitingTendency(String bitingTendency)
  {
    this.bitingTendency = bitingTendency;
  }
}
