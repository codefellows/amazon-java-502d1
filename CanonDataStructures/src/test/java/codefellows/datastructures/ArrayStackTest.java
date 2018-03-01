package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
    Stack mStack;
    Stack emptyStack;

    @Before
    public void fillStack() {
        emptyStack = new ArrayStack();
        mStack = new ArrayStack();
        mStack.push(5);
        mStack.push(4);
        mStack.push(3);
        mStack.push(2);
    }

    @Test
    public void size() throws Exception {
        assertEquals(4, mStack.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(emptyStack.isEmpty());
        assertFalse(mStack.isEmpty());
    }

    @Test
    public void push() throws Exception {
        emptyStack.push(99);
        assertEquals(1, emptyStack.size());
        assertEquals(false, emptyStack.isEmpty());

        mStack.push(99);
        assertEquals(5, mStack.size());
        assertEquals(false, mStack.isEmpty());

        // reset the state of both stacks
        emptyStack.pop();
        mStack.pop();
    }

    @Test
    public void pop() throws Exception {
        assertEquals(null, emptyStack.pop());
        assertEquals(0, emptyStack.size());
        assertEquals(true, emptyStack.isEmpty());

        assertEquals(2, mStack.pop());
        assertEquals(3, mStack.size());
        assertEquals(false, mStack.isEmpty());

        // reset the state of the stack
        mStack.push(2);
    }

    @Test
    public void peek() throws Exception {
        assertEquals(null, emptyStack.peek());
        assertEquals(0, emptyStack.size());
        assertEquals(true, emptyStack.isEmpty());

        assertEquals(2, mStack.peek());
        assertEquals(4, mStack.size());
        assertEquals(false, mStack.isEmpty());
    }

}