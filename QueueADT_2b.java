public class QueueADT_2b<Item> {
    private LinkedDequeue<Item> dequeue;

    public QueueADT_2b() {
        dequeue = new LinkedDequeue<>();
    }

    public void enqueue(Item item) {
        dequeue.pushBack(item);
    }

    public Item dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow");
        return dequeue.popFront();
    }

    public boolean isEmpty() {
        return dequeue.isEmpty();
    }

    public int size() {
        return dequeue.size();
    }

    public static void main(String[] args) {
        QueueADT_2b<Integer> queue = new QueueADT_2b<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Size: " + queue.size()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
    }
}
