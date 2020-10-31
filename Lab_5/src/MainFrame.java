import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private int Hight = 720;
    private int Width = 1200;

    JTextField jTextField, jTextField1;

//    public MainFrame() {
//        setSize(this.Width, this.Hight);
//
//        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        jTextField = new JTextField(15);
//        jTextField.setToolTipText("Введите значение");
//
//        jTextField1 = new JTextField(15);
//        jTextField1.setToolTipText("Введите значение2");
//
//
//
//        contents.add(jTextField);
//        contents.add(jTextField1);
//        setContentPane(contents);
//
////        add(); //Создаем и добавляем компонент во фрейм
////        pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
//
//    }

    public static void CreateGUI() {
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("«Test frame»");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

        JPanel AddPanel = new JPanel();
        JLabel AddTextView=new JLabel("ADD TIMES");
        AddTextView.setAlignmentX(Component.CENTER_ALIGNMENT);
        AddPanel.setLayout(new GridLayout(5, 6, 5, 12));
        AddPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        AddPanel.add(new JLabel(""));
        AddPanel.add(new JLabel("10"));
        AddPanel.add(new JLabel("100"));
        AddPanel.add(new JLabel("1000"));
        AddPanel.add(new JLabel("10000"));
        AddPanel.add(new JLabel("100000"));
        AddPanel.add(new JLabel("ArrayList Average"));
        JTextField jTextField10ALA = new JTextField(10);
        AddPanel.add(jTextField10ALA);
        JTextField jTextField100ALA = new JTextField(10);
        AddPanel.add(jTextField100ALA);
        JTextField jTextField1000ALA = new JTextField(10);
        AddPanel.add(jTextField1000ALA);
        JTextField jTextField10000ALA = new JTextField(10);
        AddPanel.add(jTextField10000ALA);
        JTextField jTextField100000ALA = new JTextField(10);
        AddPanel.add(jTextField100000ALA);
        AddPanel.add(new JLabel("LinkedList Average"));
        JTextField jTextField10LLA = new JTextField(10);
        AddPanel.add(jTextField10LLA);
        JTextField jTextField100LLA = new JTextField(10);
        AddPanel.add(jTextField100LLA);
        JTextField jTextField1000LLA = new JTextField(10);
        AddPanel.add(jTextField1000LLA);
        JTextField jTextField10000LLA = new JTextField(10);
        AddPanel.add(jTextField10000LLA);
        JTextField jTextField100000LLA = new JTextField(10);
        AddPanel.add(jTextField100000LLA);
        AddPanel.add(new JLabel("ArrayList"));
        JTextField jTextField10AL = new JTextField(10);
        AddPanel.add(jTextField10AL);
        JTextField jTextField100AL = new JTextField(10);
        AddPanel.add(jTextField100AL);
        JTextField jTextField1000AL = new JTextField(10);
        AddPanel.add(jTextField1000AL);
        JTextField jTextField10000AL = new JTextField(10);
        AddPanel.add(jTextField10000AL);
        JTextField jTextField100000AL = new JTextField(10);
        AddPanel.add(jTextField100000AL);
        AddPanel.add(new JLabel("LinkedList"));
        JTextField jTextField10LL = new JTextField(10);
        AddPanel.add(jTextField10LL);
        JTextField jTextField100LL = new JTextField(10);
        AddPanel.add(jTextField100LL);
        JTextField jTextField1000LL = new JTextField(10);
        AddPanel.add(jTextField1000LL);
        JTextField jTextField10000LL = new JTextField(10);
        AddPanel.add(jTextField10000LL);
        JTextField jTextField100000LL = new JTextField(10);
        AddPanel.add(jTextField100000LL);

        JPanel RemovePanel = new JPanel();
        JLabel RemoveTextView=new JLabel("REMOVE TIMES");
        RemoveTextView.setAlignmentX(Component.CENTER_ALIGNMENT);
        RemovePanel.setLayout(new GridLayout(5, 6, 5, 12));
        RemovePanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        RemovePanel.add(new JLabel(""));
        RemovePanel.add(new JLabel("10"));
        RemovePanel.add(new JLabel("100"));
        RemovePanel.add(new JLabel("1000"));
        RemovePanel.add(new JLabel("10000"));
        RemovePanel.add(new JLabel("100000"));
        RemovePanel.add(new JLabel("ArrayList Average"));
        JTextField jTextField10ALARemove = new JTextField(10);
        RemovePanel.add(jTextField10ALARemove);
        JTextField jTextField100ALARemove = new JTextField(10);
        RemovePanel.add(jTextField100ALARemove);
        JTextField jTextField1000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField1000ALARemove);
        JTextField jTextField10000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField10000ALARemove);
        JTextField jTextField100000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField100000ALARemove);
        RemovePanel.add(new JLabel("LinkedList Average"));
        JTextField jTextField10LLARemove = new JTextField(10);
        RemovePanel.add(jTextField10LLARemove);
        JTextField jTextField100LLARemove = new JTextField(10);
        RemovePanel.add(jTextField100LLARemove);
        JTextField jTextField1000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField1000LLARemove);
        JTextField jTextField10000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField10000LLARemove);
        JTextField jTextField100000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField100000LLARemove);
        RemovePanel.add(new JLabel("ArrayList"));
        JTextField jTextField10ALRemove = new JTextField(10);
        RemovePanel.add(jTextField10ALRemove);
        JTextField jTextField100ALRemove = new JTextField(10);
        RemovePanel.add(jTextField100ALRemove);
        JTextField jTextField1000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField1000ALRemove);
        JTextField jTextField10000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField10000ALRemove);
        JTextField jTextField100000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField100000ALRemove);
        RemovePanel.add(new JLabel("LinkedList"));
        JTextField jTextField10LLRemove = new JTextField(10);
        RemovePanel.add(jTextField10LLRemove);
        JTextField jTextField100LLRemove = new JTextField(10);
        RemovePanel.add(jTextField100LLRemove);
        JTextField jTextField1000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField1000LLRemove);
        JTextField jTextField10000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField10000LLRemove);
        JTextField jTextField100000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField100000LLRemove);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
        JButton EnterButton = new JButton("Построить графики");
        EnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Это событие мы не увидим");
                GraphFrame.CreateGUI("Add");
                GraphFrame.CreateGUI("Remove");
            }
        });
        EnterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonPanel.add(EnterButton);

        MainPanel.add(AddTextView);
        MainPanel.add(AddPanel);
        MainPanel.add(RemoveTextView);
        MainPanel.add(RemovePanel);
        MainPanel.add(EnterButton);
        frame.getContentPane().add(MainPanel);
//        frame.getContentPane().add(ButtonPanel);
//        frame.setPreferredSize(new Dimension(1000, 800));

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
