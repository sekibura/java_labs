import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame {
    private JFrame frame;

    public GameMainFrame(JFrame frame_) {
        frame = frame_;
//        frame.setSize(new Dimension(720, 480));
//        clear menu from frame
//        frame.getContentPane().removeAll();
        frame.add(new GamePanel());



    }
}
