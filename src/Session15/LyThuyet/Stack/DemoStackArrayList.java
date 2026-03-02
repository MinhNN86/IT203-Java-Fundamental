package Session15.LyThuyet.Stack;

import java.util.ArrayList;
import java.util.List;

public class DemoStackArrayList<T> {
    private List<T> list;

    public DemoStackArrayList(){
        list = new ArrayList<>();
    }

    public void push(T item){
        list.add(item);
    }

    public T pop(){
        if(list.isEmpty()){
            System.out.println("Stack is empty!");
            return null;
        }
        // return list.remove(list.size() - 1);
        return list.removeLast();
    }

    public T peek(){
        if(list.isEmpty()){
            System.out.println("Stack is empty!");
            return null;
        }
        // return list.get(list.size() - 1);
        return list.getLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        DemoStackArrayList<Integer> stack = new DemoStackArrayList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Stack size: " + stack.size()); // 3

        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Top element after pop: " + stack.peek()); // 20
    }
}
