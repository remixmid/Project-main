package Model;

public class Cat extends Pet
{
  private String Breed;
  private String Breeder;
  private String type;

  // Constructor initializing the cat's details
  public Cat(String name, int age, String gender, String color, String comment,
      boolean isForSale, Price price, String breed, String breeder)
  {
    super(name, age, gender, color, comment, isForSale, price);
    Breed = breed;
    Breeder = breeder;
    this.type = this.getClass().getSimpleName();
  }

  // Constructor initializing without price
  public Cat(String name, int age, String gender, String color, String comment,
      boolean isForSale, String breed, String breeder)
  {
    super(name, age, gender, color, comment, isForSale);
    Breed = breed;
    Breeder = breeder;
  }

  // Returns the type of the animal
  public String getType()
  {
    return type;
  }

  // Returns the breed of the cat
  public String getBreed()
  {
    return Breed;
  }

  // Returns the breeder of the cat
  public String getBreeder()
  {
    return Breeder;
  }

  // Returns a string representation of the cat
  @Override public String toString()
  {
    return "Cat " + super.toString();
  }

  // Compares this cat with another cat based on breed and breeder
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object)
    {
      return false;
    }
    Cat cat = (Cat) object;
    return super.equals(cat) && cat.getBreed().equals(getBreed())
        && cat.getBreeder().equals(getBreeder());
  }

  // Sets the breed of the cat
  public void setBreed(String breed)
  {
    Breed = breed;
  }

  // Sets the breeder of the cat
  public void setBreeder(String breeder)
  {
    Breeder = breeder;
  }
}
