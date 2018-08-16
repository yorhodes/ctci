public class BinaryTreeNode<T> {
    public T key;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T key) {
        this.key = key;
    }

    public String toString() {
        // return key.toString();
        String l = (left != null) ? "[" + left + "]" : "";
        String r = (right != null) ? "[" + right + "]": "";
        return l+key.toString()+r;
    }
}