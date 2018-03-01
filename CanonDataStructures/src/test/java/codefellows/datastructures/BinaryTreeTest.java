package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree<Integer> mEmptyTree;
    BinaryTree<Integer> mTree;

    @Before
    public void setUp() {
        mEmptyTree = new BinaryTree<>();

        mTree = new BinaryTree<>();
        mTree.add(4);
        mTree.add(1);
        mTree.add(2);
        mTree.add(12);
        mTree.add(8);
        mTree.add(25);
    }

    @Test
    public void add() throws Exception {
        assertEquals(0, mEmptyTree.size());
        assertEquals(6, mTree.size());
    }

    @Test
    public void contains() throws Exception {
        assertFalse(mEmptyTree.contains(0));
        assertFalse(mEmptyTree.contains(1));
        assertFalse(mEmptyTree.contains(12));
        assertFalse(mEmptyTree.contains(25));

        assertTrue(mTree.contains(1));
        assertTrue(mTree.contains(2));
        assertTrue(mTree.contains(4));
        assertTrue(mTree.contains(8));
        assertTrue(mTree.contains(12));
        assertTrue(mTree.contains(25));

        assertFalse(mTree.contains(0));
        assertFalse(mTree.contains(122));
    }

}