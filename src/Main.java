/**
 * @brief The entry point for the application. This class demonstrates the usage of custom stack, queue, and heap structures.
 */
public class Main {
    /**
     * @brief The main method where the execution of the program begins.
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>(); // Create a stack for Integer elements


        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(8);


        System.out.println("Top element: " + stack.peek());


        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }


        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(8);


        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        MinHeap<Integer> heap = new MinHeap<>();


        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);


        while (!heap.isEmpty()) {
            System.out.println("Extracted min element: " + heap.extractMin());
        }
    }
}
