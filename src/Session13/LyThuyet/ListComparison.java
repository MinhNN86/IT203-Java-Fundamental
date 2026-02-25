package Session13.LyThuyet;

import java.util.*;

/**
 * Demo so sánh List, ArrayList, LinkedList
 * 
 * List: Interface - hợp đồng cho collection có thứ tự
 * ArrayList: Dựa trên mảng - truy cập nhanh, thêm/xóa chậm ở giữa
 * LinkedList: Dựa trên danh sách liên kết - thêm/xóa nhanh, truy cập chậm
 */
public class ListComparison {

    public static void main(String[] args) {
        System.out.println("=== PHÂN BIỆT LIST, ARRAYLIST, LINKEDLIST ===\n");

        // 1. Khai báo kiểu List (interface)
        demoListInterface();

        // 2. Demo ArrayList
        System.out.println("\n--- DEMO ARRAYLIST ---");
        demoArrayList();

        // 3. Demo LinkedList
        System.out.println("\n--- DEMO LINKEDLIST ---");
        demoLinkedList();

        // 4. Performance comparison
        System.out.println("\n--- PERFORMANCE COMPARISON ---");
        performanceComparison();

        // 5. Khi nào dùng cái nào
        System.out.println("\n--- KHI NÀO DÙNG CÁI NÀO ---");
        usageGuideline();
    }

    /**
     * 1. List là Interface - không thể new trực tiếp
     */
    static void demoListInterface() {
        System.out.println("1. LIST là INTERFACE:");
        System.out.println("   - Không thể: List<String> list = new List<>();");
        System.out.println("   - Phải dùng lớp concrete: ArrayList, LinkedList\n");

        // Cách đúng: khai báo kiểu List, khởi tạo bằng ArrayList/LinkedList
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        List<String> list3 = new Vector<>(); // Cũ, ít dùng

        System.out.println("✓ List<String> list = new ArrayList<>();");
        System.out.println("✓ List<String> list = new LinkedList<>();");
        System.out.println("✓ List<String> list = new Vector<>();\n");
    }

