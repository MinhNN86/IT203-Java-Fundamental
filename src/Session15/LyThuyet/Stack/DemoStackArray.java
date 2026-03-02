package Session15.LyThuyet.Stack;

public class DemoStackArray<T> {
    private T[] list;
    private int top = -1;

    public DemoStackArray(int size){
        list = (T[]) new Object[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T item){
        if(top == list.length - 1){
            System.out.println("Stack is full!");
            return;
        }
        list[++top] = item;
    }

     public T pop(){
        if(top == -1){
            System.out.println("Stack is empty!");
            return null;
        }
        return list[top--];
     }

     public T peek(){
        if(top == -1){
            System.out.println("Stack is empty!");
            return null;
        }
        return list[top];
     }

    public static void main(String[] args) {
        DemoStackArray<Integer> stack = new DemoStackArray<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Top element after pop: " + stack.peek()); // 20
    }
}
