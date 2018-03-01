package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class ArrayListTest {
    List<Integer> list;
    List<Integer> emptyList;

    @Before
    public void setUp() {
        emptyList = new ArrayList<>();

        list = new ArrayList<>();
        list.append(1);
        list.append(2);
        list.append(3);
    }

    @Test
    public void size() {
        assertEquals(0, emptyList.size());
        assertEquals(3, list.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(true, emptyList.isEmpty());
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void get() {
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }


    @Test
    public void append() {
        list.append(4);
        assertEquals(4, (int) list.get(3));
        assertEquals(4, list.size());
    }

    @Test
    public void insert() {
        list.insert(0, 99);
        assertEquals(99, (int) list.get(0));
        assertEquals(4, list.size());
    }

    @Test
    public void removeValue() {
        list.removeAtIndex(3);
        list.removeAtIndex(1);
        list.removeAtIndex(2);
        assertEquals(0, list.size());
    }

    @Test
    public void removeAtIndex() {
        list.removeAtIndex(0);
        list.removeAtIndex(0);
        list.removeAtIndex(0);

        assertEquals(0, list.size());
    }

    @Test
    public void indexOf() {
        assertEquals(0, (int) list.indexOf(1));
        assertEquals(1, (int) list.indexOf(2));
        assertEquals(2, (int) list.indexOf(3));
    }

    @Test
    public void expand() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.append(i);
        }

        assertEquals(0, (int) list.get(0));
        assertEquals(99, (int) list.get(99));
        assertEquals(100, list.size());
    }
}