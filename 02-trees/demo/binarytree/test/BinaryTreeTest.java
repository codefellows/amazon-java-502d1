import apple.laf.JRSUIUtils;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree empty = new BinaryTree();
    BinaryTree single = new BinaryTree();
    BinaryTree many = new BinaryTree();
    BinaryTree dupes = new BinaryTree();

    @org.junit.Before
    public void setUp() throws Exception {
        TreeNode n1 = new TreeNode(1);
        single.root = n1;

        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n12 = new TreeNode(12);

        n4.left = n3;
        n4.right = n8;
        n8.left = n7;
        n8.right = n2;
        n7.right = n12;

        many.root = n4;

        TreeNode d3 = new TreeNode(3);
        TreeNode d12 = new TreeNode(12);
        TreeNode d13 = new TreeNode(13);
        TreeNode d14 = new TreeNode(14);
        TreeNode dd3 = new TreeNode(3);
        d3.left = d12;
        d12.left = d13;
        d13.left = d14;
        d14.right = dd3;
        dupes.root = d3;
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        assertTrue(empty.isEmpty());
        assertFalse(single.isEmpty());
        assertFalse(many.isEmpty());
    }

    @org.junit.Test
    public void size() throws Exception {
        assertEquals(0, empty.size());
        assertEquals(1, single.size());
        assertEquals(6, many.size());
    }

    @org.junit.Test
    public void height() throws Exception {
        assertEquals(0, empty.height());
        assertEquals(1, single.height());
        assertEquals(4, many.height());
    }

    @org.junit.Test
    public void string() throws Exception {
        assertEquals("", empty.toString());
        assertEquals("1", single.toString());
        assertEquals("3 4 7 12 8 2", many.toString());
    }

    @org.junit.Test
    public void breadthFirst() throws Exception {
        assertEquals("", empty.breadthFirstTraversal());
        assertEquals("1", single.breadthFirstTraversal());
        assertEquals("4 3 8 7 2 12", many.breadthFirstTraversal());
        assertEquals("3 12 13 14 3", dupes.breadthFirstTraversal());
    }

    @org.junit.Test
    public void dupes() throws Exception {
        assertEquals(false, empty.containsDuplicates());
        assertEquals(false, single.containsDuplicates());
        assertEquals(false, many.containsDuplicates());
        assertEquals(true, dupes.containsDuplicates());
    }
}