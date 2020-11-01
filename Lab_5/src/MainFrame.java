import sun.invoke.empty.Empty;

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
        JLabel AddTextView = new JLabel("ADD TIMES");
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
        jTextField10ALA.setText("0.00512");

        JTextField jTextField100ALA = new JTextField(10);
        AddPanel.add(jTextField100ALA);
        jTextField100ALA.setText("0.000684");

        JTextField jTextField1000ALA = new JTextField(10);
        AddPanel.add(jTextField1000ALA);
        jTextField1000ALA.setText("0.0007174");

        JTextField jTextField10000ALA = new JTextField(10);
        AddPanel.add(jTextField10000ALA);
        jTextField10000ALA.setText("0.00029696");

        JTextField jTextField100000ALA = new JTextField(10);
        AddPanel.add(jTextField100000ALA);
        jTextField100000ALA.setText("0.000146629");

        AddPanel.add(new JLabel("LinkedList Average"));
        JTextField jTextField10LLA = new JTextField(10);
        AddPanel.add(jTextField10LLA);
        jTextField10LLA.setText("0.00272");

        JTextField jTextField100LLA = new JTextField(10);
        AddPanel.add(jTextField100LLA);
        jTextField100LLA.setText("0.00169");

        JTextField jTextField1000LLA = new JTextField(10);
        AddPanel.add(jTextField1000LLA);
        jTextField1000LLA.setText("0.000489");

        JTextField jTextField10000LLA = new JTextField(10);
        AddPanel.add(jTextField10000LLA);
        jTextField10000LLA.setText("0.00020967");

        JTextField jTextField100000LLA = new JTextField(10);
        AddPanel.add(jTextField100000LLA);
        jTextField100000LLA.setText("0.000080213");

        AddPanel.add(new JLabel("ArrayList"));
        JTextField jTextField10AL = new JTextField(10);
        AddPanel.add(jTextField10AL);
        jTextField10AL.setText("0.0512");

        JTextField jTextField100AL = new JTextField(10);
        AddPanel.add(jTextField100AL);
        jTextField100AL.setText("0.0684");

        JTextField jTextField1000AL = new JTextField(10);
        AddPanel.add(jTextField1000AL);
        jTextField1000AL.setText("0.7174");

        JTextField jTextField10000AL = new JTextField(10);
        AddPanel.add(jTextField10000AL);
        jTextField10000AL.setText("2.9696");

        JTextField jTextField100000AL = new JTextField(10);
        AddPanel.add(jTextField100000AL);
        jTextField100000AL.setText("14.6629");

        AddPanel.add(new JLabel("LinkedList"));
        JTextField jTextField10LL = new JTextField(10);
        AddPanel.add(jTextField10LL);
        jTextField10LL.setText("0.0272");

        JTextField jTextField100LL = new JTextField(10);
        AddPanel.add(jTextField100LL);
        jTextField100LL.setText("0.169");

        JTextField jTextField1000LL = new JTextField(10);
        AddPanel.add(jTextField1000LL);
        jTextField1000LL.setText("0.489");

        JTextField jTextField10000LL = new JTextField(10);
        AddPanel.add(jTextField10000LL);
        jTextField10000LL.setText("2.0967");

        JTextField jTextField100000LL = new JTextField(10);
        AddPanel.add(jTextField100000LL);
        jTextField100000LL.setText("8.0213");

        JPanel RemovePanel = new JPanel();
        JLabel RemoveTextView = new JLabel("REMOVE TIMES");
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
        jTextField10ALARemove.setText("0.0339");
        RemovePanel.add(jTextField10ALARemove);

        JTextField jTextField100ALARemove = new JTextField(10);
        RemovePanel.add(jTextField100ALARemove);
        jTextField100ALARemove.setText("0.00471");

        JTextField jTextField1000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField1000ALARemove);
        jTextField1000ALARemove.setText("0.001536");


        JTextField jTextField10000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField10000ALARemove);
        jTextField10000ALARemove.setText("0.0014572");

        JTextField jTextField100000ALARemove = new JTextField(10);
        RemovePanel.add(jTextField100000ALARemove);
        jTextField100000ALARemove.setText("0.0085761");

        RemovePanel.add(new JLabel("LinkedList Average"));
        JTextField jTextField10LLARemove = new JTextField(10);
        RemovePanel.add(jTextField10LLARemove);
        jTextField10LLARemove.setText("0.0431");

        JTextField jTextField100LLARemove = new JTextField(10);
        RemovePanel.add(jTextField100LLARemove);
        jTextField100LLARemove.setText("0.00471");

        JTextField jTextField1000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField1000LLARemove);
        jTextField1000LLARemove.setText("0.010798");

        JTextField jTextField10000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField10000LLARemove);
        jTextField10000LLARemove.setText("0.0763104");

        JTextField jTextField100000LLARemove = new JTextField(10);
        RemovePanel.add(jTextField100000LLARemove);
        jTextField100000LLARemove.setText("1.8406137");

        RemovePanel.add(new JLabel("ArrayList"));
        JTextField jTextField10ALRemove = new JTextField(10);
        RemovePanel.add(jTextField10ALRemove);
        jTextField10ALRemove.setText("0.0339");

        JTextField jTextField100ALRemove = new JTextField(10);
        RemovePanel.add(jTextField100ALRemove);
        jTextField100ALRemove.setText("0.0471");

        JTextField jTextField1000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField1000ALRemove);
        jTextField1000ALRemove.setText("0.1536");

        JTextField jTextField10000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField10000ALRemove);
        jTextField10000ALRemove.setText("1.4572");

        JTextField jTextField100000ALRemove = new JTextField(10);
        RemovePanel.add(jTextField100000ALRemove);
        jTextField100000ALRemove.setText("85.761");

        RemovePanel.add(new JLabel("LinkedList"));
        JTextField jTextField10LLRemove = new JTextField(10);
        RemovePanel.add(jTextField10LLRemove);
        jTextField10LLRemove.setText("0.0431");

        JTextField jTextField100LLRemove = new JTextField(10);
        RemovePanel.add(jTextField100LLRemove);
        jTextField100LLRemove.setText("0.0471");

        JTextField jTextField1000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField1000LLRemove);
        jTextField1000LLRemove.setText("1.0798");

        JTextField jTextField10000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField10000LLRemove);
        jTextField10000LLRemove.setText("76.3104");

        JTextField jTextField100000LLRemove = new JTextField(10);
        RemovePanel.add(jTextField100000LLRemove);
        jTextField100000LLRemove.setText("18406.139");

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
        JButton EnterButton = new JButton("Построить графики");


        EnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Это событие мы не увидим");
