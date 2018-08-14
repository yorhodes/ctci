package stacksandqueues;

public class StackMin<T extends Comparable<T>> {
     public static void main(String[] args) {
        StackMin<Integer> intStack = new StackMin<Integer>();
        intStack.push(5);
        intStack.push(3);
        intStack.push(4);
        intStack.push(2);
        System.out.println("LIFO stack...");
        System.out.println(intStack);
        for (int i = 0; i < 4; i++) {
            System.out.println("min(): " + intStack.min());
            System.out.println("pop(): " + intStack.pop());
        }
    }

    private static class MinStackNode<T> {
        private T data;
        private MinStackNode<T> next;
        private MinStackNode<T> prevMin;

        public MinStackNode(T data) {
            this.data = data;
        }
    }

    private MinStackNode<T> top;
    private MinStackNode<T> min;

    public boolean isEmpty() {
        return this.top == null;
    }

    public T peek() {
        if (this.isEmpty()) System.err.println("Empty stack exception");
        return top.data;
    }

    public T pop() {
        T item = peek();
        if (top == min)
            min = min.prevMin;
        top = top.next;
        return item;
    }

    public void push(T item) {
        MinStackNode<T> t = new MinStackNode<T>(item);
        t.next = top;
        if (this.min != null) {
            if (t.data.compareTo(this.min.data) <= 0) {
                t.prevMin = min;
                this.min = t;
            }
        } else 
            this.min = t;
        this.top = t;
    }

    public T min() {
        return min.data;
    }

    public String toString() {
        MinStackNode<T> curr = this.top;
        String str = curr.data.toString();
        while (curr.next != null) {
            str += "\n" + curr.next.data.toString();
            curr = curr.next;
        }
        return str;
    }
}