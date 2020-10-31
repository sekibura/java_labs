package testFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setTitle("DrawTest");
                //Определяем заголовок фрейма
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Определяем, что программа завершит работу при закрытии фрейма
                frame.setVisible(true);
                //Делаем фрейм видимым
            }
        });
    }
}
class SimpleFrame extends JFrame {

    public SimpleFrame() {
//        add(new HelloJavaComponent()); //Создаем и добавляем компонент во фрейм
        add(new DrawGraf());
        pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)

    }
}
class HelloJavaComponent extends JComponent
{
    public static final int MES_X = 20;
    public static final int MES_Y = 20;

    private static final int DEF_WIDTH = 200;
    private static final int DEF_HEIGHT = 100;

    public void paintComponent(Graphics g) {
        Font FTitle = new Font("Arial", Font.PLAIN, 24);
        g.setFont(FTitle);

        g.drawString("Hallo Java", MES_X, MES_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEF_WIDTH, DEF_HEIGHT);
    }
}

class DrawGraf extends JComponent
{
    private static final int W = 200;
    private static final int H = 100;

    public void paintComponent(Graphics g) {
        //Создаем объект g2 для двумерного рисования из объекта g
        Graphics2D g2 = (Graphics2D) g;
//Устанавливаем цвет, который будет применяться
        //для всего содержимого компонента: линий, текстов, заливки фигур
        g2.setColor(Color.RED);
//Рисуем квадрат по центру компонента. Цвет линии - красный
        Rectangle2D rec = new Rectangle2D.Double(W/2-5, H/2-5, 100, 100);
        g2.draw(rec);
//Меняем цвет на синий
        g2.setColor(Color.BLUE);
//Закрашиваем квадрат синим цветом
        g2.fill(rec);
    }

    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }
}





