import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameMainFrame extends JFrame {
    public GameMainFrame() {
        IinitializeLayout();
    }

    private void IinitializeLayout() {
        GamePanel panel = new GamePanel();
        add(panel);
//        add(new MainMenuPanel(this));
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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.setInGame(false);
                super.windowClosing(e);

            }
        });
    }

}
