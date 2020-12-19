import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.Socket;

public class TableProcessor {
    private static JTable table;
    private static DefaultTableModel model;

    public TableProcessor(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }

    synchronized public static void AddRow(Object[] objects) {
        model.addRow(objects);
    }



    synchronized public static void RemoveRow(int ID) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((int) model.getValueAt(i, 0) == ID) {
                model.removeRow(i);
                break;
            }
        }
    }

    synchronized public static void UpdateMessage(int ID, String message) {
        System.out.println(ID);
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((int) model.getValueAt(i, 0) == ID) {

                model.setValueAt(message, i, 1);

                break;
            }
        }
    }
}
