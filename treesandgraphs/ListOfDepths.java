import java.util.Arrays;
import java.util.ArrayList;

public class ListOfDepths {
    private static class LinkedListNode<T> {
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
    
    public static void main(String[] args) {
        BinaryTreeNode<String> child1 = new BinaryTreeNode("A1");
        child1.left = new BinaryTreeNode("A0");
        child1.right = new BinaryTreeNode("B0");

        BinaryTreeNode<String> child2 = new BinaryTreeNode("B1");
        child2.left = new BinaryTreeNode("C0");
        child2.right = new BinaryTreeNode("D0");

        BinaryTreeNode<String> root = new BinaryTreeNode("A2");
        root.left = child1;
        root.right = child2;

        System.out.println(convertBinaryTree(root));
    }

    public static ArrayList<LinkedListNode<BinaryTreeNode>> convertBinaryTree(BinaryTreeNode root) {
        ArrayList<LinkedListNode<BinaryTreeNode>> lists = new ArrayList();
        createDepthLists(root, lists, 0);
        return lists;
    }

    private static void createDepthLists(
        BinaryTreeNode node, 
        ArrayList<LinkedListNode<BinaryTreeNode>> lists, 
        int depth
    ) {
        if (node == null) return;

        LinkedListNode list = null;
        if (lists.size() == depth) {
            list = new LinkedListNode<BinaryTreeNode>(node);
            lists.add(list);
        } else {
            list = lists.get(depth);
            list.appendData(node);
        }
        createDepthLists(node.left, lists, depth + 1);
        createDepthLists(node.right, lists, depth + 1);
    }
}