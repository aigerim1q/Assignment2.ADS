import java.util.Arrays;


/**
 * @brief Custom implementation of an ArrayList with dynamic resizing.
 * The MyArrayList class provides a custom implementation of a list with dynamic
 * resizing. It supports generic types, allowing you to add, remove, and access
 * elements by index
 */
public class MyArrayList<T> implements MyList<T> {
    private static final int default_capacity = 10; // Default initial capacity
    private Object[] elements; // Underlying array holding list elements
    private int size; // Current size of the list

    /**
     * Default constructor that initializes the list with a default capacity.
     */
    public MyArrayList() {
        this.elements = new Object[default_capacity];
        this.size = 0;
    }

    /**
     * Ensures that the underlying array has at least the specified minimum capacity.
     * @param minCapacity The minimum required capacity.
     */
    private void increaseCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2); // Double the capacity or more
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size); // Copy existing elements to new array
            elements = newArray; // Replace the old array with the new one
        }
    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise.
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an item to the end of the list
     * @param item The item to add.
     */
    public void add(T item) {
        increaseCapacity(size + 1); // Ensure sufficient capacity
        elements[size++] = item; // Add the item and increment the size
    }

    /**
     * Sets the value at a specific index
     * @param index The index to set the item at.
     * @param item The item to set.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = item;
    }

    /**
     * Inserts an item at a specific index
     * @param index The index to insert the item at
     * @param item The item to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        increaseCapacity(size + 1); // Ensure sufficient capacity
        System.arraycopy(elements, index, elements, index + 1, size - index); // Shift elements to make room
        elements[index] = item; // Insert the item
        size++; // Increment size after adding
    }

    /**
     * Inserts an item at the beginning of the list
     * @param item The item to insert
     */
    public void addFirst(T item) {
        add(0, item); // Use the add method to insert at the beginning
    }

    /**
     * Inserts an item at the end of the list
     * @param item The item to insert
     */
    public void addLast(T item) {
        add(size, item); // Use the add method to insert at the end
    }

    /**
     * Retrieves the item at a specific index.
     * @param index The index to retrieve the item from
     * @return The item at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index]; // Return the item at the specified index
    }

    /**
     * Retrieves the first item in the list.
     * @return The first item in the list.
     * @throws IllegalStateException if the list is empty.
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return (T) elements[0]; // Return the first item in the list
    }

    /**
     * Retrieves the last item in the list.
     * @return The last item in the list.
     * @throws IllegalStateException if the list is empty.
     */
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return (T) elements[size - 1]; // Return the last item in the list
    }

    /**
     * Removes the item at a specific index.
     * @param index The index to remove the item from.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1); // Shift elements left to fill the gap
        elements[--size] = null; // Decrement size and set the last element to null
    }

    /**
     * Removes the first item in the list.
     * @throws IllegalStateException if the list is empty.
     */
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        remove(0); // Use the remove method to remove the first item
    }

    /**
     * Removes the last item in the list
     * @throws IllegalStateException if the list is empty.
     */
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        remove(size - 1); // Use the remove method to remove the last item
    }

    /**
     * Sorts the list
     * @throws UnsupportedOperationException because sorting is not supported.
     */
    public void sort() {
        throw new UnsupportedOperationException("Sorting is not supported");
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }
}