    /**
     * 2. ArrayList - dựa trên mảng
     */
    static void demoArrayList() {
        List<Integer> arrayList = new ArrayList<>();

        System.out.println("Đặc điểm:");
        System.out.println("- Dựa trên MẢNG NỘI BỘ");
        System.out.println("- Truy cập phần tử: O(1) - RẤT NHANH ⚡");
        System.out.println("- Thêm/xóa ở giữa: O(n) - CHẬM 🐢\n");

        // Thêm phần tử
        System.out.println(">> Thêm phần tử:");
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i); // Thêm ở cuối - nhanh
        }
        long timeAdd = System.nanoTime() - start;
        System.out.println("   Thêm 10000 phần tử ở cuối: " + (timeAdd / 1_000_000) + "ms");

        // Truy cập phần tử
        System.out.println("\n>> Truy cập phần tử:");
        start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            int value = arrayList.get(5000); // Truy cập index 5000 - rất nhanh
            count++;
        }
        long timeGet = System.nanoTime() - start;
        System.out.println("   Truy cập 100000 lần index 5000: " + (timeGet / 1_000_000) + "ms");

        // Xóa ở đầu
        System.out.println("\n>> Xóa ở đầu:");
        arrayList.clear();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.remove(0); // Xóa ở đầu - chậm (phải dịch lùi tất cả)
        }
        long timeRemove = System.nanoTime() - start;
        System.out.println("   Xóa 100 phần tử ở đầu: " + (timeRemove / 1_000_000) + "ms\n");
    }

    /**
     * 3. LinkedList - dựa trên danh sách liên kết
     */
    static void demoLinkedList() {
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Đặc điểm:");
        System.out.println("- Dựa trên DANH SÁCH LIÊN KẾT (doubly linked)");
        System.out.println("- Truy cập phần tử: O(n) - CHẬM 🐢");
        System.out.println("- Thêm/xóa ở đầu/cuối: O(1) - RẤT NHANH ⚡\n");

        // Thêm phần tử ở cuối
        System.out.println(">> Thêm phần tử ở cuối:");
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        long timeAdd = System.nanoTime() - start;
        System.out.println("   Thêm 10000 phần tử ở cuối: " + (timeAdd / 1_000_000) + "ms");

        // Thêm phần tử ở đầu
        System.out.println("\n>> Thêm phần tử ở đầu (với addFirst):");
        start = System.nanoTime();
        Deque<Integer> deque = new LinkedList<>(linkedList);
        for (int i = 0; i < 1000; i++) {
            deque.addFirst(i); // Thêm ở đầu - rất nhanh
        }
        long timeAddFirst = System.nanoTime() - start;
        System.out.println("   Thêm 1000 phần tử ở đầu: " + (timeAddFirst / 1_000_000) + "ms");

        // Truy cập phần tử (phải duyệt)
        System.out.println("\n>> Truy cập phần tử:");
        start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            int value = linkedList.get(5000); // Phải duyệt từ đầu - chậm
            count++;
        }
        long timeGet = System.nanoTime() - start;
        System.out.println("   Truy cập 1000 lần index 5000: " + (timeGet / 1_000_000) + "ms\n");
    }

    /**
     * 4. So sánh performance
     */
    static void performanceComparison() {
        System.out.println("Benchmark [Số liệu ước tính]:\n");

        // Thêm 100k phần tử ở cuối
        System.out.println("1. Thêm 100.000 phần tử OỞ CUỐI:");
        perfTest("ArrayList", 100_000, (list) -> list.add(0), true);
        perfTest("LinkedList", 100_000, (list) -> ((Deque) list).addLast(0), true);

        // Thêm 10k phần tử ở đầu
        System.out.println("\n2. Thêm 10.000 phần tử ở ĐẦU:");
        perfTest("ArrayList", 10_000, (list) -> list.add(0, 0), true);
        perfTest("LinkedList", 10_000, (list) -> ((Deque) list).addFirst(0), true);

        // Truy cập 100k lần
        System.out.println("\n3. Truy cập 100.000 lần:");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10_000; i++) {
            list1.add(i);
            list2.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            list1.get(5000);
        }
        System.out.printf("   ArrayList:   %dms\n", (System.nanoTime() - start) / 1_000_000);

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) { // Giảm và 100_000 vì too slow
            list2.get(5000);
        }
        System.out.printf("   LinkedList:   %dms (10k lần)\n", (System.nanoTime() - start) / 1_000_000);
    }

    static void perfTest(String name, int count, java.util.function.Consumer<List<Integer>> operation,
            boolean isPrint) {
        List<Integer> list = name.equals("ArrayList") ? new ArrayList<>() : new LinkedList<>();
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            operation.accept(list);
        }
        long time = System.nanoTime() - start;
        if (isPrint) {
            System.out.printf("   %-12s: %dms\n", name, time / 1_000_000);
        }
    }

    /**
     * 5. Hướng dẫn sử dụng
     */
    static void usageGuideline() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              KHI NÀO DÙNG ARRAYLIST VS LINKEDLIST            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        System.out.println("✅ ARRAYLIST - 90% trường hợp:");
        System.out.println("   • Cần truy cập phần tử thường xuyên: list.get(i)");
        System.out.println("   • Dữ liệu ít thay đổi hoặc chỉ thêm ở cuối");
        System.out.println("   • Cần tốc độ truy cập cao");
        System.out.println("   • Dữ liệu không quá lớn\n");

        System.out.println("✅ LINKEDLIST - Trường hợp đặc biệt:");
        System.out.println("   • Cần thêm/xóa ở đầu thường xuyên");
        System.out.println("   • Triển khai Queue: queue.offer(), queue.poll()");
        System.out.println("   • Triển khai Deque: deque.addFirst(), deque.removeLast()");
        System.out.println("   • Dữ liệu thay đổi liên tục (insert/delete ở giữa)");
        System.out.println("   • Ít cần truy cập ngẫu nhiên\n");

        System.out.println("❌ KHÔNG nên dùng LinkedList:");
        System.out.println("   • Khi cần truy cập ngẫu nhiên thường xuyên");
        System.out.println("   • Khi chỉ thêm phần tử ở cuối (dùng ArrayList)");
        System.out.println("   • Khi bộ nhớ hạn chế (LinkedList dùng nhiều hơn)\n");

        System.out.println("💡 Best Practice:");
        System.out.println("   • Luôn khai báo kiểu List<T>, không ArrayList<T> hay LinkedList<T>");
        System.out.println("   • Dễ thay đổi triển khai sau mà không thay đổi code");
        System.out.println("   • Mặc định dùng ArrayList, chỉ dùng LinkedList khi hiệu năng có vấn đề\n");

        demoGoodPractice();
    }

    static void demoGoodPractice() {
        System.out.println("📝 DEMO Best Practice:\n");

        // ❌ Không tốt
        System.out.println("❌ Không tốt - hard-coded ArrayList:");
        System.out.println("   ArrayList<String> list = new ArrayList<>();");
        System.out.println("   list.add(\"Hello\");\n");

        // ✅ Tốt
        System.out.println("✅ Tốt - dùng interface List:");
        System.out.println("   List<String> list = new ArrayList<>();");
        System.out.println("   list.add(\"Hello\");\n");

        System.out.println("✅ Dễ thay đổi:");
        System.out.println("   List<String> list = new LinkedList<>();  // Chỉ thay dòng này");
        System.out.println("   list.add(\"Hello\");  // Code khác không đổi\n");
    }
}
