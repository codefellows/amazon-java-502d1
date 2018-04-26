import java.util.Date;

public class TimeoutClient {
    public static void main(String[] args) {
        System.out.println("Starting timeout client");
        SetInterval interval = new SetInterval(1000, () -> {
            System.out.println("The current time is " + new Date());
        });

        Timeout timeout = new Timeout(10000, () -> {
            interval.clearInterval();
            System.out.println("complete!");
        });

    }
}
