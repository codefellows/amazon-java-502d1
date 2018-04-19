public class CoordValue<E> {
    int row;
    int col;
    E value;

    public CoordValue(int row, int col, E val) {
        this.row = row;
        this.col = col;
        this.value = val;
    }

    public String toString() {
        return "(" + this.row + "," + this.col + ") " + this.value;
    }
}
