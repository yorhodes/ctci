// package stacksandqueues;

public interface Stack<T> {
    public boolean isEmpty();
    public T peek() throws Exception;
    public T pop() throws Exception;
    public void push(T item) throws Exception;
} 