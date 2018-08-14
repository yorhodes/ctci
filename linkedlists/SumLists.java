package linkedlists;

public class SumLists {
    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(7)
            .appendData(1)
            .appendData(6);

        LinkedListNode<Integer> n2 = new LinkedListNode<Integer>(5)
            .appendData(9)
            .appendData(2)
            .appendData(3);
        
        System.out.println("a=" + n1);
        System.out.println("b=" + n2);
        System.out.println("c=sumlists(a, b)...");
        System.out.println("c+" + sumlists(n1, n2));
    }

    private static LinkedListNode<Integer> sumlists(
        LinkedListNode<Integer> num1, 
        LinkedListNode<Integer> num2
    ) {
        int offset = 0;
        int num1val;
        int num2val;
        LinkedListNode<Integer> result = new LinkedListNode<Integer>(-999);
        while (offset > 0 || num1 != null || num2 != null) {
            if (num1 != null) {
                num1val = num1.data;
                num1 = num1.next;
            } else
                num1val = 0;

            if (num2 != null) {
                num2val = num2.data;
                num2 = num2.next;
            } else
                num2val = 0;
            
            int raw = num1val + num2val + offset;
            offset = raw / 10;
            int digit = raw % 10;
            result.appendData(digit);
        }

        return result.next;
    }
}
