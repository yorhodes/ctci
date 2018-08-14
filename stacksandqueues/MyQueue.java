public class MyQueue<T> implements Stack<T> { 
    private SimpleStack<T> stack1 = new SimpleStack();
    private SimpleStack<T> stack2 = new SimpleStack();

    private boolean lastOpPush = false;

    public static void main(String[] args) throws Exception {
        MyQueue<Character> q = new MyQueue();
        q.push('A');
        q.push('B');
        q.push('C');
        q.push('D');
        System.out.println("FIFO queue...\n" + q.stack2);
        System.out.println("pop(): " + q.pop());
        System.out.println("pop(): " + q.pop());
        q.push('E');
        System.out.println("push(E)...");
        q.push('F');
        System.out.println("push(F)...");
        System.out.println("pop(): " + q.pop());
        System.out.println("pop(): " + q.pop());
        System.out.println("pop(): " + q.pop());
        System.out.println("pop(): " + q.pop());
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public T peek() throws Exception {
        if (this.lastOpPush)
            shiftFromTo(stack2, stack1);
        return stack1.peek();
    }

    public T pop() throws Exception {
        T temp = this.peek();
        this.lastOpPush = false;
        return stack1.pop();
    }

    public void push(T item) throws Exception {
        if (!this.lastOpPush)
            shiftFromTo(stack1, stack2);
        stack2.push(item);
        this.lastOpPush = true;
    }

    public static void shiftFromTo(Stack src, Stack target) throws Exception {
        while (!src.isEmpty())
            target.push(src.pop());
    }
}