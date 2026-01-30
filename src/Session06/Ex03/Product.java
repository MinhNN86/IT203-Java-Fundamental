package Session06.Ex03;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.setPrice(price);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Lỗi: ID không được rỗng!");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Lỗi: Tên sản phẩm không được rỗng!");
        }
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
            System.out.println("Cập nhật giá thành công: $" + price);
        } else {
            System.out.println("Lỗi: Giá sản phẩm phải lớn hơn 0! Giá hiện tại được giữ nguyên: $" + this.price);
        }
    }

    public void displayInfo() {
        System.out.println("=== THÔNG TIN SẢN PHẨM ===");
        System.out.println("ID: " + this.getId());
        System.out.println("Tên: " + this.getName());
        System.out.println("Giá: $" + this.getPrice());
        System.out.println("========================");
    }

    public void displayShortInfo() {
        System.out.printf("%-10s | %-20s | $%-10.2f\n",
                this.getId(), this.getName(), this.getPrice());
    }

    public static void main(String[] args) {
        Product product1 = new Product("P001", "Laptop Gaming", 1500.0);
        product1.displayInfo();

        product1.setPrice(2000.0);
        product1.setPrice(-500.0);

        product1.displayInfo();
    }
}
