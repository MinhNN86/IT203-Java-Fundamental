package Session13.LyThuyet;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // 1. Khai báo và khởi tạo List
        List<String> students = new ArrayList<>();

        // 2. Thêm dữ liệu (Add)
        students.add("Nguyen Van A");
        students.add("Le Thi B");
        students.add("Tran Van C");
        students.add("Pham Thi D");

        // 3. Sửa dữ liệu (Set)
        students.set(2, "Tran Van X");

        // 4. Xóa dữ liệu (Remove)
        students.remove("Le Thi B");
        students.remove(1);

        // 5. Truy xuất và Duyệt danh sách
        System.out.println("Danh sách sinh viên ( " + students.size() + " bạn):");

        // Cách 1: Dùng vòng lặp for thường (kết hợp .get())
        for(int i = 0; i < students.size(); i++){
            System.out.println("Vị trí " + (i + 1) + ": " + students.get(i));
        }

        // Cách 2: Dùng for-each
        System.out.println("---Duyệt bằng for-each ---");
        for(String std : students){
            System.out.println(std);
        }
    }
}
