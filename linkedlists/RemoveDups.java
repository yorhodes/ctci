package linkedlists;

import java.util.HashSet;

public class RemoveDups {
    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<Character>('A')
            .appendData('C')
            .appendData('A')
            .appendData('B')
            .appendData('D')
            .appendData('B')
            .appendData('D')
            .appendData('B')
            .appendData('D');

        System.out.println(head);
        System.out.println("removedups...");
        removedups(head, (int) 'z' - (int) 'A');
        System.out.println(head);
    }

    private static void removedups(LinkedListNode<Character> n, int alphaSize) {
        HashSet<Integer> occurrences = new HashSet<>(alphaSize);
        occurrences.add(n.data);

        LinkedListNode<Character> currNode = n;
        while (currNode.next != null) {
            if (occurrences.contains(currNode.next.data))
                currNode.next = currNode.next.next;
            else {
                occurrences.add(currNode.next.data);
                currNode = currNode.next;
            }
        }
    }
}
