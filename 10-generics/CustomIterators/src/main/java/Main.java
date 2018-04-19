public class Main {
    public static void main(String[] args) {
        int size = 3;
        Grid letters = new Grid(size);
        Grid numbers = new Grid(size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                letters.set(row, col, "a");
                numbers.set(row, col, row * col);
            }
        }

        System.out.println("Main");
        System.out.println(letters.toString());
        System.out.println(numbers.toString());

        String a = (String) letters.get(0, 0);
        System.out.println("a:" + a);

        for (Coord coord : letters) {
            System.out.println("iter: " + coord + ' ' + letters.get(coord));
        }
    }
}
