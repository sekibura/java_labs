import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MonoClientHandler implements Runnable {
    private Socket client;
    private TableData tableData;
    private String nickname = null;
    // исходящее сообщение
    private PrintWriter outMessage;
    // входящее собщение
    private Scanner inMessage;

    public MonoClientHandler(Socket client) {
        this.client = client;
        tableData = MainFrame.tableData;
        try {
            this.inMessage = new Scanner(client.getInputStream());
            this.outMessage = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                if (nickname == null) {
                    getNickname(entry);
                    tableData.AddEntry(client, "Start working", nickname);
                    System.out.println("Nickname get");

                    System.out.println("Server try writing to channel");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    System.out.println("Server Wrote message to clientDialog.");

                    out.flush();
                    continue;
                }
                System.out.println("READ from clientDialog message - " + entry);

                tableData.UpdateEntryBySocket(client, entry);
                TextAreaProcessor.AddLine(nickname, entry);

                if (entry.equalsIgnoreCase("quit")) {

                    // если кодовое слово получено то инициализируется закрытие
                    // серверной нити
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
//                    Thread.sleep(3000);
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
//            tableData.RemoveClientBySocket(client);
            client.close();
            System.out.println("Closing connections & channels - DONE.");


        } catch (Exception e) {
            e.printStackTrace();
//            tableData.RemoveClientBySocket(client);
        }

    }

    private void getNickname(String nickname) {
        this.nickname = nickname;
    }

    public void SendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
