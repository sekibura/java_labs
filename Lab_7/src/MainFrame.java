import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame frame;

    public MainFrame() {
        CreateFrame();
        MainMenuScreen.DrawMainMenu(frame);
    }

    private void CreateFrame() {
        frame = new JFrame("PONG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(720, 480));
        frame.setBackground(Color.black);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
