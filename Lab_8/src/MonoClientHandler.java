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
    private boolean isClosed=false;

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
        System.out.println("Started");
        try {
            while (!client.isClosed()) {
                System.out.println("waiting " + nickname);
                // Если от клиента пришло сообщение
                if (inMessage.hasNext()) {
                    System.out.println("has next");
                    String clientMessage = inMessage.nextLine();
                    System.out.println(clientMessage + "- new MESSAGE!!!");
                    if (nickname == null) {
                        nickname = clientMessage;
                        MultiThreadServer.SentMessageToAll(nickname, "Я новый участник !");
                        System.out.println(nickname + "- new nickname!!!");
                        tableData.AddEntry(client, "Start working", nickname);
                    }
                    // если клиент отправляет данное сообщение, то цикл прерывается и
                    // клиент выходит из чата
                    if (clientMessage.equalsIgnoreCase("quit")) {
                        break;
                    }
                    // выводим в консоль сообщение (для теста)
                    System.out.println(clientMessage);
                    // отправляем данное сообщение всем клиентам
                    MultiThreadServer.SentMessageToAll(nickname, clientMessage);
                    tableData.UpdateEntryBySocket(client, clientMessage);
//                    TextAreaProcessor.AddLine(nickname, clientMessage);
                }
                // останавливаем выполнение потока на 100 мс
                Thread.sleep(100);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if(!isClosed){
                this.close();
            }

        }
//        try {
////            DataOutputStream out = new DataOutputStream(client.getOutputStream());
////            DataInputStream in = new DataInputStream(client.getInputStream());
////            System.out.println("DataInputStream created");
////            System.out.println("DataOutputStream  created");
//
//            while (!client.isClosed()) {
//                System.out.println("Server reading from channel");
//                String entry = in.readUTF();
//                if (nickname == null) {
//                    getNickname(entry);
//                    tableData.AddEntry(client, "Start working", nickname);
//                    System.out.println("Nickname get");
//
//                    System.out.println("Server try writing to channel");
//                    out.writeUTF("Server reply - " + entry + " - OK");
//                    System.out.println("Server Wrote message to clientDialog.");
//
//                    out.flush();
//                    continue;
//                }
//                System.out.println("READ from clientDialog message - " + entry);
//
//                tableData.UpdateEntryBySocket(client, entry);
//                TextAreaProcessor.AddLine(nickname, entry);
//
//                if (entry.equalsIgnoreCase("quit")) {
//
//                    // если кодовое слово получено то инициализируется закрытие
//                    // серверной нити
//                    System.out.println("Client initialize connections suicide ...");
//                    out.writeUTF("Server reply - " + entry + " - OK");
////                    Thread.sleep(3000);
//                    tableData.UpdateEntryBySocket(client, "disconnect");
//                    break;
//                }
//
//                System.out.println("Server try writing to channel");
//                out.writeUTF("Server reply - " + entry + " - OK");
//                System.out.println("Server Wrote message to clientDialog.");
//
//                // освобождаем буфер сетевых сообщений
//                out.flush();
//            }
//            System.out.println("Client disconnected");
//            System.out.println("Closing connections & channels.");
//            in.close();
//            out.close();
////            tableData.RemoveClientBySocket(client);
//            client.close();
//            System.out.println("Closing connections & channels - DONE.");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
////            tableData.RemoveClientBySocket(client);
//        }

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

    public void close() {
//        MultiThreadServer.RemoveClientHandler(this);
        try {
            client.close();
            isClosed=true;
            System.out.println("CLOSE " + nickname);
            MultiThreadServer.SentMessageToAll(nickname, " - покинул/а чат.");
            SendMsg("quit");
            tableData.RemoveClientBySocket(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket GetSocket() {
        return client;
    }
}
