import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MarkovWords {
    private static char START = '^';
    private static char END = '$';

    public static void main(String[] args) {
        String filename = "texts/scrabble_dictionary.txt";
        Map<Character, List<Character>> transitions = buildTransitions(filename);

        String word = buildWord(transitions);
        System.out.println(word);
    }

    public static Map<Character, List<Character>> buildTransitions(String filename) {
        Map<Character, List<Character>> transitions = new HashMap<>();

        initAndGet(START, transitions);
        initAndGet(END, transitions);

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filename);
        Scanner scanner = new Scanner(is);

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            buildWord(word, transitions);
        }

        return transitions;
    }

    public static List<Character> initAndGet(Character key, Map<Character, List<Character>> transitions) {
        List<Character> list = transitions.get(key);
        if (list == null) {
            list = new LinkedList<>();
            transitions.put(key, list);
        }
        return list;
    }

    public static void buildWord(String word, Map<Character, List<Character>> transitions) {
        char c1, c2;

        // deal with short, or non-existent words
        // set up the first and last letters
        if (word.length() < 1) {
            return;
        } else if (word.length() == 1) {
            c1 = word.charAt(0);
            c2 = c1;
        } else {
            c1 = word.charAt(0);
            c2 = word.charAt(word.length() - 1);
        }

        // pair start/end states with first and last letters
        transitions.get(START).add(c1);
        initAndGet(c2, transitions).add(END);

        // associate each letter with the letter after it
        initAndGet(c1, transitions).add(c2);
    }

    public static String buildWord(Map<Character, List<Character>> transitions) {
        Character symbol = '^';
        String word = "";

        while (symbol != '$') {
            List<Character> choices = transitions.get(symbol);
            int index = (int) Math.floor(Math.random() * choices.size());
            char nextChar = choices.get(index);

            if (nextChar == '$') {
                return word;
            }

            word += nextChar;
            symbol = nextChar;
        }

        return word;
    }
}
