package Session02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soNgayTre;

        final int TRU_DIEM = 2;
        int tongDiem = 100;

        System.out.println("--- HE THONG DANH GIA DOC GIA ---");
        System.out.println("(Nhap so ngay tre. Nhap 999 de ket thuc)");
        while (true) {
            System.out.print("So ngay tre cua lan nay: ");
            soNgayTre = Integer.parseInt(sc.nextLine());
            if (soNgayTre == 999) {
                break;
            }
            if (soNgayTre <= 0) {
                System.out.println("-> Tra dung/som han: +5 diem.");
                tongDiem += 5;
            } else {
                int truDiem = soNgayTre * TRU_DIEM;
                System.out.println("-> Tra tre " + soNgayTre + " ngay: -" + truDiem + " diem.");
                tongDiem -= truDiem;
            }
            System.out.println();
        }

        sc.close();

        System.out.println("Tong diem uy tin: " + tongDiem);
        if (tongDiem > 120) {
            System.out.println("Xep loai: DOC GIA THAN THIET");
        } else if (tongDiem >= 80) {
            System.out.println("Xep loai: DOC GIA TIEU CHUAN");
        } else {
            System.out.println("Xep loai: DOC GIA CAN LUU Y");
        }
    }
}
