package Session16.MiniProject1.manager;

import Session16.MiniProject1.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetManager extends Manager<Pet> {

    public Pet findById(String id) {
        for (Pet pet : list) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }
        return null;
    }

    public boolean addPet(Pet pet) {
        if (pet.getId() == null || pet.getId().trim().isEmpty()) {
            System.out.println("Loi: ID khong duoc de trong.");
            return false;
        }
        if (findById(pet.getId()) != null) {
            System.out.println("Loi: ID '" + pet.getId() + "' da ton tai.");
            return false;
        }
        list.add(pet);
        return true;
    }

    public boolean removeById(String id) {
        Pet pet = findById(id);
        if (pet != null) {
            list.remove(pet);
            return true;
        }
        return false;
    }

    // Gan thu cung cho khach hang
    public boolean assignOwner(String petId, String customerId) {
        Pet pet = findById(petId);
        if (pet == null) {
            return false;
        }
        pet.setOwnerId(customerId);
        return true;
    }

    // Lay danh sach thu cung cua mot khach hang
    public List<Pet> getPetsByOwner(String customerId) {
        List<Pet> result = new ArrayList<>();
        for (Pet pet : list) {
            if (customerId.equals(pet.getOwnerId())) {
                result.add(pet);
            }
        }
        return result;
    }
}
