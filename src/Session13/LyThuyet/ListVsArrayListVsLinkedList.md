# Phân biệt List, ArrayList, LinkedList trong Java

## 1. List - Interface

### Định nghĩa

- **List** là một **interface** trong gói `java.util`
- Định nghĩa hợp đồng (contract) cho các collection có thứ tự
- Không thể khởi tạo trực tiếp

### Đặc điểm

- Các phần tử có **thứ tự** và có thể **trùng lặp**
- Hỗ trợ truy cập theo **index** (vị trí)
- Các method chính: `add()`, `get()`, `remove()`, `size()`, `isEmpty()`

### Thành phần triển khai

- `ArrayList`
- `LinkedList`
- `Vector` (cũ, không dùng)
- `Stack` (mở rộng Vector)

```java
// Không thể làm vậy
List<String> list = new List<>();  // ❌ Compile Error

// Phải sử dụng lớp concrete
List<String> list = new ArrayList<>();  // ✅
List<String> list = new LinkedList<>(); // ✅
```

---

## 2. ArrayList - Mảng Động

### Cách hoạt động

- Sử dụng **mảng nội bộ** để lưu trữ phần tử
- Mảng **tự động mở rộng** khi đầy (capacity tăng ~50%)

### Ưu điểm

| Tính năng            | Hiệu năng           |
| -------------------- | ------------------- |
| **Truy cập phần tử** | O(1) - Rất nhanh ⚡ |
| **Tìm kiếm**         | O(n) - Tuyến tính   |
| **Sử dụng bộ nhớ**   | Tiết kiệm 💾        |

### Nhược điểm

| Thao tác                | Hiệu năng                |
| ----------------------- | ------------------------ |
| **Thêm phần tử ở đầu**  | O(n) - Chậm 🐢           |
| **Xóa phần tử ở giữa**  | O(n) - Chậm 🐢           |
| **Thay đổi kích thước** | O(n) - Cần sao chép mảng |

### Cấu trúc bộ nhớ

```
ArrayList: [E0][E1][E2][E3][E4][Empty]...

Index: 0   1   2   3   4   5
Truy cập trực tiếp qua index
```

### Khi nào dùng

- ✅ Cần truy cập phần tử thường xuyên
- ✅ Dữ liệu ít thay đổi
- ✅ Cần tốc độ truy cập cao

---

## 3. LinkedList - Danh Sách Liên Kết

### Cách hoạt động

- Sử dụng **danh sách liên kết kép** (doubly linked list)
- Mỗi node chứa: **giá trị** + **2 con trỏ** (trước/sau)

### Ưu điểm

| Thao tác                | Hiệu năng                    |
| ----------------------- | ---------------------------- |
| **Thêm phần tử ở đầu**  | O(1) - Rất nhanh ⚡          |
| **Thêm phần tử ở cuối** | O(1) - Rất nhanh ⚡          |
| **Xóa phần tử ở đầu**   | O(1) - Rất nhanh ⚡          |
| **Không cần resize**    | O(1) - Không cần sao chép 💪 |

### Nhược điểm

| Tính năng            | Hiệu năng                           |
| -------------------- | ----------------------------------- |
| **Truy cập phần tử** | O(n) - Phải duyệt từ đầu 🐢         |
| **Sử dụng bộ nhớ**   | O(n) - Cần thêm node cho con trỏ 📦 |

### Cấu trúc bộ nhớ

```
LinkedList:
[prev|E0|next] <-> [prev|E1|next] <-> [prev|E2|next]

Phải duyệt tuần tự từ đầu hoặc cuối
```

### Khi nào dùng

- ✅ Thêm/xóa thường xuyên ở đầu/cuối
- ✅ Triển khai Queue, Deque, Stack
- ✅ Dữ liệu thay đổi liên tục
- ❌ KHÔNG dùng nếu cần truy cập ngẫu nhiên

---

## 4. So sánh Chi tiết

| Tiêu chí           | ArrayList                     | LinkedList                           |
| ------------------ | ----------------------------- | ------------------------------------ |
| **Interface**      | List, Cloneable, Serializable | List, Deque, Cloneable, Serializable |
| **Cấu trúc**       | Mảng động                     | Danh sách liên kết kép               |
| **get(i)**         | O(1) ⚡                       | O(n) 🐢                              |
| **add(E)**         | O(1)\*                        | O(1) ⚡                              |
| **add(0, E)**      | O(n) 🐢                       | O(1) ⚡                              |
| **remove(i)**      | O(n) 🐢                       | O(n) 🐢                              |
| **remove(0)**      | O(n) 🐢                       | O(1) ⚡                              |
| **contains(E)**    | O(n)                          | O(n)                                 |
| **Bộ nhớ**         | Tiết kiệm                     | Lãng phí hơn (+16 bytes/node)        |
| **Cache-friendly** | Tốt (liên tục)                | Kém (phân tán)                       |
| **Thread-safe**    | Không                         | Không                                |

\*O(1) amortized - trung bình, O(n) khi cần resize

---

## 5. Performance Test (Ước tính)

### Thêm 100.000 phần tử ở cuối

```
ArrayList:   ~5ms
LinkedList:  ~10ms
```

### Thêm 100.000 phần tử ở đầu

```
ArrayList:   ~5000ms ❌
LinkedList:  ~15ms   ✅
```

### Truy cập 100.000 phần tử

```
ArrayList:   ~2ms    ✅
LinkedList:  ~1000ms ❌
```

---

## 6. Quyết định lựa chọn

### Dùng ArrayList khi:

```java
List<String> names = new ArrayList<>();
names.add("Alice");     // Thêm cuối - OK
names.add("Bob");
if (names.contains("Alice")) { }  // Tìm kiếm
System.out.println(names.get(0));  // Truy cập - Tốt
```

### Dùng LinkedList khi:

```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);      // Thêm cuối - Tốt
queue.remove();    // Xóa đầu - Tốt

Deque<String> deque = new LinkedList<>();
deque.addFirst("A");   // Thêm đầu - Tốt
deque.removeLast();    // Xóa cuối - Tốt
```

---

## 7. Kết luận

✅ **Mặc định dùng ArrayList** - Phù hợp 90% trường hợp
✅ **Dùng LinkedList** nếu cần Queue, Deque hoặc thêm/xóa đầu thường xuyên
✅ **Luôn khai báo kiểu List** - Dễ thay đổi triển khai sau

```java
// Tốt - interface, dễ thay đổi triển khai
List<String> list = new ArrayList<>();

// Không tốt - hard-coded kiểu concrete
ArrayList<String> list = new ArrayList<>();
```
