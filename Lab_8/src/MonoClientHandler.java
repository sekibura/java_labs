import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MonoClientHandler implements Runnable {
    private  Socket client;
    private TableData tableData;

    public MonoClientHandler(Socket client) {
        this.client = client;
        tableData = MainFrame.tableData;
        tableData.AddEntry(client, "Start working");
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
            System.out.println("DataOutputStream  created");

            while (!client.isClosed()) {
                System.out.println("Server reading from channel");
                String entry = in.readUTF();
                System.out.println("READ from clientDialog message - " + entry);

                tableData.UpdateEntryBySocket(client, entry);

                if (entry.equalsIgnoreCase("quit")) {

                    // если кодовое слово получено то инициализируется закрытие
                    // серверной нити
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    Thread.sleep(3000);
                    tableData.UpdateEntryBySocket(client, "disconnect");
                    break;
                }

                System.out.println("Server try writing to channel");
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to clientDialog.");

                // освобождаем буфер сетевых сообщений
                out.flush();
            }
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");
            in.close();
            out.close();
            client.close();
            System.out.println("Closing connections & channels - DONE.");
            tableData.RemoveClientBySocket(client);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
