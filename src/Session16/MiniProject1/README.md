# Pet Kingdom — MiniProject1

Ứng dụng quản lý cửa hàng thú cưng chạy trên console, được xây dựng bằng Java thuần.  
Áp dụng các kiến thức: OOP, Generics, Collections (List, Map, Set, Queue, Stack), tổ chức package.

---

## Cấu trúc thư mục

```
MiniProject1/
├── model/
│   ├── Pet.java
│   └── Customer.java
├── manager/
│   ├── Manager.java
│   ├── PetManager.java
│   └── CustomerManager.java
├── service/
│   ├── SpaService.java
│   └── ActivityLog.java
└── Main.java
```

---

## Sơ đồ quan hệ các lớp

```
Manager<T>
    └── PetManager          sử dụng → Pet
CustomerManager             sử dụng → Customer
SpaService                  sử dụng → Pet
ActivityLog                 (độc lập, lưu String)

Main  →  PetManager
      →  CustomerManager
      →  SpaService
      →  ActivityLog
```

---

## Chi tiết từng folder / file

### 📁 model/ — Lớp thực thể (Entity)

Chứa các đối tượng dữ liệu thuần, không có logic nghiệp vụ.

#### `Pet.java`

Đại diện cho một con thú cưng trong cửa hàng.

| Thuộc tính | Kiểu   | Mô tả                 |
| ---------- | ------ | --------------------- |
| `id`       | String | Mã định danh duy nhất |
| `name`     | String | Tên thú cưng          |
| `species`  | String | Loài (chó, mèo...)    |
| `price`    | double | Giá bán               |

- Có đầy đủ getter cho tất cả các trường.
- Override `toString()` để in thông tin dạng đọc được.

#### `Customer.java`

Đại diện cho một khách hàng đã đăng ký.

| Thuộc tính | Kiểu   | Mô tả          |
| ---------- | ------ | -------------- |
| `id`       | String | Mã khách hàng  |
| `name`     | String | Tên khách hàng |
| `phone`    | String | Số điện thoại  |

- Có đầy đủ getter cho tất cả các trường.
- Override `toString()` để in thông tin dạng đọc được.

---

### 📁 manager/ — Lớp quản lý dữ liệu

Chứa logic lưu trữ, tìm kiếm, thêm/xóa đối tượng.

#### `Manager.java`

Lớp generic dùng chung, là **base class** cho các manager khác.

```java
protected List<T> list = new ArrayList<>();
```

| Phương thức  | Mô tả                            |
| ------------ | -------------------------------- |
| `add(T obj)` | Thêm một đối tượng vào danh sách |
| `getAll()`   | Trả về toàn bộ danh sách         |

> Dùng **Generics `<T>`** để tái sử dụng cho bất kỳ kiểu đối tượng nào.

---

#### `PetManager.java`

Kế thừa `Manager<Pet>`, bổ sung tìm kiếm và xóa theo ID.

| Phương thức             | Mô tả                               |
| ----------------------- | ----------------------------------- |
| `findById(String id)`   | Duyệt danh sách, trả về Pet khớp ID |
| `removeById(String id)` | Tìm và xóa Pet theo ID              |

> Cấu trúc dữ liệu: `ArrayList` — truy cập tuần tự, tìm kiếm O(n).

---

#### `CustomerManager.java`

Quản lý khách hàng bằng `HashMap`, kiểm tra trùng lặp bằng `HashSet`.

```java
private Map<String, Customer> customerMap = new HashMap<>();  // tra cứu theo ID — O(1)
private Set<String> phoneSet   = new HashSet<>();             // kiểm tra trùng SĐT — O(1)
```

| Phương thức            | Mô tả                                                                  |
| ---------------------- | ---------------------------------------------------------------------- |
| `register(Customer c)` | Thêm khách hàng; báo lỗi nếu **trùng ID** hoặc **trùng số điện thoại** |
| `findById(String id)`  | Tra cứu khách hàng theo ID — O(1)                                      |
| `showAll()`            | In toàn bộ danh sách khách hàng                                        |

> Cấu trúc dữ liệu: `HashMap` (tra cứu nhanh) + `HashSet` (chống trùng SĐT).

---

### 📁 service/ — Lớp dịch vụ

Chứa các tính năng nghiệp vụ độc lập.

#### `SpaService.java`

Quản lý hàng chờ dịch vụ spa cho thú cưng.

```java
private Queue<Pet> queue = new LinkedList<>();
```

| Phương thức           | Mô tả                                |
| --------------------- | ------------------------------------ |
| `addToQueue(Pet pet)` | Thêm thú vào cuối hàng chờ (`offer`) |
| `serveNext()`         | Lấy và xóa thú đầu hàng chờ (`poll`) |
| `showQueue()`         | In toàn bộ hàng chờ hiện tại         |

> Cấu trúc dữ liệu: `Queue` (LinkedList) — **FIFO**: con nào vào trước được phục vụ trước.

---

#### `ActivityLog.java`

Ghi lại lịch sử thao tác, hỗ trợ undo.

```java
private Stack<String> stack = new Stack<>();
```

