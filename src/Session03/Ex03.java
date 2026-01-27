package Session03;

public class Ex03 {

    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        int max = quantities[0];

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.printf("Sách có lượng nhiều nhất (%d): %n", max);
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.printf("- %s%n", names[i]);
            }
        }
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        int min = quantities[0];

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.printf("Sách có số lượng ít nhất (%d): %n", min);
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.printf("- %s%n", names[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {
                "Lập trình Java",
                "Cấu trúc dữ liệu",
                "Giải thuật",
                "Clean Code",
                "Design Patterns"
        };

        int[] quantities = { 10, 5, 10, 2, 2 };
        maxQuantityOfBooks(names, quantities);
        System.out.println("------------");
        minQuantityOfBooks(names, quantities);
    }
}
