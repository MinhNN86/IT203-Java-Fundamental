package Session14.LyThuyet;

import java.util.*;

public class DemoSet {

    public static void main(String[] args) {

        // =========================================================
        // 1. ĐẶC ĐIỂM CỦA COLLECTION SET
        // =========================================================
        System.out.println("===== 1. ĐẶC ĐIỂM CỦA COLLECTION SET =====");
        // - Không cho phép phần tử trùng lặp
        // - Không đảm bảo thứ tự (HashSet), có thứ tự được sắp xếp (TreeSet), giữ thứ
        // tự thêm vào (LinkedHashSet)
        // - Cho phép 1 phần tử null (HashSet, LinkedHashSet), không cho null (TreeSet)

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        String[] data = { "Banana", "Apple", "Cherry", "Apple", "Banana" }; // có phần tử trùng
        for (String s : data) {
            hashSet.add(s);
            linkedHashSet.add(s);
            treeSet.add(s);
        }

        System.out.println("HashSet (không thứ tự, không trùng):      " + hashSet);
        System.out.println("LinkedHashSet (giữ thứ tự thêm, không trùng): " + linkedHashSet);
        System.out.println("TreeSet (sắp xếp tăng dần, không trùng):  " + treeSet);

        // =========================================================
        // 2. PHƯƠNG THỨC add()
        // =========================================================
        System.out.println("\n===== 2. PHƯƠNG THỨC add() =====");
        Set<Integer> set = new LinkedHashSet<>();

        boolean added1 = set.add(10);
        boolean added2 = set.add(20);
        boolean added3 = set.add(10); // trùng lặp -> không thêm được

        System.out.println("Thêm 10: " + added1); // true
        System.out.println("Thêm 20: " + added2); // true
        System.out.println("Thêm 10 (trùng): " + added3); // false
        System.out.println("Set sau khi add: " + set);

        // =========================================================
        // 3. PHƯƠNG THỨC size() & isEmpty()
        // =========================================================
        System.out.println("\n===== 3. PHƯƠNG THỨC size() & isEmpty() =====");
        Set<String> fruits = new LinkedHashSet<>();
        System.out.println("isEmpty() lúc mới tạo: " + fruits.isEmpty()); // true
        System.out.println("size() lúc mới tạo: " + fruits.size()); // 0

        fruits.add("Xoài");
        fruits.add("Cam");
        fruits.add("Dưa hấu");

        System.out.println("isEmpty() sau khi thêm: " + fruits.isEmpty()); // false
        System.out.println("size() sau khi thêm: " + fruits.size()); // 3

        // =========================================================
        // 4. PHƯƠNG THỨC contains()
        // =========================================================
        System.out.println("\n===== 4. PHƯƠNG THỨC contains() =====");
        System.out.println("Set hiện tại: " + fruits);
        System.out.println("contains('Cam'): " + fruits.contains("Cam")); // true
        System.out.println("contains('Nho'): " + fruits.contains("Nho")); // false

        // =========================================================
        // 5. PHƯƠNG THỨC remove()
        // =========================================================
        System.out.println("\n===== 5. PHƯƠNG THỨC remove() =====");
        System.out.println("Set trước khi xóa: " + fruits);

        boolean removed1 = fruits.remove("Cam");
        boolean removed2 = fruits.remove("Nho"); // không tồn tại

        System.out.println("remove('Cam'): " + removed1); // true
        System.out.println("remove('Nho'): " + removed2); // false
        System.out.println("Set sau khi xóa: " + fruits);

        // =========================================================
        // 6. PHƯƠNG THỨC clear()
        // =========================================================
        System.out.println("\n===== 6. PHƯƠNG THỨC clear() =====");
        Set<String> colors = new LinkedHashSet<>(Arrays.asList("Đỏ", "Xanh", "Vàng"));
        System.out.println("Set trước clear(): " + colors);
        System.out.println("size() trước clear(): " + colors.size());

        colors.clear();

        System.out.println("Set sau clear(): " + colors);
        System.out.println("isEmpty() sau clear(): " + colors.isEmpty()); // true

        // =========================================================
        // 7. CÁC PHƯƠNG THỨC addAll(), removeAll(), retainAll()
        // =========================================================
        System.out.println("\n===== 7. addAll() / removeAll() / retainAll() =====");
        Set<Integer> setA = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new LinkedHashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // addAll() - hợp (union)
        Set<Integer> union = new LinkedHashSet<>(setA);
        union.addAll(setB);
        System.out.println("setA: " + setA);
        System.out.println("setB: " + setB);
        System.out.println("addAll() - Hợp (A ∪ B):      " + union);

        // retainAll() - giao (intersection)
        Set<Integer> intersection = new LinkedHashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("retainAll() - Giao (A ∩ B):  " + intersection);

        // removeAll() - hiệu (difference)
        Set<Integer> difference = new LinkedHashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("removeAll() - Hiệu (A \\ B): " + difference);

        // =========================================================
        // 8. CHUYỂN ĐỔI GIỮA SET VÀ LIST
        // =========================================================
        System.out.println("\n===== 8. CHUYỂN ĐỔI SET VÀ LIST =====");

        // List -> Set (loại bỏ trùng lặp)
        List<String> listWithDuplicates = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B", "D"));
        System.out.println("List ban đầu (có trùng): " + listWithDuplicates);

        Set<String> setFromList = new LinkedHashSet<>(listWithDuplicates);
        System.out.println("Set từ List (đã loại trùng): " + setFromList);

        // Set -> List
        List<String> listFromSet = new ArrayList<>(setFromList);
        System.out.println("List từ Set: " + listFromSet);
        System.out.println("Truy cập theo index (get(1)): " + listFromSet.get(1)); // Set không hỗ trợ get(index)

        // =========================================================
        // 9. KẾT LUẬN
        // =========================================================
        System.out.println("\n===== 9. KẾT LUẬN =====");
        System.out.println("- Set không cho phép phần tử trùng lặp.");
        System.out.println("- HashSet: nhanh nhất, không đảm bảo thứ tự.");
        System.out.println("- LinkedHashSet: giữ thứ tự thêm vào.");
        System.out.println("- TreeSet: tự động sắp xếp tăng dần.");
        System.out.println("- Dùng Set khi cần loại trùng lặp hoặc kiểm tra tồn tại nhanh.");

        // =========================================================
        // BONUS: SET VỚI OBJECT - TẦM QUAN TRỌNG CỦA equals() & hashCode()
        // =========================================================
        System.out.println("\n===== BONUS: OBJECT TRONG SET =====");

        // --- TRƯỜNG HỢP 1: KHÔNG override equals() & hashCode() ---
        System.out.println("\n[Không override equals() & hashCode()]");
        Set<StudentWithout> setWithout = new HashSet<>();
        setWithout.add(new StudentWithout(1, "An"));
        setWithout.add(new StudentWithout(2, "Bình"));
        setWithout.add(new StudentWithout(1, "An")); // trùng id+tên, nhưng Set KHÔNG nhận ra

        System.out.println("Số phần tử (mong đợi 2, thực tế): " + setWithout.size()); // 3 (sai!)
        for (StudentWithout s : setWithout) {
            System.out.println("  " + s);
        }

        // --- TRƯỜNG HỢP 2: CÓ override equals() & hashCode() ---
        System.out.println("\n[Có override equals() & hashCode()]");
        Set<StudentWith> setWith = new HashSet<>();
        setWith.add(new StudentWith(1, "An"));
        setWith.add(new StudentWith(2, "Bình"));
        setWith.add(new StudentWith(1, "An")); // trùng -> Set nhận ra và bỏ qua

        System.out.println("Số phần tử (mong đợi 2, thực tế): " + setWith.size()); // 2 (đúng!)
        for (StudentWith s : setWith) {
            System.out.println("  " + s);
        }

        // contains() cũng hoạt động đúng khi có override
        System.out.println("contains(id=1, 'An'): " + setWith.contains(new StudentWith(1, "An"))); // true
        System.out.println("contains(id=3, 'C'):  " + setWith.contains(new StudentWith(3, "C"))); // false
    }

    // =========================================================
    // Class KHÔNG override equals() & hashCode()
    // => Set dùng địa chỉ bộ nhớ để so sánh -> 2 object khác nhau dù cùng dữ liệu
    // =========================================================
    static class StudentWithout {
        int id;
        String name;

        StudentWithout(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student(" + id + ", " + name + ")";
        }
        // Không có equals() và hashCode() -> kế thừa mặc định từ Object (so sánh địa
        // chỉ)
    }

    // =========================================================
    // Class CÓ override equals() & hashCode()
    // => Set so sánh đúng theo giá trị id và name
    // =========================================================
    static class StudentWith {
        int id;
        String name;

        StudentWith(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof StudentWith))
                return false;
            StudentWith other = (StudentWith) o;
            return this.id == other.id && this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Student(" + id + ", " + name + ")";
        }
    }
}