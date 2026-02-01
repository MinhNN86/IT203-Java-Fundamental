package Session07;

public class Ex05 {

    static class Config {
        public static final int MAX_SCORE = 100;
        public static final int MIN_SCORE = 0;
    }

    public static void main(String[] args) {
        int score = 85;
        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ: " + score);
        } else {
            System.out.println("Điểm không hợp lệ: " + score);
        }
    }

}