| Phương thức             | Mô tả                                 |
| ----------------------- | ------------------------------------- |
| `addLog(String action)` | Đẩy thao tác vào đỉnh stack (`push`)  |
| `undo()`                | Lấy và xóa thao tác cuối cùng (`pop`) |
| `showLogs()`            | In toàn bộ lịch sử thao tác           |

> Cấu trúc dữ liệu: `Stack<String>` — **LIFO**: hoàn tác thao tác gần nhất.

---

### `Main.java` — Điểm khởi chạy & Giao diện người dùng

Xử lý vòng lặp menu và điều hướng đến các hàm tương ứng.

#### Menu đầy đủ

```
===== PET KINGDOM =====
-- Thu Cung --
 1. Them thu cung
 2. Hien thi danh sach thu cung
 3. Tim thu cung theo ID
 4. Xoa thu cung
-- Khach Hang --
 5. Dang ky khach hang
 6. Tra cuu khach hang theo ID
 7. Hien thi danh sach khach hang
-- Dich Vu Spa --
 8. Them thu cung vao hang cho spa
 9. Phuc vu thu cung tiep theo
10. Xem hang cho spa
-- He Thong --
11. Xem nhat ky hoat dong
12. Hoan tac (Undo)
 0. Thoat
```

#### Danh sách hàm

| Hàm                  | Nhóm chức năng | Mô tả                                          |
| -------------------- | -------------- | ---------------------------------------------- |
| `main()`             | —              | Vòng lặp chính, đọc lựa chọn và gọi hàm        |
| `printMenu()`        | —              | In menu ra màn hình                            |
| `addPet()`           | 3.1 Thu cưng   | Nhập thông tin và thêm thú cưng mới            |
| `showPets()`         | 3.1 Thu cưng   | Hiển thị toàn bộ danh sách thú cưng            |
| `findPet()`          | 3.1 Thu cưng   | Tìm và in thú cưng theo ID                     |
| `removePet()`        | 3.1 Thu cưng   | Xóa thú cưng theo ID (khi đã bán)              |
| `registerCustomer()` | 3.2 Khách hàng | Đăng ký khách hàng, kiểm tra trùng ID & SĐT    |
| `findCustomer()`     | 3.2 Khách hàng | Tra cứu khách hàng theo ID, thông báo giảm giá |
| `showCustomers()`    | 3.2 Khách hàng | Hiển thị toàn bộ danh sách khách hàng          |
| `addToSpa()`         | 3.3 Spa        | Tìm thú theo ID và thêm vào hàng chờ spa       |
| `serveNextSpa()`     | 3.3 Spa        | Phục vụ thú đầu hàng chờ (FIFO), in thông tin  |
| `showSpaQueue()`     | 3.3 Spa        | Hiển thị hàng chờ spa hiện tại                 |
| `showLogs()`         | 3.4 Nhật ký    | In toàn bộ lịch sử thao tác                    |
| `undo()`             | 3.4 Nhật ký    | Lấy ra và in thao tác gần nhất (LIFO)          |

---

## Luồng hoạt động chính

```
Khởi chạy Main
    │
    ▼
Hiển thị menu (printMenu)
    │
    ├─ [1]  addPet()          → PetManager.add()              → ActivityLog.addLog()
    ├─ [2]  showPets()        → PetManager.getAll()           → in ra màn hình
    ├─ [3]  findPet()         → PetManager.findById()         → in kết quả
    ├─ [4]  removePet()       → PetManager.removeById()       → ActivityLog.addLog()
    │
    ├─ [5]  registerCustomer() → CustomerManager.register()   → ActivityLog.addLog()
    │                             (kiểm tra trùng ID + SĐT)
    ├─ [6]  findCustomer()    → CustomerManager.findById()    → in kết quả + giảm giá
    ├─ [7]  showCustomers()   → CustomerManager.showAll()
    │
    ├─ [8]  addToSpa()        → PetManager.findById()
    │                         → SpaService.addToQueue()       → ActivityLog.addLog()
    ├─ [9]  serveNextSpa()    → SpaService.serveNext()        → ActivityLog.addLog()
    ├─ [10] showSpaQueue()    → SpaService.showQueue()
    │
    ├─ [11] showLogs()        → ActivityLog.showLogs()
    ├─ [12] undo()            → ActivityLog.undo()            → in thao tác bị hoàn tác
    └─ [0]  System.exit(0)
```

---

## Các khái niệm OOP & Collections được áp dụng

| Khái niệm     | Áp dụng tại                                             |
| ------------- | ------------------------------------------------------- |
| Encapsulation | Tất cả fields đều `private`, truy cập qua getter/method |
| Inheritance   | `PetManager extends Manager<Pet>`                       |
| Generics      | `Manager<T>` dùng được cho mọi kiểu đối tượng           |
| Polymorphism  | `toString()` được override ở `Pet`, `Customer`          |
| `ArrayList`   | `Manager<T>` — lưu danh sách thú cưng                   |
| `HashMap`     | `CustomerManager` — tra cứu khách hàng O(1)             |
| `HashSet`     | `CustomerManager` — kiểm tra trùng số điện thoại O(1)   |
| `Queue`       | `SpaService` — hàng chờ FIFO                            |
| `Stack`       | `ActivityLog` — lịch sử LIFO, hỗ trợ undo               |
