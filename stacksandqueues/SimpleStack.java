// package stacksandqueues;

// import linkedlists.LinkedListNode;

class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    LinkedListNode<T> append(LinkedListNode<T> next) {
        if (this.next != null)
            this.next.append(next);
        else
            this.next = next;
        return this;
    }

    LinkedListNode<T> appendData(T data) {
        return append(new LinkedListNode<T>(data));
    }

    public String toString() {
        String nextStr = "";
        if (this.next != null)
           nextStr = "->" + this.next.toString();
        return "" + this.data.toString() + nextStr;
    }
}

public class SimpleStack<T> implements Stack<T> {
    private LinkedListNode<T> top;

    public boolean isEmpty() {
        return this.top == null;
    }

    public T peek() throws Exception {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public T pop() throws Exception {
        T item = this.peek();
        top = top.next;
        return item;
    }

    public void push(T item) {
        LinkedListNode<T> t = new LinkedListNode<T>(item);
        t.next = top;
        top = t;
    }

    public String toString() {
        LinkedListNode<T> curr = this.top;
        String str = curr.data.toString();
        while (curr.next != null) {
            str += "\n" + curr.next.data.toString();
            curr = curr.next;
        }
        return str;
    }
}