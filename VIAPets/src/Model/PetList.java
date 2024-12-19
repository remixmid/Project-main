package Model;

import java.util.ArrayList;

public class PetList
{
  private ArrayList<Pet> pets;

  // Constructor to initialize the pet list
  public PetList()
  {
    this.pets = new ArrayList<>();
  }

  // Adds a new pet to the list
  public void addPet(Pet pet)
  {
    pets.add(pet);
  }

  // Removes a pet from the list by matching its attributes
  public void removePet(Pet petToRemove)
  {
    pets.removeIf(pet -> pet.getName().equals(petToRemove.getName())
        && pet.getAge() == petToRemove.getAge() && pet.getColor()
        .equals(petToRemove.getColor()) && pet.getGender()
        .equals(petToRemove.getGender())
        && pet.getPrice().getPrice() == petToRemove.getPrice().getPrice());
  }

  // Edits an existing pet's details (age, comment, gender, price)
  public void editPet(Pet petToEdit, int age, String comment, String gender,
      Price price)
  {
    pets.removeIf(pet -> pet.getName().equals(petToEdit.getName())
        && pet.getAge() == petToEdit.getAge() && pet.getColor()
        .equals(petToEdit.getColor()) && pet.getGender()
        .equals(petToEdit.getGender())
        && pet.getPrice().getPrice() == petToEdit.getPrice().getPrice());
    Pet pet = petToEdit;
    pet.setAge(age);
    pet.setGender(gender);
    pet.setPrice(price);
    pet.setComment(comment);
    pets.add(pet);
  }

  // Sets the pet list to a new list of pets
  public void setPets(ArrayList<Pet> pets)
  {
    this.pets = pets;
  }

  // Returns a list of pets that are not for sale
  public ArrayList<Pet> getAllKennelPets()
  {
    ArrayList<Pet> allKennelPets = new ArrayList<>();
    for (Pet pet : pets)
    {
      if (!pet.isForSale())
      {
        allKennelPets.add(pet);
      }
    }
    return allKennelPets;
  }

  // Returns a list of pets that are for sale
  public ArrayList<Pet> getAllPetsForSale()
  {
    ArrayList<Pet> allPetsForSale = new ArrayList<>();
    for (Pet pet : pets)
    {
      if (pet.isForSale())
      {
        allPetsForSale.add(pet);
      }
    }
    return allPetsForSale;
  }

  // Converts the list of kennel pets into a string representation
  public String kennelPetsToString()
  {
    ArrayList<Pet> kennelPets = getAllKennelPets();
    StringBuilder stringBuilder = new StringBuilder();
    for (Pet pet : kennelPets)
    {
      stringBuilder.append(pet.toString() + "\n");
    }
    return stringBuilder.toString();
  }

  // Converts the list of pets for sale into a string representation
  public String petsForSaleToString()
  {
    ArrayList<Pet> petsForSale = getAllPetsForSale();
    StringBuilder stringBuilder = new StringBuilder();
    for (Pet pet : petsForSale)
    {
      stringBuilder.append(pet.toString() + "\n");
    }
    return stringBuilder.toString();
  }
}
