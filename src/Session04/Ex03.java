package Session04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex03 {

    // Phương thức dùng StringBuilder
    public static String generateReportWithStringBuilder(String[] transactions) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- BÁO CÁO MUỢN SÁCH ---\n");
        sb.append("Ngày tạo: ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

        for (String transaction : transactions) {
            sb.append("Giao dịch: ").append(transaction).append("\n");
        }

        return sb.toString();
    }

    // Phương thức dùng phép cộng chuỗi (+)
    public static String generateReportWithStringConcatenation(String[] transactions) {
        String report = "--- BÁO CÁO MUỢN SÁCH ---\n";
        report += "Ngày tạo: " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";

        for (String transaction : transactions) {
            report += "Giao dịch: " + transaction + "\n";
        }

        return report;
    }

    // Phương thức tính thời gian thực thi
    public static long measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime(); // ① Ghi lại thời gian bắt đầu
        task.run(); // ② Chạy công việc
        long endTime = System.nanoTime(); // ③ Ghi lại thời gian kết thúc
        return (endTime - startTime) / 1_000_000; // ④ Tính thời gian chênh lệch
    }

    public static void main(String[] args) {
        // Danh sách giao dịch
        String[] transactions = {
                "BK001-20/01",
                "BK005-21/01",
                "BK099-22/01"
        };

        // Tạo báo cáo với StringBuilder
        String reportSB = generateReportWithStringBuilder(transactions);
        System.out.println(reportSB);

        // So sánh thời gian thực thi
        System.out.println("=== SO SÁNH HIỆU NĂNG ===\n");

        // Test StringBuilder (10000 lần)
        long sbTime = measureExecutionTime(() -> {
            for (int i = 0; i < 10000; i++) {
                generateReportWithStringBuilder(transactions);
            }
        });

        // Test String Concatenation (10000 lần)
        long stringTime = measureExecutionTime(() -> {
            for (int i = 0; i < 10000; i++) {
                generateReportWithStringConcatenation(transactions);
            }
        });

        System.out.printf("Số thời gian thực thi dùng StringBuilder: %d ms%n", sbTime);
        System.out.printf("Số thời gian thực thi dùng String: %d ms%n", stringTime);
        System.out.printf("StringBuilder nhanh hơn %.2f lần%n", (double) stringTime / sbTime);
    }
}
