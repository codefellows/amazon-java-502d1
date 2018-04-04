import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class MyHttpServer {
    public static final int PORT = 6789;

    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        System.out.println("Listening on http://localhost:" + PORT);

        int numThreads = 10;
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        while (true) {
            System.out.println("waiting for request...");
            Socket connectionSocket = null;
            try {
                connectionSocket = welcomeSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Starting thread!");
            WebThread webThread = new WebThread(connectionSocket);
            Thread thread = new Thread(webThread);
            thread.start();
        }
    }
}
