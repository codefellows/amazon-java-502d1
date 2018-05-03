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
        for (int i = 0; i < 1000000; i++) {
            data.add(rand.nextInt());
        }
        System.out.println("Starting");

//        int result = 0;
//        for (int i : data) {
//            result += process(i);
//        }

//        int result = data.stream().map(i -> process(i)).reduce(Integer::sum).get();
        int result = data.parallelStream().map(i -> process(i)).reduce(Integer::sum).get();
        System.out.println(result);
    }
}

