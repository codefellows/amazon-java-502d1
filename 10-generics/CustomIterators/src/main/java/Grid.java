import java.util.Iterator;

public class Grid<E> implements Iterable<CoordValue<E>> {
    private int rows;
    private int cols;

    private E[][] grid;

    // build a square grid.
    public Grid(int size) {
        this(size, size);
    }

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = (E[][]) new Object[rows][cols];
    }

    public E get(Coord coord) {
        return this.get(coord.row, coord.col);
    }

    public E get(int row, int col) {
        return this.grid[row][col];
    }

    public void set(Coord coord, E val) {
        this.set(coord.row, coord.col, val);
    }

    public void set(int row, int col, E val) {
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
    public Iterator<CoordValue<E>> iterator() {
        Iterator<CoordValue<E>> iter = new Iterator() {
            int row = 0;
            int col = 0;
            int maxRows = rows;
            int maxCols = cols;

            @Override
            public boolean hasNext() {
                return row < maxRows;
            }

            @Override
            public CoordValue<E> next() {
                E val = grid[row][col];
                CoordValue result = new CoordValue(row, col, val);
                col++;
                if (col % maxCols == 0) {
                    col = 0;
                    row++;
                }
                return result;
            }
        };
        return iter;
    }

    public Iterator<Integer> getRows() {
        return new Iterator<Integer>() {
            int row = 0;

            @Override
            public boolean hasNext() {
                return row < rows;
            }

            @Override
            public Integer next() {
                return row++;
            }
        };
    }

    public Iterator<Integer> getCols() {
        return new Iterator<Integer>() {
            int col = 0;

            @Override
            public boolean hasNext() {
                return col < cols;
            }

            @Override
            public Integer next() {
                return col++;
            }
        };
    }

}
