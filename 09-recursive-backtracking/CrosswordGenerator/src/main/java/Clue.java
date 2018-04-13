public class Clue {
    private int row;
    private int col;
    private int number;
    private boolean isAcross;
    private boolean isDown;

    public Clue(int row, int col, int number, boolean isAcross, boolean isDown) {
        this.row = row;
        this.col = col;
        this.number = number;
        this.isAcross = isAcross;
        this.isDown = isDown;
    }

    @Override
    public boolean equals(Object oo) {
        if (!(oo instanceof Clue)) {
            return false;
        }
        Clue other = (Clue) oo;
        return this.row == other.row &&
                this.col == other.col &&
                this.number == other.number &&
                this.isAcross == other.isAcross &&
                this.isDown == other.isDown;
    }

    @Override
    public String toString() {
        String format = "#%d (%d,%d) up: %b down: %b";
        return String.format(format, this.number, this.row, this.col, this.isAcross, this.isDown);
    }

    // Override the hashcode to use the toString representation
    // so Set.equals() will compare Sets of Clues properly.
    // If this is not Overrode then it uses Object memory-location equality.
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
