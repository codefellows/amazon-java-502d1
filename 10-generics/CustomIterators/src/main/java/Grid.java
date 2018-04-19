import java.util.Iterator;

public class Grid implements Iterable<Coord> {
    private int rows;
    private int cols;

    private Object[][] grid;

    // build a square grid.
    public Grid(int size) {
        this(size, size);
    }

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Object[rows][cols];
    }

    public Object get(Coord coord) {
        return this.get(coord.row, coord.col);
    }

    public Object get(int row, int col) {
        return this.grid[row][col];
    }

    public void set(Coord coord, Object val) {
        this.set(coord.row, coord.col, val);
    }

    public void set(int row, int col, Object val) {
        this.grid[row][col] = val;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                builder.append(this.get(row, col));
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public Iterator<Coord> iterator() {
        int maxRows = this.rows;
        int maxCols = this.cols;

        Iterator<Coord> iter = new Iterator<Coord>() {
            private int row = 0;
            private int col = 0;

            @Override
            public boolean hasNext() {
                return row <= maxRows;
            }

            @Override
            public Coord next() {
                Coord coord = new Coord(row, col);
                col++;
                if (col % maxCols == 0) {
                    col = 0;
                    row++;
                }
                return coord;
            }
        };
        return iter;
    }
}
