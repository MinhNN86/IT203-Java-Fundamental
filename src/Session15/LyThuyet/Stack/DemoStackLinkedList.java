package Session15.LyThuyet.Stack;

import java.util.LinkedList;

public class DemoStackLinkedList<T> {
    private LinkedList<T> stack;

    public DemoStackLinkedList(){
        stack = new LinkedList<>();
    }

    public void push(T item){
        stack.push(item);
    }

    public T pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.pop();
    }

    public T peek(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }

    public static void main(String[] args) {
        DemoStackLinkedList<Integer> stack = new DemoStackLinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Stack size: " + stack.size()); // 3

        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Top element after pop: " + stack.peek()); // 20
    }
}
