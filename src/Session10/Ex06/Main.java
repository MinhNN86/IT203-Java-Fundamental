package Session10.Ex06;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500));
        products.add(new Product("Mouse", 20));
        products.add(new Product("Keyboard", 50));
        products.add(new Product("Monitor", 300));

        // ===== SẮP XẾP BẰNG ANONYMOUS CLASS (theo giá tăng dần) =====
        products.sort(new Comparator<Product>() {

            // Trường hợp BẮT BUỘC dùng Anonymous Class:
            // - Khi cần thêm thuộc tính nội bộ
            // - Khi cần logic phức tạp hoặc nhiều phương thức hỗ trợ
            // Lambda KHÔNG cho phép khai báo biến instance

            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("Danh sách sản phẩm sắp xếp theo GIÁ tăng dần:");
        for (Product p : products) {
            System.out.println(p);
        }

        // ===== SẮP XẾP BẰNG LAMBDA (theo tên A-Z) =====
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("\nDanh sách sản phẩm sắp xếp theo TÊN (A-Z):");
        products.forEach(System.out::println);
    }
}

