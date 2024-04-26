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

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
}