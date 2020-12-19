import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.TimerTask;

public class MainFrame extends JFrame {
    public JTable table1;
    private JPanel panel1;
    private JButton StartServerButton;
    private JButton StopServerButton;
    private JButton StopClientButton;
    private JScrollPane jscrollpane;
    private JTextArea textArea1;
    MultiThreadServer multiThreadServer;
    ServerSocket serverSocket;
    public static TableData tableData;


    public MainFrame() {
        textArea1.setEditable(false);
        setTitle(Constants.TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(panel1);

        tableData = new TableData();

        createTable();
        TableProcessor tableProcessor = new TableProcessor(table1);
        TextAreaProcessor textAreaProcessor = new TextAreaProcessor(textArea1);


        StartServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MultiThreadServer.StartServer();
//                tableData.ClearData();
                multiThreadServer = new MultiThreadServer();
                Thread thread = new Thread(multiThreadServer);
                thread.start();
            }
        });
        StopServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                putQuitToSystemIn();
//                tableData.ClearData();
            }
        });
        StopClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                int ID = (int) ((DefaultTableModel) table1.getModel()).getValueAt(row, 0);
                try {
                    tableData.GetSocketByID(ID).close();
                    tableData.RemoveClientByID(ID);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }

    private void createTable() {
        table1.setModel(new DefaultTableModel(
                tableData.GetData(),
                new String[]{"id", "nickname", "Message"}
        ));

    }

    private void putQuitToSystemIn() {
        serverSocket = multiThreadServer.ServerSocket;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("QUIT to System.in");
//        StringBuilder sb = new StringBuilder();
//        sb.append("quit").append('\n');
//        String data = sb.toString();
//        InputStream is = new ByteArrayInputStream(data.getBytes());
//        System.setIn(is);

    }

}
