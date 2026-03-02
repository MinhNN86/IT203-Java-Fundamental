package Session15.LyThuyet.Queue;

public class DemoQueueLinkedList {
    private Node front;
    private Node rear;

    public DemoQueueLinkedList(){
        front = rear = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue(){
        if(front == null){
            System.out.println("Queue is empty!");
            return -1; // Return -1 to indicate empty queue
        }
        int data = front.data;
        front = front.next;
        if(front == null){
            rear = null; // If queue becomes empty, set rear to null
        }
        return data;
    }

    public int peek(){
        if(front == null){
            System.out.println("Queue is empty!");
            return -1; // Return -1 to indicate empty queue
        }
        return front.data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int size(){
        int count = 0;
        Node current = front;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        DemoQueueLinkedList queue = new DemoQueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Queue size: " + queue.size()); // 3

        System.out.println("Dequeued element: " + queue.dequeue()); // 10
        System.out.println("Front element after dequeue: " + queue.peek()); // 20
    }
}
