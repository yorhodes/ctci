// package stacksandqueues;

public class SetOfStacks<T> implements Stack<T> {
    public static void main(String[] args) throws Exception {
        SetOfStacks<Character> robustStack = new SetOfStacks(5);
        robustStack.push('A');
        robustStack.push('B');
        robustStack.push('C');
        robustStack.push('D');
        robustStack.push('E');
        robustStack.push('F');
        robustStack.push('G');

        System.out.println("Set of stacks...\n" + robustStack);
        System.out.println("pop(): " + robustStack.pop());
        System.out.println("pop(): " + robustStack.pop());
        System.out.println("pop(): " + robustStack.pop());
        System.out.println("pop(): " + robustStack.pop());
        System.out.println("Set of stacks...\n" + robustStack);
    }

    private static class EmptyStackException extends Exception {};
    private static class FullStackException extends Exception {};
    private static class FixedSizeStack<T> implements Stack<T> {
        private Object[] buffer;
        private int index;

        public FixedSizeStack(int capacity) {
            this.buffer = new Object[capacity];
            this.index = -1;
        }

        public boolean isEmpty() {
            return index == -1;
        }

        public boolean isFull() {
            return index == (buffer.length - 1);
        }

        public T peek() throws Exception {
            if (isEmpty()) throw new EmptyStackException();
            return (T) this.buffer[index];
        }

        public void push(T item) throws Exception {
            if (isFull()) throw new FullStackException();
            index += 1;
            mod(index, item);
        }

        private void mod(int height, T newData) {
            this.buffer[height] = newData;
        }

        public T pop() throws Exception {
            T temp = this.peek();
            index -= 1;
            return temp;
        }

        public String toString() {
            return java.util.Arrays.toString(this.buffer);
        }
    }

    private SimpleStack<FixedSizeStack<T>> set;
    private int stackCapacity;

    public SetOfStacks(int stackCapacity) {
        this.set = new SimpleStack<FixedSizeStack<T>>();
        this.stackCapacity = stackCapacity;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public T peek() throws Exception {
        handleLowerBoundary();
        if (set.isEmpty()) throw new EmptyStackException();
        return set.peek().peek();
    }

    public void push(T item) throws Exception {
        if (this.isEmpty() || set.peek().isFull())
            set.push(new FixedSizeStack<T>(this.stackCapacity));
        set.peek().push(item);
    }

    public T pop() throws Exception {
        handleLowerBoundary();
        if (set.isEmpty()) throw new EmptyStackException();
        return set.peek().pop();
    }

    private void handleLowerBoundary() throws Exception {
        if (set.peek().isEmpty())
            set.pop();
    }

    public String toString() {
        return set.toString();
    }
}

