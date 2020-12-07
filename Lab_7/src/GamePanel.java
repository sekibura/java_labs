import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        System.out.println("GamePanel");
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);
        System.out.println("PaintComp");
    }
}
