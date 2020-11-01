

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class GraphFrame {

    public static void CreateGUI(double AL[], double LL[], double ALA[], double LLA[], String TitleGraph) {
        JFrame frame = new JFrame(TitleGraph + " graph");
//        frame.setPreferredSize(new Dimension(800, 800));
//        frame.setDefaultCloseOperation();

        JPanel MainPanel = new JPanel();
//        MainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

        JLabel TitleText = new JLabel("Average\n RED - ArrayList\n GREEN - LinkedList");
        TitleText.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel TitleText2 = new JLabel("Not average\n RED - ArrayList\n GREEN - LinkedList");
        TitleText2.setAlignmentX(Component.CENTER_ALIGNMENT);


        //
        JPanel AveragePanel = new JPanel();
        AveragePanel.add(new CoordinateGrid(ALA, LLA));
//        AveragePanel.setOpaque(true);
//        AveragePanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
//        AveragePanel.setPreferredSize(new Dimension(1060, 400));
//        CoordinateGrid coordinateGrid=new CoordinateGrid();

//        AveragePanel.setLayer(coordinateGrid,1);
//        AveragePanel.add(coordinateGrid);

//        GraphDraw graphDraw=new GraphDraw(ALA, LLA);
//        AveragePanel.setLayer(graphDraw,2);
//        AveragePanel.add(graphDraw);


//        AveragePanel.setVisible(true);

        JPanel NotAveragePanel = new JPanel();
        NotAveragePanel.add(new CoordinateGrid(AL, LL));
//        NotAveragePanel.add(new GraphDraw(AL, LL));

        // last operations
        MainPanel.add(TitleText);
        MainPanel.add(AveragePanel);
        MainPanel.add(TitleText2);
        MainPanel.add(NotAveragePanel);
//        MainPanel.add(AveragePanel);
        frame.getContentPane().add(MainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}

class CoordinateGrid extends JPanel {
    private static final int W = 1060;
    private static final int H = 400;
    double[] AL, LL;

    public CoordinateGrid(double[] AL, double[] LL) {
        this.AL = AL;
        this.LL = LL;
    }

    protected void paintComponent(Graphics g) {
        double max = MaxValue(AL, LL);

        int XStart = 30;
        int YStart = 10;
        int Width = 1000;
        int Height = 300;

        super.paintComponent(g);
        int NumberPointX = 5; // количество значений(линий ОУ) по оси Х
        int NumberPointY = 11; // количество значений(линий ОX) по оси Y
        g.setColor(Color.BLACK);
        g.drawRect(XStart, YStart, Width, Height);
        int xV = XStart + (int) Math.round(Width / NumberPointX);
        int yV = YStart + Height;
        int xH = XStart;
        int yH = YStart + Height;


        double YScale = 0;
        if (max > 1) {
            YScale = (int) Math.ceil(max);
        } else {
            YScale = max;
        }
        int XScale = 100000;

        int xValue = 10;// шкала по ОХ 10 - 100000
        float yValue = 0; // шкала по ОУ 100- 0

        for (int i = 0; i < NumberPointX; i++) {
            g.drawLine(xV, yV, xV, yV - Height);
            g.drawString(String.valueOf(xValue), xV - 20, yV + 20);
            xValue *= 10;
            System.out.println(xValue);
            xV += (int) Math.round(Width / NumberPointX);
        }

        for (int i = 0; i < NumberPointY; i++) { // строится снизу вверх 0-YScale
            g.drawLine(xH, yH, xH + Width, yH);
            g.drawString(String.valueOf(Math.round(yValue * 100000.0) / 100000.0), xH - 30, yH);
            yH -= (int) Math.round(Height / (NumberPointY - 1));
            yValue += (double) YScale / (NumberPointY - 1);
        }

///////////////////////////////////////////////////////////////////////////////////////
        int x = XStart;
        double PrevYAL = 0;
        double PrevYLL = 0;

//        double toPixels=Math.round(Value/(YScale/Height))

        if (AL.length == LL.length) {
            for (int i = 0; i < AL.length; i++) {
                System.out.println("AL[" + i + "]=" + AL[i] + " - " + (YStart + Height - (int) Math.round(AL[i] / ((double) YScale / Height))));

                g.setColor(Color.RED);
                g.drawLine(x, YStart + Height - (int) Math.round(PrevYAL / ((double) YScale / Height)), x + (int) Math.round((double) Width / NumberPointX), YStart + Height - (int) Math.round(AL[i] / ((double) YScale / Height)));//??????????????????????????????????????????????????
//                g.drawString("*",x + (int) Math.round((double) Width / NumberPointX), YStart+Height-(int)Math.round(AL[i]/((double) YScale/Height)));
                g.setColor(Color.GREEN);
                g.drawLine(x, YStart + Height - (int) Math.round((double) PrevYLL / ((double) YScale / Height)), x + (int) Math.round((double) Width / NumberPointX), YStart + Height - (int) Math.round(LL[i] / ((double) YScale / Height)));//??????????????????????????????????????????????????
                PrevYAL = AL[i];
                PrevYLL = LL[i];
                x += (int) Math.round(Width / NumberPointX);
            }
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(W, H); // appropriate constants
    }

    private double MaxValue(double AL[], double LL[]) {
        double max = AL[0];
        if (AL.length == LL.length) {
            for (int i = 0; i < AL.length; i++) {
                if (AL[i] > max) {
                    max = AL[i];
                }
            }
            for (int i = 0; i < LL.length; i++) {
                if (LL[i] > max) {
                    max = LL[i];
                }
            }
        }
        return max;
    }


}

//class GraphDraw extends JPanel {
//
//    private static final int W = 1060;
//    private static final int H = 400;
//    double[] AL, LL;
//
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.BLACK);
//        int x = 0;
//        double PrevYAL = 0;
//        double PrevYLL = 0;
//
////        g.drawRect(XStart, 10, 1000, 300);
//        if (AL.length == LL.length) {
//            for (int i = 0; i < AL.length; i++) {
//                g.setColor(Color.RED);
//                g.drawLine(x, (int) Math.round(PrevYAL), x + 200, (int) Math.round(AL[i]) * 3);//??????????????????????????????????????????????????
//                g.setColor(Color.GREEN);
//                g.drawLine(x, (int) Math.round(PrevYLL), x + 200, (int) Math.round(LL[i]) * 3);//??????????????????????????????????????????????????
//                PrevYAL = AL[i];
//                PrevYLL = LL[i];
//                x += 200;
//            }
//        }
//
//
//    }
//
//    public Dimension getPreferredSize() {
//        return new Dimension(W, H); // appropriate constants
//    }
//
//    public GraphDraw(double[] AL, double[] LL) {
//        this.AL = AL;
//        this.LL = LL;
////        this.ALAverage=ALAverage;
////        this.LLAverage=LLAverage;
//
//
//    }
//}


