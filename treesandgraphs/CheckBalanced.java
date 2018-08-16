public class CheckBalanced {
    public static void main(String[] args) {
        BinaryTreeNode child = new BinaryTreeNode("B"); 
        BinaryTreeNode subChild = new BinaryTreeNode("D");
        // subChild.left = new BinaryTreeNode("E");
        child.left = subChild;
        child.right = new BinaryTreeNode("E");

        BinaryTreeNode root = new BinaryTreeNode("A");
        root.left = child;
        root.right = new BinaryTreeNode("C");

        System.out.println(root);
        System.out.println(checkBalanced(root));
    }

    public static boolean checkBalanced(BinaryTreeNode root) {
        return heightBalance(root) != -1;
    }

    private static int heightBalance(BinaryTreeNode tree) {
        if (tree == null) 
            return 0;
        int hl = heightBalance(tree.left);
        int hr = heightBalance(tree.right);
        if (hl == -1 || hr == -1 || Math.abs(hr - hl) > 1)
            return -1;
        else
            return 1 + Math.max(hl, hr);
    }
}