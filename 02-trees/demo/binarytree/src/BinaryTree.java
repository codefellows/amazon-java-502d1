import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

    public String toString() {
        return this.toString(this.root, new StringBuilder()).toString().trim();
    }

    private StringBuilder toString(TreeNode node, StringBuilder builder) {
        if (node != null) {
            this.toString(node.left, builder);
            builder.append(node.data + " ");
            this.toString(node.right, builder);
        }
        return builder;
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

    public boolean containsDuplicates() {
        Set<Integer> seen = new HashSet<>();
        return this.containsDuplicates(this.root, seen);
    }

    private boolean containsDuplicates(TreeNode node, Set<Integer> seen) {
        if (node == null) {
            return false;
        } else if (seen.contains(node.data)) {
            return true;
        }
        seen.add(node.data);
        return containsDuplicates(node.left, seen) || containsDuplicates(node.right, seen);
    }

    public String breadthFirstTraversal() {
        if (this.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(this.root);

        while (!qq.isEmpty()) {
            TreeNode node = qq.remove();
            builder.append(node.data + " ");
            if (node.left != null) {
                qq.add(node.left);
            }
            if (node.right != null) {
                qq.add(node.right);
            }
        }
        return builder.toString().trim();
    }
}
























