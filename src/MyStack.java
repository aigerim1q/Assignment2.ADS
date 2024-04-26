public class MyStack<T extends Comparable<T>> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }


    public T push(T element) {
        list.add(element);
        return element;
    }


    public T peek() {
        if (list.exists(list)) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }


    public T pop() {
        if (list.exists(list)) {
            throw new IllegalStateException("Stack is empty");
        }
        T removingElement = peek();
        list.removeLast();
        return removingElement;
    }
}