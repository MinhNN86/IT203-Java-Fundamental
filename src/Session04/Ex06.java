package Session04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex06 {
    public static void main(String[] args) {
        String review = "Cuốn sách này thật ngu ngốc và rất tệ. "
                + "Nội dung quá chán, đọc mà thấy ghét vô cùng. "
                + "Tôi sẽ không bao giờ đọc lại cuốn sách tệ hại này nữa.";

        String[] blackList = { "ngu", "tệ", "ghét" };

        String regex = "(?i)\\b(" + String.join("|", blackList) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(review);

        StringBuffer filteredReview = new StringBuffer();

        while (matcher.find()) {
            String word = matcher.group();
            String stars = "*".repeat(word.length());
            matcher.appendReplacement(filteredReview, stars);
        }
        matcher.appendTail(filteredReview);

        String result = filteredReview.toString();

        if (result.length() > 200) {
            int cutIndex = result.lastIndexOf(" ", 200);
            if (cutIndex == -1) {
                cutIndex = 200;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(result.substring(0, cutIndex));
            sb.append("...");
            result = sb.toString();
        }

        System.out.println("Đánh giá sau khi lọc:");
        System.out.println(result);
    }
}
