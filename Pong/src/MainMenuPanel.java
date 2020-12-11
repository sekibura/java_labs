import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private Frame frame;

    public MainMenuPanel(Frame frame) {
        this.frame = frame;
        initializedLayout();
    }

    private void initializedLayout() {
        ;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.black);
        JPanel NamePanel = new JPanel();
        NamePanel.setBackground(Color.black);
        JLabel NameJLabel = new JLabel("PONG");
        NameJLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 74));
        NameJLabel.setForeground(Color.white);
        NamePanel.add(NameJLabel);
        NameJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(NamePanel);

        JPanel ButtonPanel = new JPanel();
//        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
        JButton OnePlrBtn = new JButton("1 PLAYER");
        JButton TwoPlrBtn = new JButton("2 PLAYERS");
        JButton OnlyPcBtn = new JButton("0 PLAYERS");
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

        OnlyPcBtn.setOpaque(false);
        OnlyPcBtn.setContentAreaFilled(false);
        OnlyPcBtn.setBorderPainted(false);
        OnlyPcBtn.setFocusPainted(false);
        OnlyPcBtn.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
        OnlyPcBtn.setForeground(Color.white);

        ButtonPanel.add(OnePlrBtn);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ButtonPanel.add(TwoPlrBtn);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        ButtonPanel.add(OnlyPcBtn);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        ButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonPanel.setBackground(Color.black);

        add(ButtonPanel);


        OnePlrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                frame.add(new GamePanel(GamePanel.TypeOfGame.single));
                System.out.println("1");
                setBackground(Color.CYAN);
                repaint();

            }
        });
        TwoPlrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                frame.add(new GamePanel(GamePanel.TypeOfGame.multiplayer));
            }
        });

        OnlyPcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                frame.add(new GamePanel(GamePanel.TypeOfGame.computerOnly));

            }
        });
    }
}
