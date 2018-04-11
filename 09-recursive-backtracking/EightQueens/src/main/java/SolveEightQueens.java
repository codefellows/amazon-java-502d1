public class SolveEightQueens {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        System.out.println(board);

        boolean isSolved = explore(board);
        if (isSolved) {
            System.out.println("Solved");
        } else {
            System.out.println("Unsolved");
        }
        System.out.println(board);
    }

    public static boolean explore(ChessBoard board) {
        if (board.numQueens() == ChessBoard.SIZE) {
            return true;
        }

        for (int row = 0; row < ChessBoard.SIZE; row++) {
            for (int col = 0; col < ChessBoard.SIZE; col++) {
                boolean isSet = board.setIfValid(row, col);
                if (isSet) {
                    System.out.println(board);
                    if (explore(board)) {
                        return true;
                    }
                    board.unset(row, col);
                }
            }
        }

        return false;
    }
}
