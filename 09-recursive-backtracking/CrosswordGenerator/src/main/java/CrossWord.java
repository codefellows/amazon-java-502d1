import java.util.HashSet;
import java.util.Set;

public class CrossWord {
    private Character[][] grid;
    public Set<Clue> clues;

    public CrossWord(Character[][] grid) {
        this.grid = grid;
        this.clues = this.findStarts();
    }

    public char getCharAt(int row, int col) {
        if (row < 0 || col < 0 ||
            row >= this.grid.length ||
            col >= this.grid.length) {
            return '#';
        }
        return this.grid[row][col];
    }

    public boolean isAcrossStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row, col + 1) == '#') {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row, col - 1) != '#') {
            return false;
        }
        return true;
    }

    public boolean isDownStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row + 1, col) == '#') {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row - 1, col) != '#') {
            return false;
        }
        return true;
    }

    public Set<Clue> findStarts() {
        int clueNumber = 1;
        Set<Clue> clues = new HashSet<>();

        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid.length; col++) {
                boolean isAcross = isAcrossStart(row, col);
                boolean isDown = isDownStart(row, col);
                if (isAcross || isDown) {
                    clues.add(new Clue(row, col, clueNumber, isAcross, isDown));
                    clueNumber++;
                }
            }
        }
        return clues;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid.length; col++) {
                builder.append(this.grid[row][col]);
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
