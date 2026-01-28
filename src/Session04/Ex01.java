package Session04;

public class Ex01 {
    public static String chuanHoaKHoangTrang(String str) {
        return str.trim().replaceAll("\\s+", " ");
    }

    public static String vietHoaChuCaiDau(String str) {
        String[] words = str.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String title = "      lập TRÌNH java    CƠ bản        ";
        String author = "nguyễn văn a";

        title = chuanHoaKHoangTrang(title).toUpperCase();
        author = vietHoaChuCaiDau(chuanHoaKHoangTrang(author));

        System.out.printf("%n[%s] - Tác giả: %s%n", title, author);
    }
}
