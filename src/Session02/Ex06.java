package Session02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String[] TEN_NGAY = { "Thu 2", "Thu 3", "Thu 4", "Thu 5", "Thu 6", "Thu 7", "Chu Nhat" };
        int soSachMuon;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int tong = 0;
        int soNgayMoCua = 0;

        for (int i = 0; i < 7; i++) {
            System.out.print("Nhap luot muon ngay " + TEN_NGAY[i] + ": ");
            soSachMuon = Integer.parseInt(sc.nextLine());
            if (soSachMuon == 0) {
                continue;
            }
            if (soSachMuon > max) {
                max = soSachMuon;
            }
            if (soSachMuon < min) {
                min = soSachMuon;
            }
            tong += soSachMuon;
            soNgayMoCua++;
        }
        sc.close();

        System.out.println("\n--- KET QUA THONG KE ---");
        if (soNgayMoCua > 0) {
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.printf("Trung binh luot muon/ngay: %.1f\n", (double) tong / soNgayMoCua);
        } else {
            System.out.println("Khong co ngay nao mo cua.");
        }
    }
}
