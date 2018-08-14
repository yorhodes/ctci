package linkedlists;

public class DelMidNode {
    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<Character>('A')
            .appendData('B')
            .appendData('C')
            .appendData('D')
            .appendData('E')
            .appendData('F')
            .appendData('G');

        System.out.println(head);
        System.out.println("delmidnode(C)...");
        delmidnode(head.next.next);
        System.out.println(head);
    }

    private static void delmidnode(LinkedListNode<Character> mid) {
        if (mid != null && mid.next != null) {
            mid.data = mid.next.data;
            mid.next = mid.next.next;
        } else {
            System.err.println("Provided node may not be the last node");
        }
    }
}
