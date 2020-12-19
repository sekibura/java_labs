import javafx.scene.control.Tab;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TableData {
    private HashMap<Integer, Object[]> clients;
    private HashMap<Socket, Integer> socket_id;


    //    private Socket
    private static int ID = 0;

    public TableData() {
        clients = new HashMap<Integer, Object[]>();
        socket_id = new HashMap<Socket, Integer>();
//        AddEntry(new Socket(), "Hello");
//        AddEntry(new Socket(), "Hello2");
//        AddEntry(new Socket(), "Hello3");
    }

    synchronized public void AddEntry(Socket socket, String message, String nickname) {
        clients.put(ID, new Object[]{socket, message, nickname});
        socket_id.put(socket, ID);
        TableProcessor.AddRow(new Object[]{ID, nickname,message});
        ID++;

//        for (Map.Entry<Integer, Object[]> entry : clients.entrySet()) {
//            int key = entry.getKey();
//            Object[] value = entry.getValue();
//            System.out.print(key + " " + value[0]);
//        }
//        System.out.println();
//        for (Map.Entry<Socket, Integer> entry : socket_id.entrySet()) {
//            Socket key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.print(key + " " + value.toString());
//        }
    }

    synchronized public void UpdateEntryByID(int ID, String message) {
        clients.put(ID, new Object[]{clients.get(ID)[0], message});
        TableProcessor.UpdateMessage(ID, message);

    }

    synchronized public void UpdateEntryBySocket(Socket socket, String message) {
        clients.put(FindId(socket), new Object[]{socket, message});
        TableProcessor.UpdateMessage(FindId(socket), message);
    }

    synchronized public void RemoveClientByID(int ID) {
        socket_id.remove(clients.get(ID)[0]);
        clients.remove(ID);
        TableProcessor.RemoveRow(ID);
    }

    synchronized public void RemoveClientBySocket(Socket socket) {
        TableProcessor.RemoveRow(FindId(socket));
        clients.remove(FindId(socket));
        socket_id.remove(socket);

    }

    synchronized private int FindId(Socket socket) {
        System.out.println("\n" + "ID=" + socket_id.get(socket) + " socket=" + socket + " " + "\n");
        return socket_id.get(socket);
    }

    synchronized public Socket GetSocketByID(int ID) {
        return (Socket) clients.get(ID)[0];
    }

    synchronized public Object[][] GetData() {
        Object[][] data = new Object[clients.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Object[]> entry : clients.entrySet()) {
            int key = entry.getKey();
            Object[] value = entry.getValue();

            // do what you have to do here
            // In your case, another loop.
            data[i][0] = key;
            data[i][1] = value[1];
            data[i][2] = value[2];
            System.out.println(data[i][0] + " " + data[i][1]);
            i++;
        }

        return data;
    }

    synchronized public void ClearData() {
        clients = new HashMap<Integer, Object[]>();
        socket_id = new HashMap<Socket, Integer>();
    }
}
