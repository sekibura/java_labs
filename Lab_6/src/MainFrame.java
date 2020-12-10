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
        JPanel PanelRadioButtons = new JPanel();
        JPanel SendButtonPanel = new JPanel();
        JPanel FieldsPanel = new JPanel();

        JRadioButton HighPriority = new JRadioButton("Высокий приоритет");
        JRadioButton SecondPriority = new JRadioButton("Средний приоритет");
        JRadioButton LastPriority = new JRadioButton("Низкий приоритет");

        ChangeColor(new JPanel[]{MainPanel, TitleTextPanel, FieldsPanel, PanelRadioButtons, SendButtonPanel}, Color.red);
        ChangeColorButton(new JRadioButton[]{HighPriority, SecondPriority, LastPriority}, Color.red);

        JLabel TitleLabel = new JLabel("Окно заказа");
        TitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        TitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        TitleTextPanel.add(TitleLabel);



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
                if (!Character.isDigit(c) || PhoneTextField.getText().length() > 13) {
                    e.consume();  // ignore event
                }
            }
        });
        FieldsPanel.add(new JLabel("Важность заказа"));


        HighPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeColor(new JPanel[]{MainPanel, TitleTextPanel, FieldsPanel, PanelRadioButtons, SendButtonPanel}, Color.red);
                ChangeColorButton(new JRadioButton[]{HighPriority, SecondPriority, LastPriority}, Color.red);
            }
        });

        HighPriority.setSelected(true);


        SecondPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeColor(new JPanel[]{MainPanel, TitleTextPanel, FieldsPanel, PanelRadioButtons, SendButtonPanel}, Color.yellow);
                ChangeColorButton(new JRadioButton[]{HighPriority, SecondPriority, LastPriority}, Color.yellow);
            }
        });



        LastPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeColor(new JPanel[]{MainPanel, TitleTextPanel, FieldsPanel, PanelRadioButtons, SendButtonPanel}, Color.green);
                ChangeColorButton(new JRadioButton[]{HighPriority, SecondPriority, LastPriority}, Color.green);
            }
        });


        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(HighPriority);
        group.add(SecondPriority);
        group.add(LastPriority);

        PanelRadioButtons.setLayout(new BoxLayout(PanelRadioButtons, BoxLayout.Y_AXIS));
        PanelRadioButtons.add(HighPriority);
        PanelRadioButtons.add(SecondPriority);
        PanelRadioButtons.add(LastPriority);
        FieldsPanel.add(PanelRadioButtons);


        SendButtonPanel.setLayout(new BoxLayout(SendButtonPanel, BoxLayout.Y_AXIS));
        JButton SendButton = new JButton("Отправить");
        SendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FirstNameTextField.getText().isEmpty() || SecondNameTextField.getText().isEmpty()||FatherNameTextField.getText().isEmpty()||PhoneTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Заполните все поля!");
                }
                else{
                    String result = "";
                    result += "Фамилия: "+SecondNameTextField.getText() + "\nИмя: " + FirstNameTextField.getText() + "\nОтчетсво: " + FatherNameTextField.getText() + "\nНомер телефона: " + PhoneTextField.getText() + "\nПриоритет заказа: ";
                    if (HighPriority.isSelected()) {
                        result += "высокий приоритет";
                    } else if (SecondPriority.isSelected()) {
                        result += "средний приоритет";
                    } else if (LastPriority.isSelected()) {
                        result += "низкий приоритет";
                    }
                    JOptionPane.showMessageDialog(frame, result);
                }
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

    private static void ChangeColor(JPanel[] jpanels, Color color) {
        for (JPanel i : jpanels) {
            i.setBackground(color);
        }
    }

    private static void ChangeColorButton(JRadioButton[] jbtns, Color color) {
        for (JRadioButton i : jbtns) {
            i.setBackground(color);
        }
    }

    enum Priorities {
        First,
        Secondary,
        Last
    }
}
