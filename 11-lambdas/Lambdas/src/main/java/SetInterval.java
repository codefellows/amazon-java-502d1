import java.util.function.Function;

public class SetInterval {
    private int msDelay;
    private Thread thread;
    private boolean isRunning;

    public SetInterval(int msDelay, Runnable code) {
        this.msDelay = msDelay;
        this.isRunning = true;
        this.thread = new Thread(() -> {
            try {
                while (this.isRunning) {
                    Thread.sleep(this.msDelay);
                    if (this.isRunning) {
                        code.run();
                    }
                }
            } catch (InterruptedException e) {
            }
        });
        thread.start();
    }

    public void clearInterval() {
        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Error joining: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
