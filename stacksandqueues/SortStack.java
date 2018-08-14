public class SortStack {
    public static void main(String[] args) throws Exception {
        SimpleStack<Integer> intStack = new SimpleStack<Integer>();
        intStack.push(5);
        intStack.push(3);
        intStack.push(4);
        intStack.push(2);

        System.out.println("Unsorted int stack...\n" + intStack);
        System.out.println("Sorted int stack...\n" + sort(intStack));
    }

    public static <T extends Comparable<T>> Stack<T> sort(Stack<T> stack) 
        throws Exception
    {
        MinStack<T> newStack = new MinStack<T>();
        MinStack.shiftFromTo(stack, newStack);
        return newStack;
    }
}

class MinStack<T extends Comparable<T>> implements Stack<T> { 
    private SimpleStack<T> buffer = new SimpleStack();
    private SimpleStack<T> stack = new SimpleStack();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T peek() throws Exception {
        return stack.peek();
    }

    public T pop() throws Exception {
        return stack.pop();
    }

    public void push(T item) throws Exception {
        while (
            !this.stack.isEmpty() && 
            item.compareTo(this.stack.peek()) > 0
        ) {
            buffer.push(stack.pop());
        }
        stack.push(item);
        shiftFromTo(buffer, stack);
    }

    public static void shiftFromTo(Stack src, Stack dest) throws Exception {
        while (!src.isEmpty())
            dest.push(src.pop());
    }

    public String toString() {
        return stack.toString();
    }
}