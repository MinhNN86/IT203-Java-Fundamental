package Session07;

public class Ex02 {
    static class Student {
        String name;
        int age;
    }

    public static void main(String[] args) {
        // ===== BIẾN NGUYÊN THỦY =====
        int a = 10;
        int b = a; // sao chép giá trị

        b = 20;

        System.out.println("Primitive variables:");
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20

        // Biến nguyên thủy (Primitive)
        // b = a → sao chép giá trị
        // Thay đổi b không ảnh hưởng đến a
        // Lưu trực tiếp trong Stack

        System.out.println("----------------------");
        // ===== BIẾN THAM CHIẾU =====
        Student s1 = new Student();
        s1.name = "Minh";
        s1.age = 20;

        Student s2 = s1; // sao chép địa chỉ

        s2.name = "An";
        s2.age = 22;

        // Biến tham chiếu (Reference)
        // s2 = s1 → sao chép địa chỉ
        // Thay đổi s2 ảnh hưởng đến s1
        // Lưu địa chỉ trong Stack, dữ liệu trong Heap

        System.out.println("Reference variables:");
        System.out.println("s1 name: " + s1.name + ", age: " + s1.age);
        System.out.println("s2 name: " + s2.name + ", age: " + s2.age);
    }
}
