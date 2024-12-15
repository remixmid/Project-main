package savepackages;

import Model.Pet;
import Model.PetList;
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
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);
            PetList petList = new PetList();
            for (Object obj : objects) {
                Pet pet = (Pet) obj;
                if (pet.equals(petToChange)) {
                    petList.addPet(newPet);
                } else {
                    petList.addPet(pet);
                }
            }
            savePetsForSale(petList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePet(Pet petToDelete) {
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);
            PetList petList = new PetList();
            for (Object obj : objects) {
                Pet pet = (Pet) obj;
                if (!pet.equals(petToDelete)) {
                    petList.addPet(pet);
                }
            }
            savePetsForSale(petList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
