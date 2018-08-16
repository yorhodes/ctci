import java.util.Arrays;

class Node<T> {
    public T key;
    public Node[] children;
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] a = new int[]{-3 , 2, 3, 4, 7, 34, 35};
        BinaryTreeNode<Integer> root = minHeightTree(a);
        System.out.println("array:" + Arrays.toString(a));
        System.out.println("minHeightTree(array)...");
        System.out.println(root);
    }

    public static BinaryTreeNode<Integer> minHeightTree(int[] sortedUnique) {
        return minHeightTreeHelper(sortedUnique, 0, sortedUnique.length-1); 
    }

    // span is left inclusive, right exclusive
    private static BinaryTreeNode<Integer> minHeightTreeHelper(int[] a, int botSpan, int topSpan) {
        if (topSpan < botSpan) {
            return null;
        } else {
            int midSpan = (botSpan + topSpan) / 2;
            BinaryTreeNode root = new BinaryTreeNode(a[midSpan]);
            root.left = minHeightTreeHelper(a, botSpan, midSpan - 1);
            root.right = minHeightTreeHelper(a, midSpan + 1, topSpan);
            return root;
        }
    }
}