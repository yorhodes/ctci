package linkedlists;

public class KthToLast {
    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<Character>('A')
            .appendData('B')
            .appendData('C')
            .appendData('D')
            .appendData('E')
            .appendData('F')
            .appendData('G');

        System.out.println(head);
        System.out.println("(k=3)tolast...");
        System.out.println(kthtolast(head, 3).data);
    }

    private static LinkedListNode kthtolast(LinkedListNode head, int k) {
        LinkedListNode i = head;
        LinkedListNode iMinusK = head;

        for (int j = 0; j < k && i != null; j++)
            i = i.next;
        
        while (i != null) {
            i = i.next;
            iMinusK = iMinusK.next;
        }

        return iMinusK;
    }
}
