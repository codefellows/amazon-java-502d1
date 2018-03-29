import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ThreadedFileReader {
    public static void main(String[] args) {
        // Length: 326518653
        // Total words: 61670499
        String filepath = "/Users/moonmayor/Third/Data/lyrics/Lyrics2.csv";
        File file = new File(filepath);

        long length = file.length();
        int words = 0;

        System.out.println("Length: " + length);
        try (RandomAccessFile rfile = new RandomAccessFile(file, "r");
             Scanner scanner = new Scanner(file)) {

            rfile.skipBytes((int) length - 100);
            while (scanner.hasNext()) {
                words++;
                scanner.next();
            }
            System.out.println("Total words: " + words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
