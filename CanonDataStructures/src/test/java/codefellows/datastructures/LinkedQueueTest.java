package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest {
    Queue<String> emptyQueue;
    Queue<String> qq;

    @Before
    public void setup() {
        emptyQueue = new LinkedQueue<>();
        qq = new LinkedQueue<>();
        qq.enqueue("Monday");
        qq.enqueue("Tuesday");
        qq.enqueue("Wednesday");
        qq.enqueue("Thursday");
        qq.enqueue("Friday");
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, emptyQueue.size());
        assertEquals(5, qq.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(qq.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        emptyQueue.enqueue("New new new!");
        assertEquals("New new new!", emptyQueue.peek());
        assertEquals(1, emptyQueue.size());
        assertEquals(false, emptyQueue.isEmpty());
        assertEquals("New new new!", emptyQueue.dequeue());


        qq.enqueue("New new new!");
        assertEquals("Monday", qq.peek());
        assertEquals(6, qq.size());
        assertEquals(false, qq.isEmpty());
        assertEquals("Monday", qq.dequeue());
    }

    @Test
    public void dequeue() throws Exception {
        assertEquals(null, emptyQueue.dequeue());
        assertEquals(0, emptyQueue.size());
        assertEquals(true, emptyQueue.isEmpty());

        assertEquals("Monday", qq.dequeue());
        assertEquals(4, qq.size());
        assertEquals(false, qq.isEmpty());
        assertEquals("Tuesday", qq.peek());
        qq.enqueue("Monday");
    }

    @Test
    public void peek() throws Exception {
        assertEquals(null, emptyQueue.peek());
        assertEquals("Monday", qq.peek());
    }

}