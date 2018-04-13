import java.util.HashSet;
import java.util.Set;

public class CrossWord {
    private static final char FILLED = '#';

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
            return FILLED;
        }
        return this.grid[row][col];
    }

    public Clue getClueAt(int row, int col) {
        for (Clue clue : this.clues) {
            if (clue.getRow() == row && clue.getCol() == col) {
                return clue;
            }
        }
        return null;
    }

    public boolean isAcrossStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row, col + 1) == FILLED) {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row, col - 1) != FILLED) {
            return false;
        }
        return true;
    }

    public boolean isDownStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row + 1, col) == FILLED) {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row - 1, col) != FILLED) {
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
                    Clue clue = new Clue(row, col, clueNumber, isAcross, isDown);
                    clues.add(clue);

                    if (isAcross) {
                        int lengthAcross = lengthAcross(row, col);
                        clue.setLengthAcross(lengthAcross);
                    }
                    if (isDown) {
                        int lengthDown = lengthDown(row, col);
                        clue.setLengthDown(lengthDown);
                    }

                    clueNumber++;
                }
            }
        }
        return clues;
    }

    public int lengthAcross(int row, int col) {
        int length = 0;
        char cc = this.getCharAt(row, col);
        while (cc != FILLED) {
            length++;
            col++;
            cc = this.getCharAt(row, col);
        }

        return length;
    }

    public int lengthDown(int row, int col) {
        int length = 0;

        char cc= this.getCharAt(row, col);
        while (cc != FILLED) {
            length++;
            row++;
            cc = this.getCharAt(row, col);
        }

        return length;
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

    public boolean isSolved() {
        return false;
    }

    public void setAcross(Clue clue, String word) {

    }

    public void unsetAcross(Clue clue, String word) {

    }

    public void setDown(Clue clue, String word) {

    }

    public void unsetDown(Clue clue, String word) {

    }
}
