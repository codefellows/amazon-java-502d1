import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        Grid<Character> letters = new Grid<>(size);
        Grid<Integer> numbers = new Grid<>(size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                letters.set(row, col, 'a');
                numbers.set(row, col, row * col);
            }
        }

        for (CoordValue val : numbers) {
            System.out.println(val);
        }
        System.out.println();
    }
}
