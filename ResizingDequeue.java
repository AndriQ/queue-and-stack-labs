public class ResizingDequeue<Item> {
    private Item[] queue;
    private int numberOfElements; 
    private int head;
    private int tail;

    public ResizingDequeue() {
        queue = (Item[]) new Object[2];
        numberOfElements = 0;
        head = 0;
        tail = 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < numberOfElements; i++) {
            copy[i] = queue[(head + i) % queue.length];
        }
        queue = copy;
        head = 0;
        tail = numberOfElements;
    }

    public void pushBack(Item item) {
        if (numberOfElements == queue.length) {
            resize(2 * queue.length);
        }
        queue[tail] = item;
        tail = (tail + 1) % queue.length;
        numberOfElements++;
    }

    public void pushFront(Item item) {
        if (numberOfElements == queue.length) {
            resize(2 * queue.length);
        }
        head = (head - 1 + queue.length) % queue.length;
        queue[head] = item;
        numberOfElements++;
    }

    public Item popBack() {
        if (isEmpty()) throw new IllegalStateException("Dequeue underflow");
        Item item = queue[(tail - 1 + queue.length) % queue.length];
        tail = (tail - 1 + queue.length) % queue.length;
        numberOfElements--;
        if (numberOfElements > 0 && numberOfElements == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item popFront() {
        if (isEmpty()) throw new IllegalStateException("Dequeue underflow");
        Item item = queue[head];
        head = (head + 1) % queue.length;
        numberOfElements--;
        if (numberOfElements > 0 && numberOfElements == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public int size() {
        return numberOfElements;
    }

    // Example usage:
    public static void main(String[] args) {
        ResizingDequeue<Integer> dequeue = new ResizingDequeue<>();
        dequeue.pushBack(1);
        dequeue.pushFront(2);
        dequeue.pushBack(3);
        System.out.println("Size: " + dequeue.size()); // Output: 3
        System.out.println(dequeue.popFront()); // Output: 2
        System.out.println(dequeue.popBack()); // Output: 3
    }
}
