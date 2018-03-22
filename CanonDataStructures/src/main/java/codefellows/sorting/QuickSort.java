package codefellows.sorting;

import codefellows.datastructures.LinkedList;
import codefellows.datastructures.List;

public class QuickSort {
    public static void sort(List<Integer> list) {
        quicksort(list, 0, list.size());
    }

    public static void quicksort(List<Integer> list, int start, int end) {
        if (start == end) {
            return;
        }

        System.out.println(list.toString());
        int pivot = partition(list, start, end);
        System.out.println(list.toString() + " Pivot: " + pivot);
        quicksort(list, start, pivot);
        quicksort(list, pivot + 1, end);
    }

    // Picks a pivot always as the left-most index.
    // moves all values less than pivot value left of pivot.
    // moves all values greater than pivot value right of pivot.
    // returns the index of where the pivot value ends up in the array.
    public static int partition(List<Integer> list, int start, int end) {
        // This partition implementation comes from this website
        // where someone has put together an excellent explanation:
        // http://me.dt.in.th/page/Quicksort/

        // swap a random index with the leftmost element to protect
        // against worse-case reverse-sorted arrays
        int tempLeft = list.get(start);
        int randomIndex = start + (int) Math.floor(Math.random() * (double) (end - start));
        System.out.println("Choose index: " + randomIndex + " value: " + list.get(randomIndex));
        list.set(start, list.get(randomIndex));
        list.set(randomIndex, tempLeft);


        // First, assume that the pivot is the leftmost element.
        int pivot = start;
        int leftmostOpen = pivot + 1;

        int lastClosed = 0;
        boolean hasLastClosed = false;

        // Flip all the other cards down.
        // Then, open each card from left to right.
        for (int i = pivot + 1; i < end; i++) {
            int val = list.get(i);
            // If you find a card that is less than the pivot:
            if (val < list.get(pivot)) {
                // Swap that card with the card that was first opened (the leftmost open card),
                // and close that leftmost card.
                int tempOpen = list.get(leftmostOpen);
                list.set(leftmostOpen, val);
                list.set(i, tempOpen);

                // Also take note of the last closed card.
                hasLastClosed = true;
                lastClosed = leftmostOpen;

                leftmostOpen++;
            } else {
                //  Otherwise, continue opening the next card.
            }
        }

        // Swap the last closed card with the pivot (if any).
        // Open all cards… You will see that the array is already partitioned!
        if (hasLastClosed) {
            int tempPivot = list.get(pivot);
            list.set(pivot, list.get(lastClosed));
            list.set(lastClosed, tempPivot);
            pivot = lastClosed;
        }

        // return the location of where the pivot ended up
        return pivot;
    }
}
