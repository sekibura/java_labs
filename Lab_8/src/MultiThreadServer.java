import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThreadServer implements Runnable {

    static ExecutorService executorService;
    public static ServerSocket ServerSocket;
    private static ArrayList<MonoClientHandler> ClientHandlers;


    public static void StartServer() {


        try (ServerSocket serverSocket = new ServerSocket(1000);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            executorService = Executors.newFixedThreadPool(100);
            ClientHandlers = new ArrayList<MonoClientHandler>(0);
            ServerSocket = serverSocket;
            System.out.println("Server socket created, command console reader for listen to server commands");
            TextAreaProcessor.AddLine("System", "Start server");

            while (!serverSocket.isClosed()) {

                System.out.println("working");
                Socket client = serverSocket.accept();
                MonoClientHandler NewClient = new MonoClientHandler(client);
                ClientHandlers.add(NewClient);
                executorService.execute(NewClient);
                System.out.print("Connection accepted.");

            }
            executorService.shutdown();


        } catch (IOException e) {
            executorService.shutdown();
            e.printStackTrace();
        } finally {
            TextAreaProcessor.AddLine("System", "Stop server");
            System.out.print("DISCONNECT.");
            try {
                ServerSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        StartServer();
        System.out.println("WORK FINISHED");
    }

    public static void SentMessageToAll(String nickname, String msg) {
        for (MonoClientHandler client : ClientHandlers) {
            client.SendMsg(nickname + ": " + msg);
        }
        TextAreaProcessor.AddLine(nickname, msg);
    }

    public static void RemoveClientHandler(MonoClientHandler monoClientHandler) {
        ClientHandlers.remove(monoClientHandler);
    }

    private static void RemoveAllHandlers() {
        ClientHandlers.clear();
    }

    public static void StopServer() {
        System.out.println("STOPSERVER");
        Iterator<MonoClientHandler> iter = ClientHandlers.listIterator();
        while (iter.hasNext()) {
            iter.next().close();
            iter.remove();
        }
        try {
            ServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void StopHandlerBySocket(Socket socket) {
        MonoClientHandler prey = null;
        for (MonoClientHandler client : ClientHandlers) {
            if (client.GetSocket() == socket) {
                prey = client;
            }
        }
        RemoveClientHandler(prey);
        prey.close();


    }
}
