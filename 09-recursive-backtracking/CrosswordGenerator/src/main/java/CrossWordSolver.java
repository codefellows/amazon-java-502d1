public class CrossWordSolver {
    public static void main(String[] args) {

    }

    public boolean explore(CrossWord puzzle) {
        if (puzzle.isSolved()) {
            return true;
        }
        return false;
    }
}
