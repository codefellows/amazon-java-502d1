import java.io.*;
import java.net.Socket;
import java.util.Date;

public class WebThread implements Runnable {
    private boolean IS_SLOW_SERVER = true;
    private Socket socket;

    public WebThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("got request");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));

            // peel off the first GET/POST PATH line
            String requestLine = inFromClient.readLine();

            // get the next line to collect all the headers
            String header = inFromClient.readLine();
            // read lines and assume they're headers until reaching an empty line.
            while (!header.equals("")) {
                header = inFromClient.readLine();
            }

            Date start = new Date();
            if (IS_SLOW_SERVER) {
                // adding 5-second delay to make single-threaded server obvious
                int tries = 0;
                double r1 = 1;
                double r2 = 1;
                double threshold = .0000001;
                while (r1 > threshold && r2 > threshold) {
                    tries++;
                    r1 = Math.random();
                    r2 = Math.random();
                }
                System.out.println("tries: " + tries);
            }
            Date end = new Date();

            String message = "<h1>neato</h1>";
            message += "<p>Start: " + start +  "</p>";
            message += "<p>End:" + end +  "</p>";
            outToClient.write("HTTP/1.1 200 OK\n");
            outToClient.write("Content-Length: " + message.length() + "\n");
            outToClient.write("\n");
            outToClient.write(message + "\n");
            outToClient.flush();
            outToClient.close();

            System.out.println("closed request.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
