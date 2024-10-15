public class StackADT_2a<Item> {
    private LinkedDequeue<Item> dequeue;

    public StackADT_2a() {
        dequeue = new LinkedDequeue<>();
    }

    public void push(Item item) {
        dequeue.pushBack(item);
    }

    public Item pop() {
        if (isEmpty()) throw new IllegalStateException("Stack underflow");
        return dequeue.popBack();
    }

    public boolean isEmpty() {
        return dequeue.isEmpty();
    }

    public int size() {
        return dequeue.size();
    }

    public static void main(String[] args) {
        StackADT_2a<Integer> stack = new StackADT_2a<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size: " + stack.size()); // Output: 3
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
    }
}
