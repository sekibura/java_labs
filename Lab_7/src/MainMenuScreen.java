import javax.swing.*;
import java.awt.*;

public class MainMenuScreen {
    public static void DrawMainMenu(JFrame frame) {
        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(Color.black);
        MainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));


        // panel with name PONG
        JPanel NamePanel = new JPanel();
        NamePanel.setBackground(Color.black);
        JLabel NameJLabel = new JLabel("PONG");
        NameJLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 74));
        NameJLabel.setForeground(Color.white);
        NamePanel.add(NameJLabel);
        NameJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainPanel.add(NamePanel);
        //

        //
        JPanel ButtonPanel = new JPanel();
//        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
        JButton OnePlrBtn = new JButton("1 PLAYER");
        JButton TwoPlrBtn = new JButton("2 PLAYERS");
        OnePlrBtn.setOpaque(false);
        OnePlrBtn.setContentAreaFilled(false);
        OnePlrBtn.setBorderPainted(false);
        OnePlrBtn.setFocusPainted(false);
        OnePlrBtn.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        OnePlrBtn.setForeground(Color.white);

        TwoPlrBtn.setOpaque(false);
        TwoPlrBtn.setContentAreaFilled(false);
        TwoPlrBtn.setBorderPainted(false);
        TwoPlrBtn.setFocusPainted(false);
        TwoPlrBtn.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        TwoPlrBtn.setForeground(Color.white);

        ButtonPanel.add(OnePlrBtn);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ButtonPanel.add(TwoPlrBtn);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        ButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonPanel.setBackground(Color.black);

        MainPanel.add(ButtonPanel);
        //


        frame.getContentPane().add(MainPanel);

    }
}
