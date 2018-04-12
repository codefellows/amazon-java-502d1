import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CrossWordTest {
    @Test
    public void testIsAcrossClue() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        assertEquals(true,  puzzle.isAcrossStart(0, 0));
        assertEquals(false, puzzle.isAcrossStart(0, 1));
        assertEquals(false, puzzle.isAcrossStart(0, 2));
        assertEquals(false, puzzle.isAcrossStart(0, 3));
        assertEquals(false, puzzle.isAcrossStart(0, 4));

        assertEquals(false, puzzle.isAcrossStart(1, 0));
        assertEquals(false, puzzle.isAcrossStart(1, 2));
        assertEquals(false, puzzle.isAcrossStart(1, 4));

        assertEquals(true,  puzzle.isAcrossStart(2, 0));
        assertEquals(false, puzzle.isAcrossStart(2, 1));
        assertEquals(false, puzzle.isAcrossStart(2, 2));
        assertEquals(false, puzzle.isAcrossStart(2, 3));
        assertEquals(false, puzzle.isAcrossStart(2, 4));

        assertEquals(false, puzzle.isAcrossStart(3, 0));
        assertEquals(false, puzzle.isAcrossStart(3, 2));
        assertEquals(false, puzzle.isAcrossStart(3, 4));

        assertEquals(true,  puzzle.isAcrossStart(4, 0));
        assertEquals(false, puzzle.isAcrossStart(4, 1));
        assertEquals(false, puzzle.isAcrossStart(4, 2));
        assertEquals(false, puzzle.isAcrossStart(4, 3));
        assertEquals(false, puzzle.isAcrossStart(4, 4));
    }

    @Test
    public void testIsDownClue() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        assertEquals(true,  puzzle.isDownStart(0, 0));
        assertEquals(false, puzzle.isDownStart(0, 1));
        assertEquals(true,  puzzle.isDownStart(0, 2));
        assertEquals(false, puzzle.isDownStart(0, 3));
        assertEquals(true,  puzzle.isDownStart(0, 4));

        assertEquals(false, puzzle.isDownStart(1, 0));
        assertEquals(false, puzzle.isDownStart(1, 2));
        assertEquals(false, puzzle.isDownStart(1, 4));

        assertEquals(false, puzzle.isDownStart(2, 0));
        assertEquals(false, puzzle.isDownStart(2, 1));
        assertEquals(false, puzzle.isDownStart(2, 2));
        assertEquals(false, puzzle.isDownStart(2, 3));
        assertEquals(false, puzzle.isDownStart(2, 4));

        assertEquals(false, puzzle.isDownStart(3, 0));
        assertEquals(false, puzzle.isDownStart(3, 2));
        assertEquals(false, puzzle.isDownStart(3, 4));

        assertEquals(false, puzzle.isDownStart(4, 0));
        assertEquals(false, puzzle.isDownStart(4, 1));
        assertEquals(false, puzzle.isDownStart(4, 2));
        assertEquals(false, puzzle.isDownStart(4, 3));
        assertEquals(false, puzzle.isDownStart(4, 4));
    }

    @Test
    public void findStarts() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Set<Clue> clues = puzzle.clues;

        Clue c1 = new Clue(0, 0, 1, true, true);
        Clue c2 = new Clue(0, 2, 2, false, true);
        Clue c3 = new Clue(0, 4, 3, false, true);
        Clue c4 = new Clue(2, 0, 4, true, false);
        Clue c5 = new Clue(4, 0, 5, true, false);

        Set<Clue> expectedClues = new HashSet<>();
        expectedClues.add(c1);
        expectedClues.add(c2);
        expectedClues.add(c3);
        expectedClues.add(c4);
        expectedClues.add(c5);

        assertEquals(expectedClues, clues);
    }

    @Test
    public void testToString() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        String actual = puzzle.toString();
        String expected =
                "     \n" +
                " # # \n" +
                "     \n" +
                " # # \n" +
                "     \n";

        assertEquals(expected, actual);
    }

}