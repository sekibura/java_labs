import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame {
    public GameMainFrame() {
        IinitializeLayout();
    }

    private void IinitializeLayout() {
        add(new GamePanel());
        setTitle(Constants.TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set icon frame
        ImageIcon imageIcon = new ImageIcon(Constants.ICON_PONG_PATH);
        setIconImage(imageIcon.getImage());
        //
        setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HIGHT));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
