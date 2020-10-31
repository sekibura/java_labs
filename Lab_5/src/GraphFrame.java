

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GraphFrame {

    public static void CreateGUI(/*float[] ALAverage,float[] LLAverage,float[] AL, float[] LL,*/String TitleGraph) {
        JFrame frame = new JFrame(TitleGraph + " graph");
//        frame.setPreferredSize(new Dimension(800, 800));
//        frame.setDefaultCloseOperation();

        JPanel MainPanel = new JPanel();
//        MainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

        JLabel TitleText = new JLabel("Average");
        TitleText.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel TitleText2 = new JLabel("Not average");
        TitleText2.setAlignmentX(Component.CENTER_ALIGNMENT);


        //
        JPanel AveragePanel = new JPanel();
//        AveragePanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        AveragePanel.add(new CoordinateGrid());
//        AveragePanel.setVisible(true);

        JPanel NotAveragePanel = new JPanel();
        NotAveragePanel.add(new CoordinateGrid());

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


    protected void paintComponent(Graphics g) {
        int XStart = 30;

        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(XStart, 10, 1000, 300);
        int xV = XStart + 200;
        int yV = 310;
        int xH = XStart;
        int yH = 10;
        int xValue = 10;
        int yValue = 100;


//        g.drawLine(140,330,140,30);
        for (int i = 0; i < 5; i++) {
            g.drawLine(xV, yV, xV, yV - 300);
            g.drawString(String.valueOf(xValue), xV - 20, yV + 20);
            xValue *= 10;
            System.out.println(xValue);
            xV += 200;
        }

        for (int i = 0; i < 11; i++) {
            g.drawLine(xH, yH, xH + 1000, yH);
            g.drawString(String.valueOf(yValue), xH - 30, yH);
            yH += 30;
            yValue -= 10;
        }


    }
    public Dimension getPreferredSize() {
        return new Dimension(W, H); // appropriate constants
    }

}

class  GraphDraw extends JPanel{

    private static final int W = 1060;
    private static final int H = 400;
    float[] ALAverage,  LLAverage, AL, LL;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int x=0;
        float PrevY=0;
//        g.drawRect(XStart, 10, 1000, 300);
        if(ALAverage.length==LLAverage.length){
            for (int i=0;i<ALAverage.length;i++){
                g.drawLine(x,Math.round(PrevY),x+200,Math.round(ALAverage[i])*3);//??????????????????????????????????????????????????
                PrevY=ALAverage[i];
                x+=200;
            }
        }


    }

    public Dimension getPreferredSize() {
        return new Dimension(W, H); // appropriate constants
    }

    public  void DrawGraph(float[] ALAverage, float[] LLAverage, float[] AL, float[] LL) {
        this.ALAverage=ALAverage;
        this.LLAverage=LLAverage;
        this.AL=AL;
        this.LL=LL;



    }
}


