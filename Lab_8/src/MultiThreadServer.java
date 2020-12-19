import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThreadServer implements Runnable {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static ServerSocket ServerSocket;

    public static void StartServer() {

        try (ServerSocket serverSocket = new ServerSocket(1000);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ServerSocket = serverSocket;
            System.out.println("Server socket created, command console reader for listen to server commands");

            while (!serverSocket.isClosed()) {
                System.out.println("working");

                if (bufferedReader.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");
                    String serverCommand = bufferedReader.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...EXIT EXIT!!!!");
                        serverSocket.close();
                        break;
                    }
                }

                Socket client = serverSocket.accept();
                executorService.execute(new MonoClientHandler(client));
                System.out.print("Connection accepted.");

            }
            executorService.shutdown();


        } catch (IOException e) {
            executorService.shutdown();
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        StartServer();
        System.out.println("WORK FINISHED");
    }
}
