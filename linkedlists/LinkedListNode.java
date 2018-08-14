package linkedlists;

public class LinkedListNode<T> {
    public LinkedListNode<T> next = null;
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