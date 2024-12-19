package Model;

public class Bird extends Pet
{
  private String preferredFood;
  private String type;

  // Constructor with price parameter
  public Bird(String name, int age, String gender, String color, String comment,
      boolean isForSale, Price price, String preferredFood)
  {
    super(name, age, gender, color, comment, isForSale, price);
    this.preferredFood = preferredFood;
    this.type = this.getClass().getSimpleName();
  }

  // Constructor without price parameter
  public Bird(String name, int age, String gender, String color, String comment,
      boolean isForSale, String preferredFood)
  {
    super(name, age, gender, color, comment, isForSale);
    this.preferredFood = preferredFood;
  }

  // Returns the bird's type
  public String getType()
  {
    return type;
  }

  // Returns the bird's preferred food
  public String getPreferredFood()
  {
    return preferredFood;
  }

  // Sets the bird's preferred food
  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
  }

  // Converts the bird object to a string
  @Override public String toString()
  {
    return "Bird " + super.toString();
  }

  // Compares this bird object with another for equality
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object.getClass())
      return false;
    Bird bird = (Bird) object;
    return super.equals(bird) && bird.getPreferredFood()
        .equals(getPreferredFood());
  }
}