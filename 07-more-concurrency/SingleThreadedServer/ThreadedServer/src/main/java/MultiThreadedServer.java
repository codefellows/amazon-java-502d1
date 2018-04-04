import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class MultiThreadedServer implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public static void main(String[] args) {
        MultiThreadedServer server = new MultiThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }

    public MultiThreadedServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            new Thread(
                    new WorkerRunnable(
                            clientSocket, "Multithreaded Server")
            ).start();
        }
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

}