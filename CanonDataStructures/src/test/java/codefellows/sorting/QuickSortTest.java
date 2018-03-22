package codefellows.sorting;

import codefellows.datastructures.ArrayList;
import codefellows.datastructures.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void sortKnownValues() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.append(3);
        list.append(1);
        list.append(4);
        list.append(1);
        list.append(5);
        list.append(9);
        list.append(2);
        list.append(6);
        list.append(5);
        list.append(3);

        QuickSort.sort(list);
        assertTrue(SortingTestUtil.isSorted(list));
    }

    @Test
    public void sortEmptyList() {
        List<Integer> list = new ArrayList<>();

        QuickSort.sort(list);
        assertTrue(SortingTestUtil.isSorted(list));
    }

    @Test
    public void sortSingleItemList() {
        List<Integer> list = new ArrayList<>();
        list.append(42);

        QuickSort.sort(list);
        assertTrue(SortingTestUtil.isSorted(list));
    }

}