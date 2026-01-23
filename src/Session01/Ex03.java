package Session01;

public class Ex03 {
    public static void main(String[] args) {
        // Hai biến kiểu String được khai báo
        // Biến book1 và book2 nằm trên STACK
        // Giá trị của chúng là địa chỉ trỏ tới object String trên HEAP
        String book1 = "Java Basic";
        String book2 = "Python Intro";

        // In ra giá trị ban đầu
        System.out.println("Trước khi hoán đổi:");
        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);

        // Biến tạm temp cũng nằm trên STACK
        // temp trỏ tới cùng object String "Java Basic" trên HEAP
        String temp = book1;

        // book1 được gán địa chỉ mà book2 đang trỏ tới
        // => book1 trỏ tới object "Python Intro" trên HEAP
        book1 = book2;

        // book2 được gán địa chỉ mà temp đang trỏ tới
        // => book2 trỏ tới object "Java Basic" trên HEAP
        book2 = temp;

        // In ra kết quả sau khi hoán đổi
        System.out.println("\nSau khi hoán đổi:");
        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);
    }
}
