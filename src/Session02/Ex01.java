package Session02;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so tuoi cua ban: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap so sach dang muon: ");
        int borrowedBooks = Integer.parseInt(sc.nextLine());

        if (age >= 18 && borrowedBooks < 4) {
            System.out.println("Ket qua: Ban DU DIEU KIEN muon sach.");
            return;
        } else {
            System.out.println("Ket qua: Khong du dieu kien.");
        }

        if (age < 18) {
            System.out.println("- Ly do: Ban chua du tuoi.");
        }
        if (borrowedBooks >= 4) {
            System.out.println("- Ly do: Ban da muon qua so sach quy dinh.");
        }
        sc.close();
    }
}
