import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame {



    public static void CreateGUI() {
        JFrame frame = new JFrame("Заказ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

        JPanel TitleTextPanel = new JPanel();

        JLabel TitleLabel = new JLabel("Окно заказа");
        TitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        TitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        TitleTextPanel.add(TitleLabel);

        JPanel FieldsPanel = new JPanel();
        FieldsPanel.setLayout(new GridLayout(5, 2, 5, 12));

        FieldsPanel.add(new JLabel("Фамилия"));
        JTextField SecondNameTextField = new JTextField(30);
        FieldsPanel.add(SecondNameTextField);
        SecondNameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();  // ignore event
                }
            }
        });

        FieldsPanel.add(new JLabel("Имя"));
        JTextField FirstNameTextField = new JTextField(30);
        FieldsPanel.add(FirstNameTextField);
        FirstNameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();  // ignore event
                }
            }
        });

        FieldsPanel.add(new JLabel("Отчество"));
        JTextField FatherNameTextField = new JTextField(30);
        FieldsPanel.add(FatherNameTextField);
        FatherNameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();  // ignore event
                }
            }
        });
        FieldsPanel.add(new JLabel("Телефон"));
        JTextField PhoneTextField = new JTextField(10);
        FieldsPanel.add(PhoneTextField);
        PhoneTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || PhoneTextField.getText().length()>13) {
                    e.consume();  // ignore event
                }
            }
        });
        FieldsPanel.add(new JLabel("Важность заказа"));
//        JTextField OrderPriorityTextField = new JTextField(30);
//        FieldsPanel.add(OrderPriorityTextField);
        JRadioButton HighPriority = new JRadioButton("Высокий приоритет");
        HighPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.setBackground(Color.red);
            }
        });
//        HighPriority.setMnemonic(KeyEvent.VK_B);
//        HighPriority.setActionCommand();
        HighPriority.setSelected(true);


        JRadioButton SecondPriority = new JRadioButton("Средний приоритет");

        SecondPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.setBackground(Color.YELLOW);
            }
        });
//        rabbitButton.setMnemonic(KeyEvent.VK_R);
//        rabbitButton.setActionCommand(rabbitString);

        JRadioButton LastPriority = new JRadioButton("Низкий приоритет");
        LastPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.setBackground(Color.green);
            }
        });
//        pigButton.setMnemonic(KeyEvent.VK_P);
//        pigButton.setActionCommand(pigString);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(HighPriority);
        group.add(SecondPriority);
        group.add(LastPriority);
        JPanel PanelRadioButtons=new JPanel();
        PanelRadioButtons.setLayout(new BoxLayout(PanelRadioButtons, BoxLayout.Y_AXIS));
        PanelRadioButtons.add(HighPriority);
        PanelRadioButtons.add(SecondPriority);
        PanelRadioButtons.add(LastPriority);
        FieldsPanel.add(PanelRadioButtons);

        JPanel SendButtonPanel = new JPanel();
        SendButtonPanel.setLayout(new BoxLayout(SendButtonPanel, BoxLayout.Y_AXIS));
        JButton SendButton= new JButton("Отправить");
        SendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result="";
                result+=SecondNameTextField.getText()+" "+FirstNameTextField.getText()+" "+FatherNameTextField.getText()+" "+PhoneTextField.getText()+" ";
                if(HighPriority.isSelected()){
                    result+="высокий приоритет";
                }
                else if(SecondPriority.isSelected()){
                    result+="средний приоритет";
                }
                else if(LastPriority.isSelected()){
                    result+="низкий приоритет";
                }

                JOptionPane.showMessageDialog(frame, result);
            }
        });
        SendButtonPanel.add(SendButton);







        MainPanel.add(TitleTextPanel);
        MainPanel.add(FieldsPanel);
        MainPanel.add(SendButtonPanel);
        frame.getContentPane().add(MainPanel);
        frame.setPreferredSize(new Dimension(500, 700));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
enum Priorities{
    First,
    Secondary,
    Last
}
