package Session14.LyThuyet;

import java.util.*;

/**
 * DEMO MAP TRONG JAVA
 * Map là cấu trúc dữ liệu lưu trữ theo cặp KEY - VALUE.
 * - Mỗi KEY là duy nhất (không trùng lặp).
 * - Một KEY chỉ ánh xạ đến đúng một VALUE.
 * - Các implementation phổ biến: HashMap, LinkedHashMap, TreeMap.
 */
public class DemoMap {

    public static void main(String[] args) {

        // =========================================================
        // 1. ĐẶC ĐIỂM CỦA MAP
        // =========================================================
        System.out.println("===== 1. ĐẶC ĐIỂM CỦA MAP =====");
        // HashMap: không đảm bảo thứ tự, nhanh nhất
        // LinkedHashMap: giữ thứ tự thêm vào
        // TreeMap: tự sắp xếp key tăng dần

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        int[][] entries = { { 3, 0 }, { 1, 0 }, { 4, 0 }, { 2, 0 } };
        for (int[] e : entries) {
            hashMap.put(e[0], String.valueOf((char) ('A' + e[0] - 1)));
            linkedHashMap.put(e[0], String.valueOf((char) ('A' + e[0] - 1)));
            treeMap.put(e[0], String.valueOf((char) ('A' + e[0] - 1)));
        }

        System.out.println("HashMap       (không thứ tự): " + hashMap);
        System.out.println("LinkedHashMap (giữ thứ tự thêm): " + linkedHashMap);
        System.out.println("TreeMap       (sắp xếp key):  " + treeMap);

        // =========================================================
        // 2. PHƯƠNG THỨC put(key, value)
        // =========================================================
        System.out.println("\n===== 2. put(key, value) =====");
        // Thêm cặp key-value vào map.
        // Nếu key đã tồn tại -> ghi đè value cũ, trả về value cũ.
        // Nếu key chưa tồn tại -> trả về null.

        Map<String, Integer> scores = new LinkedHashMap<>();
        String old1 = String.valueOf(scores.put("An", 85)); // null (key mới)
        String old2 = String.valueOf(scores.put("Bình", 90)); // null (key mới)
        String old3 = String.valueOf(scores.put("An", 95)); // "85" (ghi đè, trả về giá trị cũ)

        System.out.println("put('An', 85)  -> value cũ: " + old1);
        System.out.println("put('Bình', 90)-> value cũ: " + old2);
        System.out.println("put('An', 95)  -> value cũ: " + old3); // 85
        System.out.println("Map sau put: " + scores);

        // =========================================================
        // 3. PHƯƠNG THỨC get(key)
        // =========================================================
        System.out.println("\n===== 3. get(key) =====");
        // Lấy value theo key. Trả về null nếu key không tồn tại.

        System.out.println("get('An'):    " + scores.get("An")); // 95
        System.out.println("get('Bình'):  " + scores.get("Bình")); // 90
        System.out.println("get('Cường'): " + scores.get("Cường")); // null

        // getOrDefault(key, defaultValue): trả về defaultValue nếu key không tồn tại
        System.out.println("getOrDefault('Cường', 0): " + scores.getOrDefault("Cường", 0)); // 0

        // =========================================================
        // 4. PHƯƠNG THỨC size() & isEmpty()
        // =========================================================
        System.out.println("\n===== 4. size() & isEmpty() =====");
        Map<String, String> emptyMap = new HashMap<>();
        System.out.println("isEmpty() lúc mới tạo: " + emptyMap.isEmpty()); // true
        System.out.println("size() lúc mới tạo:    " + emptyMap.size()); // 0

        emptyMap.put("k1", "v1");
        System.out.println("isEmpty() sau khi thêm: " + emptyMap.isEmpty()); // false
        System.out.println("size() sau khi thêm:    " + emptyMap.size()); // 1

        // =========================================================
        // 5. PHƯƠNG THỨC containsKey() & containsValue()
        // =========================================================
        System.out.println("\n===== 5. containsKey() & containsValue() =====");
        System.out.println("Map: " + scores);
        System.out.println("containsKey('An'):    " + scores.containsKey("An")); // true
        System.out.println("containsKey('Zorro'): " + scores.containsKey("Zorro")); // false
        System.out.println("containsValue(95):    " + scores.containsValue(95)); // true
        System.out.println("containsValue(0):     " + scores.containsValue(0)); // false

        // =========================================================
        // 6. PHƯƠNG THỨC remove()
        // =========================================================
        System.out.println("\n===== 6. remove(key) =====");
        // remove(key): xóa theo key, trả về value bị xóa (null nếu không tồn tại)
        // remove(key, value): chỉ xóa nếu key ánh xạ đúng value đó

        Map<String, Integer> map6 = new LinkedHashMap<>(scores);
        System.out.println("Map trước remove: " + map6);

        Integer removed = map6.remove("Bình");
        System.out.println("remove('Bình') -> value bị xóa: " + removed); // 90

        boolean removedExact = map6.remove("An", 999); // key đúng nhưng value sai -> không xóa
        System.out.println("remove('An', 999) -> " + removedExact); // false

        boolean removedExact2 = map6.remove("An", 95); // đúng cả key lẫn value -> xóa
        System.out.println("remove('An', 95)  -> " + removedExact2); // true
        System.out.println("Map sau remove: " + map6);

        // =========================================================
        // 7. PHƯƠNG THỨC clear()
        // =========================================================
        System.out.println("\n===== 7. clear() =====");
        Map<String, Integer> map7 = new LinkedHashMap<>(scores);
        System.out.println("Map trước clear(): " + map7);
        map7.clear();
        System.out.println("Map sau clear():  " + map7);
        System.out.println("isEmpty() sau clear(): " + map7.isEmpty()); // true

        // =========================================================
        // 8. DUYỆT MAP
        // =========================================================
        System.out.println("\n===== 8. DUYỆT MAP =====");
        Map<String, Integer> map8 = new LinkedHashMap<>();
        map8.put("An", 85);
        map8.put("Bình", 90);
        map8.put("Cường", 78);

        // Cách 1: duyệt entrySet() -> lấy cả key và value
        System.out.println("-- Dùng entrySet() --");
        for (Map.Entry<String, Integer> entry : map8.entrySet()) {
            System.out.println("  Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Cách 2: duyệt keySet() -> chỉ lấy key
        System.out.println("-- Dùng keySet() --");
        for (String key : map8.keySet()) {
            System.out.println("  Key: " + key + " -> " + map8.get(key));
        }

        // Cách 3: duyệt values() -> chỉ lấy value
        System.out.println("-- Dùng values() --");
        for (int value : map8.values()) {
            System.out.println("  Value: " + value);
        }

        // Cách 4: forEach (lambda - Java 8+)
        System.out.println("-- Dùng forEach (lambda) --");
        map8.forEach((k, v) -> System.out.println("  " + k + " => " + v));

        // =========================================================
        // 9. CÁC PHƯƠNG THỨC BỔ SUNG HỮU ÍCH
        // =========================================================
        System.out.println("\n===== 9. CÁC PHƯƠNG THỨC BỔ SUNG =====");
        Map<String, Integer> map9 = new LinkedHashMap<>();
        map9.put("An", 85);

        // putIfAbsent(key, value): chỉ thêm nếu key CHƯA tồn tại
        map9.putIfAbsent("An", 999); // An đã tồn tại -> bỏ qua
        map9.putIfAbsent("Bình", 90); // Bình chưa có -> thêm
        System.out.println("putIfAbsent: " + map9);

        // replace(key, value): thay thế value nếu key tồn tại
        map9.replace("An", 100);
        System.out.println("replace('An', 100): " + map9);

        // replace(key, oldValue, newValue): chỉ thay thế nếu value hiện tại khớp
        // oldValue
        boolean replaced = map9.replace("An", 100, 95);
        System.out.println("replace('An', 100, 95): " + replaced + " -> " + map9);

        // merge(key, value, BiFunction): gộp value nếu key đã tồn tại
        // Dùng để tổng hợp dữ liệu (VD đếm tần suất)
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = { "java", "python", "java", "c++", "java", "python" };
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum); // nếu đã có -> cộng thêm 1
        }
        System.out.println("merge() - đếm tần suất: " + wordCount);

        // =========================================================
        // 10. MAP VỚI OBJECT KEY - CẦN override equals() & hashCode()
        // =========================================================
        System.out.println("\n===== 10. OBJECT LÀM KEY - CẦN equals() & hashCode() =====");

        // Không override -> HashMap không nhận ra 2 key giống nhau
        Map<StudentKey, String> mapBad = new HashMap<>();
        mapBad.put(new StudentKey(1, "An"), "Lớp A");
        mapBad.put(new StudentKey(1, "An"), "Lớp B"); // cùng dữ liệu nhưng bị coi là key khác!
        System.out.println("[Không override] size (mong đợi 1, thực tế): " + mapBad.size()); // 2 (sai!)
        System.out.println("[Không override] get(id=1,'An'): " + mapBad.get(new StudentKey(1, "An"))); // null (sai!)

        // Có override -> HashMap hoạt động đúng
        Map<StudentKeyOK, String> mapGood = new HashMap<>();
        mapGood.put(new StudentKeyOK(1, "An"), "Lớp A");
        mapGood.put(new StudentKeyOK(1, "An"), "Lớp B"); // ghi đè
        System.out.println("[Có override]    size (mong đợi 1, thực tế): " + mapGood.size()); // 1 (đúng!)
        System.out.println("[Có override]    get(id=1,'An'): " + mapGood.get(new StudentKeyOK(1, "An"))); // Lớp B

        // =========================================================
        // 11. KẾT LUẬN
        // =========================================================
        System.out.println("\n===== 11. KẾT LUẬN =====");
        System.out.println("- Map lưu dữ liệu theo cặp KEY-VALUE, key không trùng lặp.");
        System.out.println("- HashMap:       nhanh, không đảm bảo thứ tự.");
        System.out.println("- LinkedHashMap: giữ thứ tự thêm vào.");
        System.out.println("- TreeMap:       tự sắp xếp key tăng dần (key phải Comparable).");
        System.out.println("- Nếu dùng object tự định nghĩa làm KEY -> bắt buộc override equals() & hashCode().");
    }

    // =========================================================
    // Class KHÔNG override equals() & hashCode() -> dùng làm key sẽ sai
    // =========================================================
    static class StudentKey {
        int id;
        String name;

        StudentKey(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student(" + id + "," + name + ")";
        }
    }

    // =========================================================
    // Class CÓ override equals() & hashCode() -> dùng làm key đúng
    // =========================================================
    static class StudentKeyOK {
        int id;
        String name;

        StudentKeyOK(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof StudentKeyOK))
                return false;
            StudentKeyOK other = (StudentKeyOK) o;
            return this.id == other.id && this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Student(" + id + "," + name + ")";
        }
    }
}
