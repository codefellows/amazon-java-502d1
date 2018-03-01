package codefellows.datastructures;

public class BinaryTree<E extends Comparable<E>> {
    public class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this(value, (TreeNode<E>) null, (TreeNode<E>) null);
        }

        public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public int size() {
        if (this.root == null) {
            return 0;
        }
        return this.size(this.root);
    }

    private int size(TreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + this.size(node.left) + this.size(node.right);
        }
    }

    public void add(E value) {
        if (this.root == null) {
            this.root = new TreeNode<E>(value);
        } else {
            add(value, this.root);
        }
    }

    private void add(E value, TreeNode<E> node) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new TreeNode<E>(value);
            } else {
                add(value, node.left);
            }
        } else if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new TreeNode<E>(value);
            } else {
                add(value, node.right);
            }
        }
    }

    public boolean contains(E value) {
        if (this.root == null) {
            return false;
        }
        return this.contains(value, this.root);
    }

    private boolean contains(E value, TreeNode<E> current) {
        if (current == null) {
            return false;
        } else if (current.value == value) {
            return true;
        } else if (value.compareTo(current.value) < 0) {
            return contains(value, current.left);
        } else {
            return contains(value, current.right);
        }
    }
}
