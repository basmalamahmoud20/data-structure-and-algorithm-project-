public class Queue {

    private int[] queueArray;
    private int front;
    private int rear;
    //    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
//        size = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = data;
//        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        int data = queueArray[front];
        front = (front + 1) % capacity;
//        size--;
        return data;
    }

    public boolean isEmpty() {
//        return size == 0;
        return (rear - front + 1 + capacity) % capacity == 0;
    }

    public boolean isFull() {
//        return size == capacity;
        return (rear + 2) % capacity == front;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
//        int count = count();
//        int current = front;
//        while (count > 0) {
//            System.out.print(queueArray[current] + " -> ");
//            current = (current + 1) % capacity;
//            count--;
//        }
//        System.out.println("null");
        int current = front;
        while ((current + capacity) % capacity != rear) {
            System.out.print(queueArray[current] + " -> ");
            current = (current + 1) % capacity;
        }
        System.out.println(queueArray[current]);
    }

    public int count() {
        return (rear - front + 1 + capacity) % capacity;
    }
}
