package Session13;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Double> temperatures = new ArrayList<>();
        temperatures.add(36.5);
        temperatures.add(40.2);
        temperatures.add(37.0);
        temperatures.add(12.5);
        temperatures.add(39.8);
        temperatures.add(99.9);
        temperatures.add(36.8);

        System.out.println("Danh sách ban đầu: " + temperatures);

        // 2. Dùng Iterator để xóa giá trị không hợp lệ
        Iterator<Double> iterato = temperatures.iterator();
        while (iterato.hasNext()) {
            Double temp = iterato.next();
            if (temp < 35.0 || temp > 42.0) {
                iterato.remove();
            }
        }
        System.out.println("Danh sách sau khi lọc: " + temperatures);

        // 3. Tính nhiệt độ trung bình
        double sum = 0.0;
        for (Double temp : temperatures) {
            sum += temp;
        }
        double average = sum / temperatures.size();
        System.out.println("Nhiệt độ trung bình: " + average);
    }
}
