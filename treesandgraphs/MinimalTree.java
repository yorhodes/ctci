import java.util.Arrays;

class Node<T> {
    public T key;
    public Node[] children;

    public Node(T key) {
        this.key = key;
    }

    public String toString() {
        String str = this.key.toString();
        if (this.children != null) {
            str += "[";
            for (Node child : this.children)
                str += child.toString() + ',';
            str += "]";
        }
        return str;
    }
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] a = new int[]{-3 , 2, 3, 4, 7, 34, 35};
        Node root = minHeightTree(a);
        System.out.println("array:" + Arrays.toString(a));
        System.out.println("minHeightTree(array)...");
        System.out.println(root);
    }

    public static Node<Integer> minHeightTree(int[] sortedUnique) {
        return minHeightTreeHelper(sortedUnique, 0, sortedUnique.length); 
    }

    // span is left inclusive, right exclusive
    private static Node<Integer> minHeightTreeHelper(int[] a, int botSpan, int topSpan) {
        int spanSize = topSpan - botSpan;
        if (spanSize == 1) {
            return new Node(a[botSpan]);
        } else if (spanSize == 2) {
            Node parent = new Node(a[botSpan + 1]);
            Node child = new Node(a[botSpan]);
            parent.children = new Node[]{child};
            return parent;
        } else {
            int midSpan = (botSpan + topSpan) / 2;
            Node root = new Node(a[midSpan]);
            Node leftChild = minHeightTreeHelper(a, botSpan, midSpan);
            Node rightChild = minHeightTreeHelper(a, midSpan + 1, topSpan);
            root.children = new Node[]{leftChild, rightChild};
            return root;
        }
    }
}