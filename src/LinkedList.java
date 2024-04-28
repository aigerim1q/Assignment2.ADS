/**
 * @brief A generic doubly linked list implementation.
 */
public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<E> {
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E element, MyNode<E> prev, MyNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    /**
     * @brief Constructs an empty linked list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @brief Retrieves a node at a given index.
     * @param index The index of the node.
     * @return The node at the specified index.
     */
    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    /**
     * @brief Disconnects a node from the list.
     * @param node The node to unlink from the list.
     */
    private void unlink(MyNode<T> node) {
        MyNode<T> prev = node.prev;
        MyNode<T> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }


        node.element = null;
        node.next = null;
        node.prev = null;

        size--;
    }

    /**
     * @brief Checks if the linked list is empty.
     * @return true if the list has no elements, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @brief Adds an item to the end of the list.
     * @param item The item to add.
     */
    public void add(T item) {
        addLast(item);
    }

    /**
     * @brief Sets the value of the item at a specific index.
     * @param index The index to set the item at.
     * @param item The new item.
     */
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    /**
     * @brief Inserts an item at a specified index.
     * @param index The index to insert the item at.
     * @param item The item to insert.
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            MyNode<T> succ = getNode(index);
            MyNode<T> pred = succ.prev;
            MyNode<T> newNode = new MyNode<>(item, pred, succ);

            pred.next = newNode;
            succ.prev = newNode;

            size++;
        }
    }

    /**
     * @brief Inserts an item at the beginning of the list.
     * @param item The item to insert.
     */
    public void addFirst(T item) {
        if (isEmpty()) {
            head = tail = new MyNode<>(item, null, null);
        } else {
            MyNode<T> newNode = new MyNode<>(item, null, head);
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    /**
     * @brief Inserts an item at the end of the list.
     * @param item The item to insert.
     */
    public void addLast(T item) {
        if (isEmpty()) {
            head = tail = new MyNode<>(item, null, null);
        } else {
            MyNode<T> newNode = new MyNode<>(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * @brief Retrieves the item at a specific index.
     * @param index The index to get the item from.
     * @return The item at the specified index.
     */
    public T get(int index) {
        return getNode(index).element;
    }

    /**
     * @brief Gets the first item in the list.
     * @return The first item.
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.element;
    }

    /**
     * @brief Gets the last item in the list.
     * @return The last item.
     */
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.element;
    }

    /**
     * @brief Removes an item from a specific index.
     * @param index The index to remove the item from.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode<T> nodeToRemove = getNode(index);
        unlink(nodeToRemove);
    }

    /**
     * @brief Removes the first item in the list.
     */
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        unlink(head);
    }

    /**
     * @brief Removes the last item in the list.
     */
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        unlink(tail);
    }

    /**
     * @brief Checks if an object exists in the list.
     * @param object The object to search for.
     * @return true if the object is found, otherwise false.
     */
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * @brief Converts the list to an array.
     * @return An array containing all elements in the list.
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            array[index++] = current.element;
        }
        return array;
    }

    /**
     * @brief Clears all elements from the list.
     */
    public void clear() {
        while (head != null) {
            MyNode<T> next = head.next;
            head.prev = null;
            head.next = null;
            head = next;
        }
        tail = null;
        size = 0;
    }

    /**
     * @brief Returns the current size of the list.
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }
}