//                double[] timesAdd  = new double[] {/*10*/0.0512,0.00512,0.0272,0.00272,/*100*/0.0684,0.000684,0.169,0.00169,/*1000*/0.7174,0.0007174,0.489,0.000489,/*10000*/2.9696,0.00029696,2.0967,0.0002967,/*100000*/14.6629,0.000146629,8.0213,0.000080213};//10: AL: NA, A, LL: NA, A, 100: AL: NA, A, LL: NA, A...
                double[] ArListADD=null;
                double[] ArListAverageADD=null;
                double[] LinkListADD=null;
                double[] LinkListAverageADD=null;
                double[] ArListREMOVE=null;
                double[] ArListAverageREMOVE=null;
                double[] LinkListREMOVE=null;
                double[] LinkListAverageREMOVE=null;
                try {
                    ArListADD = new double[]{Double.parseDouble(jTextField10AL.getText()), Double.parseDouble(jTextField100AL.getText()), Double.parseDouble(jTextField1000AL.getText()), Double.parseDouble(jTextField10000AL.getText()), Double.parseDouble(jTextField100000AL.getText())};
                    ArListAverageADD = new double[]{Double.parseDouble(jTextField10ALA.getText()), Double.parseDouble(jTextField100ALA.getText()), Double.parseDouble(jTextField1000ALA.getText()), Double.parseDouble(jTextField10000ALA.getText()), Double.parseDouble(jTextField100000ALA.getText())};

                    LinkListADD = new double[]{Double.parseDouble(jTextField10LL.getText()), Double.parseDouble(jTextField100LL.getText()), Double.parseDouble(jTextField1000LL.getText()), Double.parseDouble(jTextField10000LL.getText()), Double.parseDouble(jTextField100000LL.getText())};
                    LinkListAverageADD = new double[]{Double.parseDouble(jTextField10LLA.getText()), Double.parseDouble(jTextField100LLA.getText()), Double.parseDouble(jTextField1000LLA.getText()), Double.parseDouble(jTextField10000LLA.getText()), Double.parseDouble(jTextField100000LLA.getText())};

                    ArListREMOVE = new double[]{Double.parseDouble(jTextField10ALRemove.getText()), Double.parseDouble(jTextField100ALRemove.getText()), Double.parseDouble(jTextField1000ALRemove.getText()), Double.parseDouble(jTextField10000ALRemove.getText()), Double.parseDouble(jTextField100000ALRemove.getText())};
                    ArListAverageREMOVE = new double[]{Double.parseDouble(jTextField10ALARemove.getText()), Double.parseDouble(jTextField100ALARemove.getText()), Double.parseDouble(jTextField1000ALARemove.getText()), Double.parseDouble(jTextField10000ALARemove.getText()), Double.parseDouble(jTextField100000ALARemove.getText())};

                    LinkListREMOVE = new double[]{Double.parseDouble(jTextField10LLRemove.getText()), Double.parseDouble(jTextField100LLRemove.getText()), Double.parseDouble(jTextField1000LLRemove.getText()), Double.parseDouble(jTextField10000LLRemove.getText()), Double.parseDouble(jTextField100000LLRemove.getText())};
                    LinkListAverageREMOVE = new double[]{Double.parseDouble(jTextField10LLARemove.getText()), Double.parseDouble(jTextField100LLARemove.getText()), Double.parseDouble(jTextField1000LLARemove.getText()), Double.parseDouble(jTextField10000LLARemove.getText()), Double.parseDouble(jTextField100000LLARemove.getText())};
                    GraphFrame.CreateGUI(ArListADD, LinkListADD, ArListAverageADD, LinkListAverageADD, "Add");
                    GraphFrame.CreateGUI(ArListREMOVE, LinkListREMOVE, ArListAverageREMOVE, LinkListAverageREMOVE, "Remove");
                } catch (NumberFormatException e1) {
                    System.err.println("Error " + e1);
                    JOptionPane.showMessageDialog(frame, "Error " + e1);
                }


            }
        });
        EnterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton EmptyEnterButton = new JButton("Заданные данные");
        EmptyEnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double[] ArListADD = new double[]{/*10*/0.0512,/*100*/0.0684,/*1000*/0.7174,/*10000*/2.9696,/*100000*/14.6629};
                double[] ArListAverageADD = new double[]{/*10*/0.00512,/*100*/0.000684,/*1000*/0.0007174,/*10000*/0.000209696,/*100000*/0.000146629};

                double[] LinkListADD = new double[]{/*10*/0.0272,/*100*/0.169,/*1000*/0.489,/*10000*/2.0967,/*100000*/8.0213};
                double[] LinkListAverageADD = new double[]{/*10*/0.00272,/*100*/0.00169,/*1000*/0.000489,/*10000*/0.0002967,/*100000*/0.000080213};

                double[] ArListREMOVE = new double[]{/*10*/0.0339,/*100*/0.0471,/*1000*/0.1536,/*10000*/1.4572,/*100000*/85.761};
                double[] ArListAverageREMOVE = new double[]{/*10*/0.0339,/*100*/0.00471,/*1000*/0.001536,/*10000*/0.0014571999,/*100000*/0.0085761};

                double[] LinkListREMOVE = new double[]{/*10*/0.0431,/*100*/0.0471,/*1000*/1.0798,/*10000*/76.3104,/*100000*/18406.139};
                double[] LinkListAverageREMOVE = new double[]{/*10*/0.0431,/*100*/0.00471,/*1000*/0.010798,/*10000*/0.076310396,/*100000*/1.8406137};

                GraphFrame.CreateGUI(ArListADD, LinkListADD, ArListAverageADD, LinkListAverageADD, "Add");
                GraphFrame.CreateGUI(ArListREMOVE, LinkListREMOVE, ArListAverageREMOVE, LinkListAverageREMOVE, "Remove");
            }
        });
        EmptyEnterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonPanel.add(EnterButton);
        ButtonPanel.add(new Box.Filler(new Dimension(4, 10), new Dimension(16, 20), new Dimension(32, 100))); // This will expand/contract as needed.
        ButtonPanel.add(EmptyEnterButton);

        MainPanel.add(AddTextView);
        MainPanel.add(AddPanel);
        MainPanel.add(RemoveTextView);
        MainPanel.add(RemovePanel);
        MainPanel.add(ButtonPanel);
        frame.getContentPane().add(MainPanel);
//        frame.getContentPane().add(ButtonPanel);
//        frame.setPreferredSize(new Dimension(1000, 800));

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
