package Session13.Ex06;

import java.util.*;

public class Main {

    static List<Medicine> cart = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== ỨNG DỤNG KÊ ĐƠN THUỐC =====");
            System.out.println("1. Thêm thuốc");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá rẻ (<50.000)");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printInvoice();
                    break;
                case 5:
                    findCheapMedicine();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // 1. Thêm thuốc
    static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = scanner.nextLine();

        for (Medicine m : cart) {
            if (m.getDrugId().equals(id)) {
                System.out.print("Thuốc đã tồn tại. Nhập số lượng thêm: ");
                int qty = Integer.parseInt(scanner.nextLine());
                m.setQuantity(m.getQuantity() + qty);
                System.out.println("Đã cộng dồn số lượng!");
                return;
            }
        }

        System.out.print("Nhập tên thuốc: ");
        String name = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        cart.add(new Medicine(id, name, price, quantity));
        System.out.println("Thêm thuốc thành công!");
    }

    // 2. Điều chỉnh số lượng
    static void updateQuantity() {
        System.out.print("Nhập mã thuốc: ");
        String id = scanner.nextLine();

        for (Medicine m : cart) {
            if (m.getDrugId().equals(id)) {
                System.out.print("Nhập số lượng mới: ");
                int newQty = Integer.parseInt(scanner.nextLine());

                if (newQty == 0) {
                    cart.remove(m);
                    System.out.println("Đã xóa thuốc khỏi đơn!");
                } else {
                    m.setQuantity(newQty);
                    System.out.println("Cập nhật thành công!");
                }
                return;
            }
        }

        System.out.println("Không tìm thấy thuốc!");
    }

    // 3. Xóa thuốc
    static void removeMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = scanner.nextLine();

        Iterator<Medicine> iterator = cart.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getDrugId().equals(id)) {
                iterator.remove();
                System.out.println("Xóa thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy thuốc!");
    }

    // 4. In hóa đơn
    static void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống!");
            return;
        }

        double total = 0;

        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n",
                "Mã", "Tên", "Giá", "SL", "Thành tiền");

        for (Medicine m : cart) {
            System.out.printf("%-10s %-20s %-10.0f %-10d %-10.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    m.getTotalPrice());
            total += m.getTotalPrice();
        }

        System.out.println("---------------------------------------------");
        System.out.println("TỔNG TIỀN: " + total + " VNĐ");

        cart.clear(); // Xóa toàn bộ sau khi in
        System.out.println("Đơn thuốc đã được làm mới!");
    }

    // 5. Tìm thuốc giá rẻ
    static void findCheapMedicine() {
        boolean found = false;

        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " + m.getDrugName() +
                        " - " + m.getUnitPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có thuốc giá rẻ!");
        }
    }
}
