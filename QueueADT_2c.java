import java.util.Stack;

public class QueueADT_2c<Item> {
    private Stack<Item> stack1; // For enqueue operation
    private Stack<Item> stack2; // For dequeue operation

    public QueueADT_2c() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(Item item) {
        stack1.push(item);
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueADT_2c<Integer> queue = new QueueADT_2c<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Size: " + queue.size()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
    }
}
