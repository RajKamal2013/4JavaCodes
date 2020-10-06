package LeetCode.tree;

public class TreeNode<T extends Number & Comparable <T>> {
    private T data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.right = this.left = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T add(T one, T two) {

        if (one.getClass() == Integer.class) {
            // With auto-boxing / unboxing
            return (T) (Integer) ((Integer) one + (Integer) two);
        }
        if (one.getClass() == Long.class) {
            // Without auto-boxing / unboxing
            return (T) Long.valueOf(((Long) one).longValue() +
                    ((Long) two).longValue());
        }
        return null;
    }
}






