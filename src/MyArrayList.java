import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private static final int default_capacity = 10;
    private Object[] elements;
    private int sizee;

    public MyArrayList() {
        this.elements = new Object[default_capacity];
        this.sizee = 0;
    }
}
