package Session16.MiniProject;

import java.util.*;

public class Main {
    // Hàm thêm pet (tránh trùng ID)
    public static void addPet(Pet pet,
            ArrayList<Pet> list,
            HashMap<String, Pet> map,
            Set<String> ids) {

        if (ids.contains(pet.getId())) {
            System.out.println("ID đã tồn tại!");
            return;
        }

        list.add(pet); // thêm vào ArrayList
        map.put(pet.getId(), pet); // thêm vào HashMap
        ids.add(pet.getId()); // thêm vào Set
    }

    public static void main(String[] args) {

        // 1️⃣ Tạo Collection
        ArrayList<Pet> petList = new ArrayList<>();
        HashMap<String, Pet> petMap = new HashMap<>();
        Set<String> petIds = new HashSet<>();

        // =============================
        // 1. Thêm thú cưng vào ArrayList
        // 2. Thêm vào HashMap
        // =============================

        addPet(new Dog("P01", "Buddy", 5, 300.0, "Husky"),
                petList, petMap, petIds);

        addPet(new Cat("P02", "Milo", 2, 180.0, "White"),
                petList, petMap, petIds);

        addPet(new Dog("P03", "Rocky", 7, 250.0, "Alaska"),
                petList, petMap, petIds);

        // Anonymous Class – Parrot
        Pet parrot = new Pet("P04", "Rio", 1, 150.0) {
            @Override
            public void makeSound() {
                System.out.println("Parrot nói: Xin chào!");
            }
        };
        addPet(parrot, petList, petMap, petIds);

        // =============================
        // 3. In danh sách
        // =============================
        System.out.println("=== DANH SÁCH PET ===");
        for (Pet p : petList) {
            p.displayInfo();
            p.makeSound();
            System.out.println("------------------");
        }

        // =============================
        // 4. Sắp xếp theo giá tăng dần
        // =============================
        Collections.sort(petList, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("=== SAU KHI SẮP XẾP THEO GIÁ ===");
        petList.forEach(Pet::displayInfo);

        // =============================
        // 5. Tìm kiếm theo ID
        // =============================
        System.out.println("=== TÌM PET P02 ===");
        Pet foundPet = petMap.get("P02");
        if (foundPet != null) {
            foundPet.displayInfo();
        } else {
            System.out.println("Không tìm thấy!");
        }

        // =============================
        // 6. Xóa pet lớn tuổi (age > 6)
        // =============================
        Iterator<Pet> iterator = petList.iterator();
        while (iterator.hasNext()) {
            Pet p = iterator.next();
            if (p.getAge() > 6) {
                iterator.remove(); // xóa khỏi list
                petMap.remove(p.getId()); // xóa khỏi map
                petIds.remove(p.getId()); // xóa khỏi set
            }
        }

        System.out.println("=== SAU KHI XÓA PET LỚN TUỔI (>6) ===");
        petList.forEach(Pet::displayInfo);

        // =============================
        // 7. In tổng số pet đã tạo
        // =============================
        System.out.println("Tổng số pet đã tạo: " + Pet.totalPets);

        // =============================
        // 8. Gọi performTrick()
        // =============================
        System.out.println("=== BIỂU DIỄN KỸ NĂNG ===");
        for (Pet p : petList) {
            if (p instanceof ITrainable) {
                ((ITrainable) p).performTrick();
            }
        }
    }

}