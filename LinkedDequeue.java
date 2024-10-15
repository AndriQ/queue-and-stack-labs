public class LinkedDequeue<Item> {
    private Node<Item> nil; 
    private int numberOfElements; 

    private static class Node<Item> {
        private Item key;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public LinkedDequeue() {
        nil = new Node<>();
        nil.prev = nil;
        nil.next = nil;
        numberOfElements = 0;
    }

    public void pushBack(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.key = item;
        newNode.next = nil;
        newNode.prev = nil.prev;

        nil.prev.next = newNode;
        nil.prev = newNode;

        numberOfElements++;
    }

    public void pushFront(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.key = item;
        newNode.next = nil.next;
        newNode.prev = nil;

        nil.next.prev = newNode;
        nil.next = newNode;

        numberOfElements++;
    }

    public Item popBack() {
        if (isEmpty()) throw new IllegalStateException("Dequeue underflow");

        Node<Item> lastNode = nil.prev;
        Item item = lastNode.key;

        lastNode.prev.next = nil;
        nil.prev = lastNode.prev;

        numberOfElements--;

        return item;
    }

    public Item popFront() {
        if (isEmpty()) throw new IllegalStateException("Dequeue underflow");

        Node<Item> firstNode = nil.next;
        Item item = firstNode.key;

        firstNode.next.prev = nil;
        nil.next = firstNode.next;
        numberOfElements--;
        return item;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public int size() {
        return numberOfElements;
    }

    public static void main(String[] args) {
        LinkedDequeue<Integer> dequeue = new LinkedDequeue<>();
        dequeue.pushBack(1);
        dequeue.pushFront(2);
        dequeue.pushBack(3);
        System.out.println("Size: " + dequeue.size()); // Output: 3
        System.out.println(dequeue.popFront()); // Output: 2
        System.out.println(dequeue.popBack()); // Output: 3
    }
}
