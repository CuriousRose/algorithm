package think.generic;

public class Stack<E> {
    E[] elements;

    public Stack() {
        elements = (E[]) new Object[20];
    }

    public static void main(String[] args) {
        Stack<Stack> stack = new Stack<>();
        System.out.println(stack);
    }
}
