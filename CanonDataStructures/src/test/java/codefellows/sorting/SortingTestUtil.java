package codefellows.sorting;

import codefellows.datastructures.List;

public class SortingTestUtil {
    public static boolean isSorted(List<Integer> list) {
        if (list.size() <= 1) {
            return true;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
