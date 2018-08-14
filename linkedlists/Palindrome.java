package linkedlists;

public class Palindrome {
    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<Character>('A')
            .appendData('B')
            .appendData('C')
            .appendData('D')
            .appendData('C')
            .appendData('B')
            .appendData('A');

        System.out.println(head);
        System.out.println("isPalindrome...");
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(LinkedListNode<Character> head) {
        LinkedListNode<Character> p1 = head;
        LinkedListNode<Character> p2 = head;

        LinkedListNode<Character> str1 = new LinkedListNode('#');
        while (p2 != null && p2.next != null) {
            str1.appendData(p1.data);
            p2 = p2.next.next;
            p1 = p1.next;
        }

        if (p2 != null) // ODD
            p1 = p1.next;


        LinkedListNode<Character> str2 = new LinkedListNode(p1.data);
        while (p1.next != null) {
            LinkedListNode<Character> temp = new LinkedListNode(p1.next.data);
            temp.append(str2);
            str2 = temp;
            p1 = p1.next;
        }

        return str1.next.toString().equals(str2.toString());
    }
}
