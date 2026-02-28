package Session14.LyThuyet;

import java.util.*;

/**
 * DEMO COMPARABLE VÀ COMPARATOR TRONG JAVA
 *
 * Comparable : Interface dùng để định nghĩa thứ tự TỰ NHIÊN (natural order)
 * ngay bên trong lớp đó.
 * → Lớp phải implements Comparable<T> và override compareTo().
 * → Chỉ CÓ MỘT cách sắp xếp duy nhất cho lớp.
 *
 * Comparator : Interface dùng để định nghĩa thứ tự SẮP XẾP BÊN NGOÀI lớp.
 * → Tạo nhiều Comparator khác nhau (theo tên, tuổi, điểm, …).
 * → Dùng khi không muốn (hoặc không thể) sửa lớp gốc.
 *
 * Khi nào dùng Comparable? → Khi có một tiêu chí sắp xếp "mặc định" (vd:
 * lương).
 * Khi nào dùng Comparator? → Khi cần nhiều tiêu chí, hoặc lớp là của thư viện
 * ngoài.
 */
public class DemoComparable_Comparator {

    // =========================================================
    // LỚP Student IMPLEMENTS Comparable ( sắp xếp mặc định theo GPA giảm dần )
    // =========================================================
    static class Student implements Comparable<Student> {
        String name;
        int age;
        double gpa;

        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        // compareTo() – bắt buộc khi implements Comparable<T>
        // Quy ước trả về:
        // < 0 : this đứng TRƯỚC o (nhỏ hơn)
        // = 0 : this bằng o
        // > 0 : this đứng SAU o (lớn hơn)
        // Ở đây sắp xếp GPA GIẢM DẦN nên đảo ngược: o.gpa - this.gpa
        @Override
        public int compareTo(Student o) {
            return Double.compare(o.gpa, this.gpa); // GPA cao hơn đứng trước
        }

        @Override
        public String toString() {
            return String.format("%-8s age=%-3d gpa=%.1f", name, age, gpa);
        }
    }

    // =========================================================
    // CÁC COMPARATOR DÙNG BÊN NGOÀI LỚP Student
    // =========================================================

