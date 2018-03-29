import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRace {
    public static volatile int nonAtomicCountVariableInteger = 0;
    public static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count.incrementAndGet();
                    //System.out.println("Thread 1: " + nonAtomicCountVariableInteger);
                    nonAtomicCountVariableInteger++;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count.incrementAndGet();
                    //System.out.println("Thread 2: " + nonAtomicCountVariableInteger);
                    nonAtomicCountVariableInteger++;
                }
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(count);
            System.out.println(nonAtomicCountVariableInteger);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
