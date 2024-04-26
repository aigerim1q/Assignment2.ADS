public class Main {
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(8);

        System.out.println("Top element: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }



    }
}