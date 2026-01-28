package Session04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lyThuyet {
    public static void main(String[] args) {
        // Chuỗi trong java
        // String literal
        String str1 = "demo";
        String str2 = "demo";
        // String object
        String str3 = new String("demo");

        System.out.printf("str1: %s - hashcode: %s %n", str1, System.identityHashCode(str1));
        System.out.printf("str2: %s - hashcode: %s %n", str2, System.identityHashCode(str2));
        System.out.printf("str3: %s - hashcode: %s %n", str3, System.identityHashCode(str3));

        // Độ dài
        System.out.printf("Độ dài của chuỗi str1 là: %d%n", str1.length());
        // Trả về kí tự theo vị trí index
        System.out.printf("Kí tự tại vị trí index = 2 của str1 là: %c%n", str1.charAt(2));
        // Nối chuỗi
        str1 = str1.concat(" test");
        System.out.printf("Chuỗi sau khi đã nối là: %s%n", str1);
        System.out.printf("str1: %s - hashcode: %s%n", str1, System.identityHashCode(str1));
        // in hoa, in thường
        System.out.printf("Chuỗi in hoa: %s%n", str1.toUpperCase());
        System.out.printf("Chuỗi in thường: %s%n", str1.toLowerCase());
        // So sánh chuỗi
        System.out.printf("str2 == str3 ?? %s %n", str2 == str3 ? "Đúng" : "Sai");
        System.out.printf("str2.equals(str3) ?? %s %n", str2.equals(str3) ? "Đúng" : "Sai");

        // StringBuilder và StringBuffer
        // Khởi tạo đối tượng 3 cách
        StringBuilder sb1 = new StringBuilder(); // Không có tham số
        StringBuilder sb2 = new StringBuilder(50); // Với tham số là sức chứa
        StringBuilder sb3 = new StringBuilder("Demo StringBuilder"); // Với tham số là
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);

        // Regular Expression
        String regex = "[0-9]{3,7}"; // số từ 0 -> 9, xuất hiện từ 3 đến 7 lần
        String[] input = { "0935", "c734", "23", "12345678", "abcvb" };
        // Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < input.length; i++) {
            // Matcher m = pattern.matcher(input[i]);
            // boolean isMatch = m.matches();
            boolean isMatch = Pattern.matches(regex, input[i]);
            System.out.printf("Kết quả so khớp của chuỗi %s là %s%n", input[i], isMatch ? "Khớp" : "Không khớp");
        }

        // ===== CÁC PHƯƠNG THỨC CHUỖI (STRING METHODS) =====

        // 1. THÔNG TIN CÓ CHUỖI:
        // length(): trả về độ dài chuỗi
        // VD: "hello".length() → 5

        // charAt(int index): trả về ký tự tại vị trí index
        // VD: "hello".charAt(1) → 'e'

        // isEmpty(): kiểm tra chuỗi có rỗng không
        // VD: "".isEmpty() → true

        // 2. TÌM KIẾM:
        // indexOf(String str): trả về vị trí đầu tiên của str (-1 nếu không tìm thấy)
        // VD: "hello".indexOf("l") → 2

        // lastIndexOf(String str): trả về vị trí cuối cùng của str
        // VD: "hello".lastIndexOf("l") → 3

        // contains(CharSequence s): kiểm tra có chứa chuỗi s không
        // VD: "hello".contains("ell") → true

        // startsWith(String prefix): kiểm tra bắt đầu bằng prefix
        // VD: "hello".startsWith("he") → true

        // endsWith(String suffix): kiểm tra kết thúc bằng suffix
        // VD: "hello".endsWith("lo") → true

        // 3. CHUYỂN ĐỔI:
        // toUpperCase(): chuyển thành chữ hoa
        // VD: "hello".toUpperCase() → "HELLO"

        // toLowerCase(): chuyển thành chữ thường
        // VD: "HELLO".toLowerCase() → "hello"

        // trim(): loại bỏ khoảng trắng đầu và cuối
        // VD: " hello ".trim() → "hello"

        // substring(int beginIndex): lấy từ vị trí beginIndex đến cuối
        // VD: "hello".substring(1) → "ello"

        // substring(int beginIndex, int endIndex): lấy từ beginIndex đến endIndex-1
        // VD: "hello".substring(1, 4) → "ell"

        // 4. THAY THẾ:
        // replace(char oldChar, char newChar): thay thế tất cả oldChar bằng newChar
        // VD: "hello".replace('l', 'x') → "hexxo"

        // replace(CharSequence target, CharSequence replacement): thay thế chuỗi
        // VD: "hello".replace("ll", "xx") → "hexxo"

        // replaceAll(String regex, String replacement): thay thế bằng regex
        // VD: "hello123".replaceAll("[0-9]", "x") → "helloxxx"

        // replaceFirst(String regex, String replacement): thay thế lần đầu tiên
        // VD: "hello123".replaceFirst("[0-9]", "x") → "hellox23"

        // 5. TÁCH CHUỖI:
        // split(String regex): tách chuỗi thành mảng dựa trên regex
        // VD: "a,b,c".split(",") → ["a", "b", "c"]

        // split(String regex, int limit): tách với số lượng giới hạn
        // VD: "a,b,c".split(",", 2) → ["a", "b,c"]

        // 6. SO SÁNH:
        // equals(Object anObject): so sánh nội dung chuỗi
        // VD: "hello".equals("hello") → true

        // equalsIgnoreCase(String anotherString): so sánh không phân biệt hoa/thường
        // VD: "hello".equalsIgnoreCase("HELLO") → true

        // compareTo(String anotherString): so sánh theo thứ tự từ điển
        // VD: "a".compareTo("b") → -1 (a < b)

        // compareToIgnoreCase(String str): compareTo không phân biệt hoa/thường
        // VD: "A".compareToIgnoreCase("a") → 0

        // 7. TẠO STRING:
        // concat(String str): nối chuỗi
        // VD: "hello".concat(" world") → "hello world"

        // valueOf(Object obj): chuyển object thành chuỗi
        // VD: String.valueOf(123) → "123"

        // format(String format, Object... args): định dạng chuỗi như printf
        // VD: String.format("Hello %s", "World") → "Hello World"

        // join(CharSequence delimiter, CharSequence... elements): nối các chuỗi
        // VD: String.join(",", "a", "b", "c") → "a,b,c"

        // 8. KIỂM TRA:
        // matches(String regex): kiểm tra chuỗi có khớp regex không
        // VD: "123".matches("[0-9]+") → true

        // ===== STRINGBUILDER VÀ STRINGBUFFER METHODS =====

        // 1. APPEND (thêm vào cuối):
        // append(String str): thêm chuỗi vào cuối
        // VD: new StringBuilder("Hello").append(" World") → "Hello World"

        // append(char c): thêm ký tự vào cuối
        // VD: new StringBuilder("Hello").append('!') → "Hello!"

        // append(int i): thêm số nguyên vào cuối
        // VD: new StringBuilder("Age: ").append(25) → "Age: 25"

        // 2. INSERT (chèn vào vị trí):
        // insert(int offset, String str): chèn chuỗi tại vị trí offset
        // VD: new StringBuilder("Hello").insert(5, " World") → "Hello World"

        // insert(int offset, char c): chèn ký tự tại vị trí offset
        // VD: new StringBuilder("Hllo").insert(1, 'e') → "Hello"

        // 3. DELETE (xóa):
        // delete(int start, int end): xóa từ vị trí start đến end-1
        // VD: new StringBuilder("Hello").delete(1, 4) → "Ho"

        // deleteCharAt(int index): xóa ký tự tại vị trí index
        // VD: new StringBuilder("Hello").deleteCharAt(4) → "Hell"

        // 4. REPLACE (thay thế):
        // replace(int start, int end, String str): thay thế từ start đến end-1
        // VD: new StringBuilder("Hello").replace(1, 4, "i") → "Hio"

        // 5. REVERSE (đảo ngược):
        // reverse(): đảo ngược chuỗi
        // VD: new StringBuilder("Hello").reverse() → "olleH"

        // 6. SETCHARTAT (đặt ký tự):
        // setCharAt(int index, char ch): đặt ký tự tại vị trí index
        // VD: new StringBuilder("Hello").setCharAt(0, 'J') → "Jello"

        // 7. THÔNG TIN:
        // length(): trả về độ dài chuỗi hiện tại
        // VD: new StringBuilder("Hello").length() → 5

        // capacity(): trả về dung lượng tối đa
        // VD: new StringBuilder(50).capacity() → 50

        // charAt(int index): trả về ký tự tại vị trí index
        // VD: new StringBuilder("Hello").charAt(1) → 'e'

        // 8. SUBSTRING (lấy chuỗi con):
        // substring(int start): lấy từ vị trí start đến cuối
        // VD: new StringBuilder("Hello").substring(1) → "ello"

        // substring(int start, int end): lấy từ start đến end-1
        // VD: new StringBuilder("Hello").substring(1, 4) → "ell"

        // 9. CHUYỂN ĐỔI:
        // toString(): chuyển StringBuilder/StringBuffer thành String
        // VD: new StringBuilder("Hello").toString() → "Hello"

        // LƯU Ý:
        // - StringBuilder: không synchronized, nhanh hơn, dùng cho single thread
        // - StringBuffer: synchronized, an toàn cho multi-threaded, chậm hơn
        // - String: immutable (không thay đổi được), tạo object mới khi nối

        // ===== REGULAR EXPRESSION - GIẢI THÍCH CHI TIẾT =====

        // REGEX là dùng để kiểm tra, tìm kiếm, thay thế chuỗi theo một mẫu nhất định

        // 1. KÝ TỰ ĐƠN - Kiểm tra ký tự:
        // [abc]: Chứa a HOẶC b HOẶC c
        // VD: "cat" khớp vì có 'c' và 'a' và 't'
        // [^abc]: KHÔNG chứa a, b, c
        // VD: "dog" khớp vì không có a, b, c
        // [a-z]: Chữ cái từ a đến z (chữ thường)
        // VD: "hello" khớp
        // [A-Z]: Chữ cái từ A đến Z (chữ hoa)
        // [0-9]: Số từ 0 đến 9
        // VD: "123" khớp
        // \d: Viết tắt của [0-9] (là số)
        // \D: Không phải số
        // \w: Chữ, số, gạch dưới (_)
        // \W: Không phải chữ, số, gạch dưới
        // \s: Khoảng trắng (space, tab, newline)
        // \S: Không phải khoảng trắng
        // .: Bất kỳ ký tự nào (trừ newline)
        // VD: "a", "1", "@" đều khớp

        // 2. LƯỢNG TỪ (Quantifiers) - Kiểm tra số lần lặp:
        // a?: a xuất hiện 0 hoặc 1 lần (có hoặc không có)
        // VD: "color" hoặc "colour" đều khớp với "colou?r"
        // a*: a xuất hiện 0 hoặc nhiều lần (0, 1, 2, 3...)
        // VD: "cat", "caat", "caaat" đều khớp với "ca*t"
        // a+: a xuất hiện 1 hoặc nhiều lần (ít nhất 1 lần)
        // VD: "cat", "caat" khớp nhưng "ct" không khớp với "ca+t"
        // a{3}: a xuất hiện đúng 3 lần
        // VD: "caaat" khớp với "ca{3}t" nhưng "caat" không
        // a{3,}: a xuất hiện từ 3 lần trở lên (tối thiểu 3)
        // VD: "caaat", "caaaat" khớp với "ca{3,}t"
        // a{3,5}: a xuất hiện từ 3 đến 5 lần
        // VD: "caaat", "caaaat" khớp nhưng "caaaaat" không

        // 3. KÝ TỰ ĐẶC BIỆT - Chỉ định vị trí:
        // ^: Bắt đầu chuỗi
        // VD: "^Hello" chỉ khớp "Hello world" không khớp "Say Hello"
        // $: Kết thúc chuỗi
        // VD: "end$" chỉ khớp "the end" không khớp "end of"
        // |: HOẶC (OR) - chọn một trong các lựa chọn
        // VD: "cat|dog" khớp "cat" hoặc "dog"
        // (): Nhóm - gom các ký tự lại
        // VD: "(ab)+c" khớp "abc", "ababc", "abababc"
        // \\: Ký tự backslash đặc biệt
        // VD: "\\$100" khớp "$100"
        // \.: Ký tự dấu chấm đặc biệt (không phải "bất kỳ ký tự")
        // VD: "1\\.5" khớp "1.5"

        // 4. VÍ DỤ THỰC TẾ - Dùng để kiểm tra dữ liệu:
        // ^[A-Z].*: Bắt đầu bằng chữ hoa
        // VD: "Hello world" khớp, "hello world" không khớp
        // [a-z]+@[a-z]+\.[a-z]{2,}: Email cơ bản
        // VD: "abc@xyz.com" khớp
        // ^0\d{9}$: Số điện thoại (10 chữ số, bắt đầu bằng 0)
        // VD: "0123456789" khớp
        // ^\d{4}-\d{2}-\d{2}$: Ngày (YYYY-MM-DD)
        // VD: "2023-12-25" khớp
        // [A-Z][a-z]+: Chữ cái đầu hoa, chữ còn lại thường
        // VD: "Hello" khớp, "hello" không khớp
        // \d+(\.\d{2})?$: Số thập phân 2 chữ số (giá tiền)
        // VD: "100", "100.50" khớp, "100.5" không khớp

        // 5. KÝ TỰ ĐẶC BIỆT NÂNG CAO:
        // \b: Ranh giới từ (word boundary) - điểm giữa ký tự từ và ký tự không từ
        // VD: "\bcat\b" khớp "cat" trong "the cat sat" nhưng không khớp "catfish"

        // \B: Không phải ranh giới từ
        // VD: "\Bcat" khớp "cat" trong "catfish" nhưng không khớp "the cat"

        // (?i): Ignore case - không phân biệt hoa/thường (case insensitive)
        // VD: "(?i)hello" khớp "Hello", "HELLO", "hello"

        // (?-i): Phân biệt hoa/thường (case sensitive)
        // VD: "(?-i)Hello" chỉ khớp "Hello"

        // (?s): Dot matches all - dấu . cũng khớp newline
        // VD: "(?s)a.b" khớp "a\nb"

        // (?m): Multiline - ^ và $ khớp đầu/cuối mỗi dòng
        // VD: "(?m)^Hello" khớp "Hello" ở đầu bất kỳ dòng nào

        // (?x): Verbose - cho phép khoảng trắng và comment trong regex
        // VD: "(?x) \d{3} - \d{4} # định dạng điện thoại"

        // (?:...): Non-capturing group - nhóm nhưng không lưu kết quả
        // VD: "(?:cat|dog)" khớp "cat" hoặc "dog" nhưng không tạo nhóm

        // (...): Capturing group - nhóm và lưu kết quả
        // VD: "(cat|dog)" khớp "cat" hoặc "dog" và lưu vào group(1)

        // (?<name>...): Named capturing group - nhóm có tên
        // VD: "(?<animal>cat|dog)" có thể gọi bằng tên

        // Lookahead (?=...): Kiểm tra phía trước mà không tiêu thụ ký tự
        // VD: "\d+(?=USD)" khớp số đứng trước "USD": "100USD" → "100"

        // Negative lookahead (?!...): Kiểm tra phía trước không khớp
        // VD: "\d+(?!USD)" khớp số không đứng trước "USD": "100EUR" → "100"

        // Lookbehind (?<=...): Kiểm tra phía sau mà không tiêu thụ ký tự
        // VD: "(?<=\$)\d+" khớp số đứng sau "$": "$100" → "100"

        // Negative lookbehind (?<!...): Kiểm tra phía sau không khớp
        // VD: "(?<!\$)\d+" khớp số không đứng sau "$": "100" → "100"

        // 5. VÍ DỤ NÂNG CAO:
        // (?i)[a-z]+@[a-z]+\.[a-z]{2,}: Email (không phân biệt hoa/thường)
        // VD: "ABC@XYZ.COM" khớp

        // \b\w+@\w+\.\w+\b: Email với ranh giới từ
        // VD: "user@gmail.com" khớp, "user@gmail.com." không khớp phần ".com."

        // (?:https?|ftp)://: URL protocol (http, https, ftp)
        // VD: "https://example.com" khớp

        // \d+(?=px): Số pixel (không bao gồm "px")
        // VD: "width: 100px" → "100"

        // (?<=Price: \$)\d+(\.\d{2})?: Giá tiền sau "Price: $"
        // VD: "Price: $100.50" → "100.50"
    }
}
