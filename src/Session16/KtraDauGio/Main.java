package Session16.KtraDauGio;

import java.util.*;

public class Main {
    static void displayAllProducts(ProductRepository repository) {
        for (Product p : repository.findAll()) {
            p.displayInfo();
            System.out.println("Giá cuối cùng: " + p.calculateFinalPrice());
            System.out.println("-----------------------");
        }
    }
    static void main(String[] args) {
        ProductRepository products = new ProductRepository();

        // Tạo danh sách sản phẩm
        // 2 ElectronicProduct
        products.add(new ElectronicProduct("E001", "Laptop", 15000000, 24));
        products.add(new ElectronicProduct("E002", "Smartphone", 8000000, 12));
        // 2 FoodProduct
        products.add(new FoodProduct("F001", "Bánh mì", 20000, 10));
        products.add(new FoodProduct("F002", "Sữa", 30000, 5));

        // Hiển thị toàn bộ danh sách sản phẩm
        System.out.println("Danh sách sản phẩm");
        displayAllProducts(products);

        // Tìm theo id
        System.out.println("=== TÌM SẢN PHẨM E01 ===");
        Product found = products.findById("E01");
        if (found != null) {
            found.displayInfo();
            System.out.println("Thành tiền: " + found.calculateFinalPrice());
        } else {
            System.out.println("Không tìm thấy!");
        }

        // 3. Sắp xếp theo giá tăng dần
        System.out.println("=== SẮP XẾP THEO GIÁ TĂNG DẦN ===");
        List<Product> sortedList = products.findAll();
        Collections.sort(sortedList, Comparator.comparingDouble(Product::getPrice));

        for (Product p : sortedList) {
            System.out.println(p.getId() + " - " + p.getPrice());
        }

        // Thống kê số lượng sản phẩm theo từng loại
        Map<String, Integer> productCount = new HashMap<>();
        for (Product p : products.findAll()) {
            String type = p instanceof ElectronicProduct ? "ElectronicProduct" : "FoodProduct";
            productCount.put(type, productCount.getOrDefault(type, 0) + 1);
        }
        System.out.println("Thống kê số lượng sản phẩm theo từng loại:");
        for(Map.Entry<String, Integer> entry : productCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
