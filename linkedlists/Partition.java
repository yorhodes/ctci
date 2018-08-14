public class Partition {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(3)
            .appendData(5)
            .appendData(8)
            .appendData(5)
            .appendData(10)
            .appendData(2)
            .appendData(1);

        System.out.println(head);
        System.out.println("partition(5)...");
        partition2(head, 5);
        // System.out.println(head);
    }

    private static void partition(LinkedListNode<Integer> head, int p) {
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            if (curr.data >= p) {
                LinkedListNode<Integer> swap = curr.next;
                while (swap != null && swap.data >= p)
                    swap = swap.next;
                if (swap != null) {
                    int temp = curr.data;
                    curr.data = swap.data;
                    swap.data = temp;
                } else
                    break;
            }
            curr = curr.next;
        }
    }

    private static void partition2(LinkedListNode<Integer> head, int p) {
        LinkedListNode<Integer> newList = new LinkedListNode<Integer>(head.data);

        LinkedListNode<Integer> curr = head.next;
        while (curr != null) {
            if (curr.data < p) {
                LinkedListNode<Integer> temp = new LinkedListNode<Integer>(curr.data);
                temp.append(newList);
                newList = temp;
            } else {
                newList.appendData(curr.data);
            }
            curr = curr.next;
        }

        System.out.println(newList);
    }
}