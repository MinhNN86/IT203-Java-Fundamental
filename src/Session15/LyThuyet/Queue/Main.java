package Session15.LyThuyet.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Thêm phần tử vào Queue
        queue.add("A");
        queue.add("B");
        queue.add("C");

        // Xem phần tử ở đầu Queue
        System.out.println("Phần tử ở đầu Queue: " + queue.peek());
        // Lấy và xóa phần tử khỏi Queue
        System.out.println("Lấy phần tử ra: " + queue.poll());
        // Kiểm tra Queue có rỗng không
        System.out.println("Queue có rỗng không? " + queue.isEmpty());
    }
}
