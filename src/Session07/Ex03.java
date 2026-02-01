package Session07;

public class Ex03 {
    static class ScoreUtils {

        public static boolean isPass(double score) {
            return score >= 5.0;
        }

        public static double caculateAverage(double[] scores) {
            double sum = 0;
            for (double score : scores) {
                sum += score;
            }
            return sum / scores.length;
        }
    }

    public static void main(String[] args) {
        double score = 6.5;
        double[] scores = { 7.0, 8.5, 6.0, 9.0 };

        boolean passed = ScoreUtils.isPass(score);
        double average = ScoreUtils.caculateAverage(scores);

        System.out.println("Score: " + score);
        System.out.println("Passed: " + passed);
        System.out.println("Average score: " + average);
    }
}
