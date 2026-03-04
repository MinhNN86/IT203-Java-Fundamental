package Session16.MiniProject1;

import Session16.MiniProject1.manager.CustomerManager;
import Session16.MiniProject1.manager.PetManager;
import Session16.MiniProject1.model.Customer;
import Session16.MiniProject1.model.Pet;
import Session16.MiniProject1.service.ActivityLog;
import Session16.MiniProject1.service.SpaService;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static PetManager petManager = new PetManager();
    static CustomerManager customerManager = new CustomerManager();
    static SpaService spaService = new SpaService();
    static ActivityLog log = new ActivityLog();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // --- 3.1 Quan ly kho thu cung ---
                case 1:
                    addPet();
                    break;
                case 2:
                    showPets();
                    break;
                case 3:
                    findPet();
                    break;
                case 4:
                    sellPet();
                    break;
                case 5:
                    assignPetToCustomer();
                    break;
                case 6:
                    showPetsByCustomer();
                    break;
                // --- 3.2 Quan ly khach hang ---
                case 7:
                    registerCustomer();
                    break;
                case 8:
                    findCustomer();
                    break;
                case 9:
                    showCustomers();
                    break;
                // --- 3.3 Dich vu Spa ---
                case 10:
                    addToSpa();
                    break;
                case 11:
                    serveNextSpa();
                    break;
                case 12:
                    showSpaQueue();
                    break;
                // --- 3.4 Nhat ky hoat dong ---
                case 13:
                    showLogs();
                    break;
                case 14:
                    undo();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    static void printMenu() {
        System.out.println("\n===== PET KINGDOM =====");
        System.out.println("-- Thu Cung --");
        System.out.println(" 1. Them thu cung");
        System.out.println(" 2. Hien thi danh sach thu cung");
        System.out.println(" 3. Tim thu cung theo ID");
        System.out.println(" 4. Ban thu cung (xoa khoi kho)");
        System.out.println(" 5. Gan thu cung cho khach hang");
        System.out.println(" 6. Xem thu cung cua khach hang");
        System.out.println("-- Khach Hang --");
        System.out.println(" 7. Dang ky khach hang");
        System.out.println(" 8. Tra cuu khach hang theo ID");
        System.out.println(" 9. Hien thi danh sach khach hang");
        System.out.println("-- Dich Vu Spa --");
        System.out.println("10. Them thu cung vao hang cho spa");
        System.out.println("11. Phuc vu thu cung tiep theo");
        System.out.println("12. Xem hang cho spa");
        System.out.println("-- He Thong --");
        System.out.println("13. Xem nhat ky hoat dong");
        System.out.println("14. Hoan tac (Undo)");
        System.out.println(" 0. Thoat");
        System.out.print("Lua chon: ");
    }

    // ===== 3.1 THU CUNG =====

    static void addPet() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Ten: ");
        String name = sc.nextLine();

        System.out.print("Loai: ");
        String species = sc.nextLine();

        System.out.print("Gia: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Pet pet = new Pet(id, name, species, price);
        if (!petManager.addPet(pet))
            return;
        log.addLog("Them thu cung: " + id + " - " + name);
        System.out.println("Da them thu cung thanh cong!");
    }

    static void showPets() {
        System.out.println("--- Danh sach thu cung ---");
        if (petManager.getAll().isEmpty()) {
            System.out.println("Chua co thu cung nao.");
            return;
        }
        for (Pet pet : petManager.getAll()) {
            System.out.println(pet);
        }
    }

    static void findPet() {
        System.out.print("Nhap ID thu cung: ");
        String id = sc.nextLine();
        Pet pet = petManager.findById(id);
        if (pet != null) {
            System.out.println("Tim thay: " + pet);
        } else {
            System.out.println("Khong tim thay thu cung voi ID: " + id);
        }
    }

    static void sellPet() {
        System.out.print("Nhap ID thu cung can ban: ");
        String id = sc.nextLine();
        Pet pet = petManager.findById(id);
        if (pet == null) {
            System.out.println("Khong tim thay thu cung voi ID: " + id);
            return;
        }

        System.out.println("Thong tin thu cung: " + pet);
        System.out.print("Ban cho khach hang da dang ky? (y/n): ");
        String hasCustomer = sc.nextLine();

        if (hasCustomer.equalsIgnoreCase("y")) {
            System.out.print("Nhap ID khach hang: ");
            String customerId = sc.nextLine();
            Customer buyer = customerManager.findById(customerId);
            if (buyer == null) {
                System.out.println("Khong tim thay khach hang voi ID: " + customerId + ". Huy ban.");
                return;
            }

            System.out.print("Xac nhan ban? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Huy ban.");
                return;
            }

            petManager.assignOwner(id, customerId);
            log.addLog("Ban thu cung: " + id + " - " + pet.getName()
                    + " | Gia: " + pet.getPrice()
                    + " | Chu nhan: " + customerId + " - " + buyer.getName());
            System.out.println("Ban thanh cong!");
            System.out.println("  Thu cung : " + pet.getName());
            System.out.println("  Chu nhan : " + customerId + " - " + buyer.getName());
            System.out.println("  Doanh thu: " + pet.getPrice());

        } else {
            System.out.print("Xac nhan ban? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Huy ban.");
                return;
            }
            petManager.removeById(id);
            log.addLog("Ban thu cung: " + id + " - " + pet.getName()
                    + " | Gia: " + pet.getPrice()
                    + " | Nguoi mua: khach vang lai");
            System.out.println("Ban thanh cong!");
            System.out.println("  Thu cung : " + pet.getName());
            System.out.println("  Nguoi mua: khach vang lai");
            System.out.println("  Doanh thu: " + pet.getPrice());
        }
    }

    static void assignPetToCustomer() {
        System.out.print("Nhap ID thu cung: ");
        String petId = sc.nextLine();
        Pet pet = petManager.findById(petId);
        if (pet == null) {
            System.out.println("Khong tim thay thu cung voi ID: " + petId);
            return;
        }
        System.out.print("Nhap ID khach hang: ");
        String customerId = sc.nextLine();
        if (customerManager.findById(customerId) == null) {
            System.out.println("Khong tim thay khach hang voi ID: " + customerId);
            return;
        }
        petManager.assignOwner(petId, customerId);
        log.addLog("Gan thu cung " + petId + " cho khach hang " + customerId);
        System.out.println("Da gan " + pet.getName() + " cho khach hang " + customerId);
    }

    static void showPetsByCustomer() {
        System.out.print("Nhap ID khach hang: ");
        String customerId = sc.nextLine();
        if (customerManager.findById(customerId) == null) {
            System.out.println("Khong tim thay khach hang voi ID: " + customerId);
            return;
        }
        System.out.println("--- Thu cung cua khach hang " + customerId + " ---");
        List<Pet> pets = petManager.getPetsByOwner(customerId);
        if (pets.isEmpty()) {
            System.out.println("Khach hang nay chua co thu cung nao.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }

    // ===== 3.2 KHACH HANG =====

    static void registerCustomer() {
        System.out.print("Ma khach hang: ");
        String cid = sc.nextLine();
        System.out.print("Ten: ");
        String cname = sc.nextLine();
        System.out.print("So dien thoai: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(cid, cname, phone);
        if (customerManager.register(customer)) {
            log.addLog("Dang ky khach hang: " + cid + " - " + cname);
            System.out.println("Dang ky thanh cong!");
        }
    }

    static void findCustomer() {
        System.out.print("Nhap ma khach hang: ");
        String id = sc.nextLine();
        Customer customer = customerManager.findById(id);
        if (customer != null) {
            System.out.println("Thong tin khach hang: " + customer);
            System.out.println(">>> Ap dung giam gia cho khach hang than thiet!");
        } else {
            System.out.println("Khong tim thay khach hang voi ID: " + id);
        }
    }

    static void showCustomers() {
        System.out.println("--- Danh sach khach hang ---");
        customerManager.showAll();
    }

    // ===== 3.3 SPA =====

    static void addToSpa() {
        System.out.print("Nhap ID thu cung can them vao spa: ");
        String pid = sc.nextLine();
        Pet spaPet = petManager.findById(pid);
        if (spaPet != null) {
            spaService.addToQueue(spaPet);
            log.addLog("Them vao hang cho spa: " + pid);
            System.out.println("Da them " + spaPet.getName() + " vao hang cho spa.");
        } else {
            System.out.println("Khong tim thay thu cung voi ID: " + pid);
        }
    }

    static void serveNextSpa() {
        Pet pet = spaService.serveNext();
        if (pet != null) {
            log.addLog("Phuc vu spa: " + pet.getId());
            System.out.println(">>> Dang tam rua / cat tinh cho: " + pet);
        } else {
            System.out.println("Hang cho spa dang trong.");
        }
    }

    static void showSpaQueue() {
        System.out.println("--- Hang cho spa hien tai ---");
        spaService.showQueue();
    }

    // ===== 3.4 NHAT KY =====

    static void showLogs() {
        System.out.println("--- Nhat ky hoat dong ---");
        log.showLogs();
    }

    static void undo() {
        System.out.println("Hoan tac: " + log.undo());
    }
}
