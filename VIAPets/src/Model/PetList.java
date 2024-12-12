package Model;

import java.util.ArrayList;

public class PetList {
    private ArrayList<Pet> pets;

    public PetList() {
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
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

    public static class CustomerList {
        private ArrayList<Customer> customerList = new ArrayList<>();

        public CustomerList() {
            customerList = new ArrayList<>();
        }

        public void addCustomer(Customer customer) {
            customerList.add(customer);
        }

        public ArrayList<Customer> getAllCustomers() {
            return customerList;
        }

        public String kennelPetsToString() {
            ArrayList<Customer> customers = getAllCustomers();
            StringBuilder stringBuilder = new StringBuilder();
            for (Customer customer : customers) {
                stringBuilder.append(customer.toString() + "\n");
            }
            return stringBuilder.toString();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Customer customer : customerList) {
                stringBuilder.append(customer.toString());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }
}
