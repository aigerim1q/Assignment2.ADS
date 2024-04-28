/**
 * @brief A generic min-heap implementation.
 */
public class MinHeap<T extends Comparable<T>> {
    private MyList<T> elements;

    /**
     * @brief Constructor that initializes an empty heap.
     */
    public MinHeap() {
        elements = new MyArrayList<>();
    }

    /**
     * @brief Checks if the heap is empty.
     * @return true if the heap has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    /**
     * @brief Inserts an element into the heap, maintaining the min-heap property.
     * @param element The element to insert into the heap.
     */
    public void insert(T element) {
        elements.add(element);
        heapifyUp(elements.size() - 1);
    }

    /**
     * @brief Extracts and removes the minimum element from the heap, maintaining the min-heap property.
     * @return The minimum element in the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = elements.get(0);
        T lastElement = elements.getLast();
        elements.removeLast();

        if (!isEmpty()) {
            elements.set(0, lastElement);
            heapifyDown(0);
        }

        return min;
    }

    /**
     * @brief Restores the heap property by moving the element at the given index up the heap.
     * @param index The index to start heapifying from.
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate parent index
            if (elements.get(index).compareTo(elements.get(parentIndex)) >= 0) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * @brief Restores the heap property by moving the element at the given index down the heap.
     * @param index The index to start heapifying from.
     */
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < elements.size() && elements.get(leftChild).compareTo(elements.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < elements.size() && elements.get(rightChild).compareTo(elements.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * @brief Swaps the elements at the given indices.
     * @param i Index of the first element.
     * @param j Index of the second element.
     */
    private void swap(int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
