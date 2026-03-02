package Session15.LyThuyet.Stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Xem phần tử ở đầu Stack
        System.out.println("Phần tử ở đầu Stack: " + stack.peek());

        // Lấy và xóa phần tử khỏi Stack
        System.out.println("Lấy phần tử ra: " + stack.pop());

        // Kiểm tra Stack có rỗng không
        System.out.println("Stack có rỗng không? " + stack.isEmpty());
    }
}
