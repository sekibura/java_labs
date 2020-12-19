import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThreadServer implements Runnable {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static ServerSocket ServerSocket;
    private static ArrayList<MonoClientHandler> ClientHandlers;

    public static void StartServer() {


        try (ServerSocket serverSocket = new ServerSocket(1000);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ClientHandlers=new ArrayList<MonoClientHandler>(0);
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
                MonoClientHandler NewClient=new MonoClientHandler(client);
                ClientHandlers.add(NewClient);
                executorService.execute(NewClient);
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

    public static void SentMessageToAll(String msg){
        for(MonoClientHandler client: ClientHandlers){
            client.SendMsg(msg);
        }
    }
}
