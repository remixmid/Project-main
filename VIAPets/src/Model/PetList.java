package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class PetList {
    private ArrayList<Pet> pets;

    public PetList() {
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet petToRemove) {
        pets.removeIf(pet ->
                pet.getName().equals(petToRemove.getName()) &&
                        pet.getAge() == petToRemove.getAge() &&
                        pet.getColor().equals(petToRemove.getColor()) &&
                        pet.getGender().equals(petToRemove.getGender()) &&
                        pet.getPrice().getPrice() == petToRemove.getPrice().getPrice()
        );
    }

    public void editPet(Pet petToEdit, int age, String comment, String gender, Price price) {
        pets.removeIf(pet ->
                pet.getName().equals(petToEdit.getName()) &&
                        pet.getAge() == petToEdit.getAge() &&
                        pet.getColor().equals(petToEdit.getColor()) &&
                        pet.getGender().equals(petToEdit.getGender()) &&
                        pet.getPrice().getPrice() == petToEdit.getPrice().getPrice()
        );
        Pet pet = petToEdit;
        pet.setAge(age);
        pet.setGender(gender);
        pet.setPrice(price);
        pet.setComment(comment);
        pets.add(pet);
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public ArrayList<Pet> getAllKennelPets() {
        ArrayList<Pet> allKennelPets = new ArrayList<>();
        for (Pet pet: pets) {
            if (!pet.isForSale()) {
                allKennelPets.add(pet);
            }
        }
        return allKennelPets;
    }

    public ArrayList<Pet> getAllPetsForSale() {
        ArrayList<Pet> allPetsForSale = new ArrayList<>();
        for (Pet pet: pets) {
            if (pet.isForSale()){
                allPetsForSale.add(pet);
            }
        }
        return allPetsForSale;
    }

    public String kennelPetsToString() {
        ArrayList<Pet> kennelPets = getAllKennelPets();
        StringBuilder stringBuilder = new StringBuilder();
        for (Pet pet: kennelPets){
            stringBuilder.append(pet.toString() + "\n");
        }
        return stringBuilder.toString();
    }
    public String petsForSaleToString() {
        ArrayList<Pet> petsForSale = getAllPetsForSale();
        StringBuilder stringBuilder = new StringBuilder();
        for (Pet pet: petsForSale){
            stringBuilder.append(pet.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
