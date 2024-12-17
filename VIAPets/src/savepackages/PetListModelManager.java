package savepackages;

import Model.*;
import Utils.MyFileHandler;

import java.io.File;

public class PetListModelManager {
    private String fileName;

    public PetListModelManager() {
        this.fileName = "Pets.bin";
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PetList getAllPets() {
        PetList petList = new PetList();

        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);

            for (Object obj : objects) {
                petList.addPet((Pet) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petList;
    }

    public void addPetForSale(Pet pet) {
        try {
            PetList petList = getAllPets();
            petList.addPet(pet);
            savePetsForSale(petList);
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    public void savePetsForSale(PetList petList) {
        try {
            MyFileHandler.writeArrayToBinaryFile(this.fileName, petList.getAllPetsForSale().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editPet(Pet petToChange, Pet newPet) {
        try {
            System.out.println("Starting edit process");
            System.out.println("Pet to change: " + petToChange);
            System.out.println("New pet details: " + newPet);

            // Read all existing pets from the file
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);
            System.out.println("Total pets read from file: " + objects.length);

            PetList petList = new PetList();
            boolean petEdited = false;

            for (Object obj : objects) {
                Pet pet = (Pet) obj;

                System.out.println("Comparing pet: " + pet);
                System.out.println("Current pet name: " + pet.getName());
                System.out.println("Current pet age: " + pet.getAge());
                System.out.println("Pet to change name: " + petToChange.getName());
                System.out.println("Pet to change age: " + petToChange.getAge());

                // More lenient comparison to help diagnose matching issues
                if (pet.getName().equals(petToChange.getName())) {
                    System.out.println("Found matching pet by name");

                    // Update all basic pet attributes
                    pet.setName(newPet.getName());
                    pet.setAge(newPet.getAge());
                    pet.setGender(newPet.getGender());
                    pet.setColor(newPet.getColor());
                    pet.setComment(newPet.getComment());
                    pet.setPrice(newPet.getPrice());
                    pet.setForSale(true);

                    // Specific pet type updates with additional logging
                    if (pet.getClass() == newPet.getClass()) {
                        System.out.println("Updating specific pet type: " + pet.getClass().getSimpleName());

                        if (pet instanceof Dog) {
                            Dog existingDog = (Dog) pet;
                            Dog newDog = (Dog) newPet;
                            existingDog.setBreed(newDog.getBreed());
                            existingDog.setBreeder(newDog.getBreeder());
                        } else if (pet instanceof Cat) {
                            Cat existingCat = (Cat) pet;
                            Cat newCat = (Cat) newPet;
                            existingCat.setBreed(newCat.getBreed());
                            existingCat.setBreeder(newCat.getBreeder());
                        } else if (pet instanceof Bird) {
                            Bird existingBird = (Bird) pet;
                            Bird newBird = (Bird) newPet;
                            existingBird.setPreferredFood(newBird.getPreferredFood());
                        } else if (pet instanceof Fish) {
                            Fish existingFish = (Fish) pet;
                            Fish newFish = (Fish) newPet;
                            existingFish.setWaterType(newFish.getWaterType());
                            existingFish.setPredatorStatus(newFish.getPredatorStatus());
                        } else if (pet instanceof Rodent) {
                            Rodent existingRodent = (Rodent) pet;
                            Rodent newRodent = (Rodent) newPet;
                            existingRodent.setBitingTendency(newRodent.getBitingTendency());
                        } else if (pet instanceof OtherPets) {
                            OtherPets existingOtherPet = (OtherPets) pet;
                            OtherPets newOtherPet = (OtherPets) newPet;
                            existingOtherPet.setType(newOtherPet.getType());
                            existingOtherPet.setBreed(newOtherPet.getBreed());
                        }
                    }

                    petList.addPet(pet);
                    petEdited = true;
                    System.out.println("Pet edited successfully");
                } else {
                    petList.addPet(pet);
                }
            }

            if (!petEdited) {
                System.out.println("No matching pet found. Adding new pet.");
                petList.addPet(newPet);
            }

            // Save the updated pet list
            savePetsForSale(petList);
            System.out.println("Edit process completed");

        } catch (Exception e) {
            System.out.println("Error during edit process:");
            e.printStackTrace();
        }
    }

    public void deletePet(Pet petToDelete) {
        try {
            PetList petList = getAllPets();
            petList.removePet(petToDelete);
            savePetsForSale(petList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