    // Comparator 1: sắp xếp theo TÊN tăng dần (A → Z)
    static Comparator<Student> byNameAsc = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            // compare() – bắt buộc khi implements Comparator<T>
            // Quy ước giống compareTo(): < 0 s1 đứng trước, > 0 s2 đứng trước
            return s1.name.compareTo(s2.name);
        }
    };

    // Comparator 2: sắp xếp theo TUỔI tăng dần (lambda – cách viết gọn hơn)
    static Comparator<Student> byAgeAsc = (s1, s2) -> s1.age - s2.age;

    // Comparator 3: sắp xếp theo GPA tăng dần
    static Comparator<Student> byGpaAsc = Comparator.comparingDouble(s -> s.gpa);

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Minh", 21, 3.5),
                new Student("An", 20, 3.8),
                new Student("Bảo", 22, 3.2),
                new Student("Châu", 20, 3.8),
                new Student("Dũng", 23, 3.0)));

        // =========================================================
        // 1. COMPARABLE – compareTo()
        // =========================================================
        System.out.println("===== 1. COMPARABLE – compareTo() =====");
        // Khi lớp implements Comparable, Collections.sort() / Arrays.sort()
        // tự động gọi compareTo() để so sánh.
        Collections.sort(students); // dùng compareTo() trong Student
        System.out.println("Sắp xếp mặc định (GPA giảm dần – compareTo):");
        students.forEach(s -> System.out.println("  " + s));

        // Gọi trực tiếp compareTo() để so sánh 2 đối tượng
        Student s1 = new Student("X", 20, 3.9);
        Student s2 = new Student("Y", 20, 3.5);
        int cmp = s1.compareTo(s2);
        System.out.println("\ns1.compareTo(s2) = " + cmp
                + (cmp < 0 ? " → s1 đứng TRƯỚC s2" : cmp > 0 ? " → s1 đứng SAU s2" : " → s1 BẰNG s2"));

        // =========================================================
        // 2. COMPARATOR – compare()
        // =========================================================
        System.out.println("\n===== 2. COMPARATOR – compare() =====");

        // Truyền Comparator vào Collections.sort() hoặc list.sort()
        students.sort(byNameAsc);
        System.out.println("Sắp xếp theo TÊN tăng dần (byNameAsc):");
        students.forEach(s -> System.out.println("  " + s));

        students.sort(byAgeAsc);
        System.out.println("\nSắp xếp theo TUỔI tăng dần (byAgeAsc):");
        students.forEach(s -> System.out.println("  " + s));

        // Gọi trực tiếp compare() để so sánh 2 đối tượng
        int cmpName = byNameAsc.compare(
                new Student("Minh", 20, 3.5),
                new Student("An", 20, 3.8));
        System.out.println("\nbyNameAsc.compare(Minh, An) = " + cmpName
                + (cmpName > 0 ? " → 'Minh' đứng SAU 'An'" : " → 'Minh' đứng TRƯỚC 'An'"));

        // =========================================================
        // 3. Comparator.comparing() – tạo Comparator từ key extractor
        // =========================================================
        System.out.println("\n===== 3. Comparator.comparing() =====");
        // comparing(keyExtractor) : so sánh theo trường / biểu thức trích xuất
        // comparingInt(), comparingDouble(), comparingLong() dành cho primitive

        Comparator<Student> byName = Comparator.comparing(s -> s.name);
        Comparator<Student> byAge = Comparator.comparingInt(s -> s.age);
        Comparator<Student> byGpa = Comparator.comparingDouble(s -> s.gpa);

        students.sort(byName);
        System.out.println("Comparator.comparing(name) – tên tăng dần:");
        students.forEach(s -> System.out.println("  " + s));

        students.sort(byGpa);
        System.out.println("\nComparator.comparingDouble(gpa) – GPA tăng dần:");
        students.forEach(s -> System.out.println("  " + s));

        // =========================================================
        // 4. reversed() – đảo ngược thứ tự
        // =========================================================
        System.out.println("\n===== 4. reversed() =====");
        // reversed() trả về Comparator ngược lại hoàn toàn.

        Comparator<Student> byNameDesc = Comparator.comparing((Student s) -> s.name).reversed();
        students.sort(byNameDesc);
        System.out.println("Sắp xếp tên GIẢM DẦN (Z → A) dùng reversed():");
        students.forEach(s -> System.out.println("  " + s));

        // =========================================================
        // 5. thenComparing() – sắp xếp theo nhiều tiêu chí
        // =========================================================
        System.out.println("\n===== 5. thenComparing() =====");
        // thenComparing() được gọi sau comparator đầu tiên.
        // Nếu hai phần tử BẰNG NHAU theo tiêu chí đầu → áp dụng tiêu chí tiếp theo.

        // Sắp xếp: GPA giảm dần → nếu GPA bằng nhau thì tên tăng dần
        Comparator<Student> byGpaDescThenName = Comparator.comparingDouble((Student s) -> s.gpa)
                .reversed()
                .thenComparing(s -> s.name);

        students.sort(byGpaDescThenName);
        System.out.println("GPA giảm dần, nếu bằng nhau thì tên tăng dần:");
        students.forEach(s -> System.out.println("  " + s));

        // Sắp xếp: tuổi tăng dần → GPA tăng dần → tên tăng dần
        Comparator<Student> byAgeThenGpaThenName = Comparator.comparingInt((Student s) -> s.age)
                .thenComparingDouble(s -> s.gpa)
                .thenComparing(s -> s.name);

        students.sort(byAgeThenGpaThenName);
        System.out.println("\nTuổi tăng → GPA tăng → Tên tăng:");
        students.forEach(s -> System.out.println("  " + s));

        // =========================================================
        // 6. Comparator.naturalOrder() & reverseOrder()
        // =========================================================
        System.out.println("\n===== 6. naturalOrder() & reverseOrder() =====");
        // naturalOrder() : sắp xếp theo thứ tự tự nhiên (dùng compareTo của đối tượng)
        // reverseOrder() : ngược lại thứ tự tự nhiên

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9, 2));
        System.out.println("Danh sách gốc: " + numbers);

        numbers.sort(Comparator.naturalOrder());
        System.out.println("naturalOrder() – tăng dần: " + numbers);

        numbers.sort(Comparator.reverseOrder());
        System.out.println("reverseOrder() – giảm dần: " + numbers);

        List<String> names = new ArrayList<>(Arrays.asList("Minh", "An", "Châu", "Bảo"));
        names.sort(Comparator.naturalOrder());
        System.out.println("String naturalOrder(): " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("String reverseOrder(): " + names);

        // =========================================================
        // 7. Dùng Comparable với TreeSet / TreeMap (tự động sắp xếp)
        // =========================================================
        System.out.println("\n===== 7. Comparable với TreeSet =====");
        // TreeSet sử dụng compareTo() (Comparable) để duy trì thứ tự tự động.

        TreeSet<Student> treeSetByGpa = new TreeSet<>(); // dùng compareTo() mặc định
        treeSetByGpa.add(new Student("Minh", 21, 3.5));
        treeSetByGpa.add(new Student("An", 20, 3.8));
        treeSetByGpa.add(new Student("Bảo", 22, 3.2));

        System.out.println("TreeSet (sắp xếp tự động bằng compareTo – GPA giảm dần):");
        treeSetByGpa.forEach(s -> System.out.println("  " + s));

        // =========================================================
        // 8. Dùng Comparator với TreeSet / TreeMap
        // =========================================================
        System.out.println("\n===== 8. Comparator với TreeSet =====");
        // Truyền Comparator vào constructor của TreeSet/TreeMap.

        TreeSet<Student> treeSetByName = new TreeSet<>(Comparator.comparing(s -> s.name));
        treeSetByName.add(new Student("Minh", 21, 3.5));
        treeSetByName.add(new Student("An", 20, 3.8));
        treeSetByName.add(new Student("Bảo", 22, 3.2));

        System.out.println("TreeSet với Comparator (sắp xếp theo tên):");
        treeSetByName.forEach(s -> System.out.println("  " + s));

        // =========================================================
        // 9. Comparator.nullsFirst() & nullsLast()
        // =========================================================
        System.out.println("\n===== 9. nullsFirst() & nullsLast() =====");
        // Xử lý an toàn khi danh sách có phần tử null.
        // nullsFirst(comparator) : null đứng ĐẦU danh sách
        // nullsLast(comparator) : null đứng CUỐI danh sách

        List<String> withNulls = new ArrayList<>(Arrays.asList("Cam", null, "Bơ", null, "Ổi"));
        System.out.println("Danh sách gốc: " + withNulls);

        withNulls.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("nullsFirst + naturalOrder: " + withNulls);

        withNulls.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("nullsLast  + naturalOrder: " + withNulls);

        // =========================================================
        // 10. TỔNG KẾT SO SÁNH
        // =========================================================
        System.out.println("\n===== 10. TỔNG KẾT SO SÁNH =====");
        System.out.println("+------------------+-----------------------------+-----------------------------+");
        System.out.println("| Tiêu chí         | Comparable                  | Comparator                  |");
        System.out.println("+------------------+-----------------------------+-----------------------------+");
        System.out.println("| Package          | java.lang                   | java.util                   |");
        System.out.println("| Phương thức      | compareTo(T o)              | compare(T o1, T o2)         |");
        System.out.println("| Vị trí định nghĩa| Bên TRONG lớp               | Bên NGOÀI lớp               |");
        System.out.println("| Số tiêu chí      | Chỉ 1 (thứ tự mặc định)    | Nhiều, tạo mới tùy ý        |");
        System.out.println("| Sửa lớp gốc?     | Cần sửa lớp gốc             | Không cần sửa               |");
        System.out.println("| Dùng cho         | TreeSet/TreeMap mặc định    | sort(), TreeSet(comp), …    |");
        System.out.println("+------------------+-----------------------------+-----------------------------+");
    }
}
