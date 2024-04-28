/**
 * @brief A generic queue implementation.
 */
public class MyQueue<T> {
    private MyList<T> list;

    /**
     * @brief Constructor that initializes the queue with a new linked list.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * @brief Checks if the queue is empty.
     * @return true if the queue has no elements, otherwise false.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * @brief Returns the front element of the queue without removing it.
     * @return The front element of the queue.
     * */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(list.size() - 1);
    }

    /**
     * @brief Enqueues (inserts) an element at the back of the queue.
     * @param element The element to add to the queue.
     * @return The added element.
     */
    public T enqueue(T element) {
        list.addFirst(element);
        return element;
    }

    /**
     * @brief Dequeues (removes) the front element from the queue.
     * @return The removed element.
     * @throws IllegalStateException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removingElement = peek();
        list.removeLast();
        return removingElement;
    }
}
