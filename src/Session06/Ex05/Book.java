package Session06.Ex05;

public class Book {
    private String id;
    private String title;
    private String author;
    private double price;

    public Book(String id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("=== THÔNG TIN SÁCH ===");
        System.out.println("ID: " + this.id);
        System.out.println("Tiêu đề: " + this.title);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Giá: $" + this.price);
        System.out.println("========================");
    }

    public static void main(String[] args) {
        Book book1 = new Book("B001", "Java Programming", "Nguyen Van A", 29.99);
        Book book2 = new Book("B002", "Data Structures", "Tran Thi B", 39.99);

        book1.displayInfo();
        System.out.println();
        book2.displayInfo();
    }
}
