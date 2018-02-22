public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
       this.root = null;
    }

    // returns true if the tree has no nodes
    public boolean isEmpty() {
        return this.root == null;
    }

    // size() returns the total number of nodes in the tree
    public int size() {
        return this.size(this.root);
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + this.size(node.left) + this.size(node.right);
    }

    // height() return the maximum height of the tree
    public int height() {
        return this.height(this.root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
























