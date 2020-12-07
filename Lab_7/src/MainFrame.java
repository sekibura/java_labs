import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame frame;

    public MainFrame() {
        InitFrame();
        MainMenuScreen.DrawMainMenu(frame);
        System.out.println("Stop Menu");
        GameMainFrame gameMainFrame = new GameMainFrame(frame);


    }

    private void InitFrame() {
        frame = new JFrame(Constants.TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(720, 480));
        ImageIcon imageIcon = new ImageIcon(Constants.ICON_PONG_PATH);
        frame.setIconImage(imageIcon.getImage());
        frame.setBackground(Color.black);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }


}
