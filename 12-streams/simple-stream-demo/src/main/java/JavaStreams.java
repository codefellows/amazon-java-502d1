import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaStreams {
    public static int process(int n) {
        for (int i = 1; i < 10000; i++) {
            n = (n ^ i) % i;
            if (n <= 0) {
                n = 42;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            data.add(rand.nextInt());
        }
        System.out.println("Starting");

        long streamStart = System.currentTimeMillis();
        int streamResult = data.parallelStream()
                .map(x -> process(x))
                .reduce(Integer::sum)
                .get();
        long streamEnd = System.currentTimeMillis();
        long streamDelta = streamEnd - streamStart;

        System.out.println("Stream: " + streamResult);
        System.out.println("Stream Delta: " + streamDelta);
    }
}

