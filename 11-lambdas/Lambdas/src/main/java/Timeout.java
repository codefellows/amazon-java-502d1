import java.util.function.Function;

public class Timeout {
    private int msDelay;
    private Thread thread;
    private boolean isRunning;

    public Timeout(int msDelay, Runnable code) {
        this.msDelay = msDelay;
        this.isRunning = true;
        this.thread = new Thread(() -> {
            try {
                Thread.sleep(this.msDelay);
                if (this.isRunning) {
                    code.run();
                }
            } catch (InterruptedException e) {

            }
        });
        thread.start();
    }

    public void clearTimeout() {
        this.isRunning = false;

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Error joining: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
