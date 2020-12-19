import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextAreaProcessor {
    private static JTextArea jTextArea;

    public TextAreaProcessor(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    synchronized public static void AddLine(String nickname, String message) {
        jTextArea.append(nickname+" ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
//        System.out.println(formatter.format(date));

        jTextArea.append(formatter.format(date)+": " + message + "\n");
    }
}
