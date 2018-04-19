public class Coord {
    public int row;
    public int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }
}
