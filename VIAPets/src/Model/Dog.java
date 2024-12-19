package Model;

public class Dog extends Pet
{
  private String breed;
  private String breeder;
  private String type;

  // Constructor to initialize Dog with breed, breeder, and other details
  public Dog(String name, int age, String gender, String color, String comment,
      boolean isForSale, Price price, String breed, String breeder)
  {
    super(name, age, gender, color, comment, isForSale, price);
    this.breed = breed;
    this.breeder = breeder;
    this.type = this.getClass().getSimpleName();
  }

  // Constructor to initialize Dog without price, and uses defaults
  public Dog(String name, int age, String gender, String color, String comment,
      boolean isForSale, String breed, String breeder)
  {
    super(name, age, gender, color, comment, isForSale);
    this.breed = breed;
    this.breeder = breeder;
  }

  // Returns the type of animal, which is "Dog"
  public String getType()
  {
    return type;
  }

  // Returns the breed of the dog
  public String getBreed()
  {
    return breed;
  }

  // Returns the breeder of the dog
  public String getBreeder()
  {
    return breeder;
  }

  // Converts the Dog object to a string format
  @Override public String toString()
  {
    return "Dog " + super.toString();
  }

  // Checks equality of two Dog objects based on breed, breeder, and superclass
  @Override public boolean equals(Object object)
  {
    if (object == null || this.getClass() != object)
    {
      return false;
    }
    Dog dog = (Dog) object;
    return super.equals(dog) && dog.getBreed().equals(getBreed())
        && dog.getBreeder().equals(getBreeder());
  }

  // Sets the breed of the dog
  public void setBreed(String breed)
  {
    this.breed = breed;
  }

  // Sets the breeder of the dog
  public void setBreeder(String breeder)
  {
    this.breeder = breeder;
  }
}
