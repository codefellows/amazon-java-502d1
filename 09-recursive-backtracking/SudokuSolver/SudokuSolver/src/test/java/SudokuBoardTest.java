import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuBoardTest {
    int[][] SOLUTION = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},


        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},

        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public SudokuBoard getSolvedBoard() {
        SudokuBoard board = new SudokuBoard();
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                int val = SOLUTION[row][col];
                board.set(row, col, val);
            }
        }
        return board;
    }

    @Test
    public void isEmptyBoardComplete() throws Exception {
        // an empty board is valid, but it's not considered complete.
        SudokuBoard board = new SudokuBoard();
        assertFalse(board.isBoardComplete());
    }

    @Test
    public void isEmptyBoardValid() throws Exception {
        // an empty board is considered valid because it doesn't break
        // and constraints. It's simply not finished yet.
        SudokuBoard board = new SudokuBoard();
        assertFalse(board.isBoardComplete());
    }

    @Test
    public void isFullBoardComplete() {
        SudokuBoard board = getSolvedBoard();
        assertTrue(board.isBoardComplete());
    }

    @Test
    public void isValidationCorrect() {
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                SudokuBoard board = getSolvedBoard();
                int val = board.get(row, col);
                if (val == 1) {
                    board.set(row, col, 2);
                } else {
                    board.set(row, col, 1);
                }

                assertFalse(board.isBoardValid());
                assertFalse(board.isBoardComplete());
            }
        }

    }
}