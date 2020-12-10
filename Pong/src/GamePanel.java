import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Timer timer;
    private Player player1;
    private Player player2;
    private Ball ball;
    private boolean inGame = true;



    public GamePanel() {
        initializedVariables();
        initializedLayout();
    }

    private void initializedLayout() {
        //smth to init;
    }

    private void initializedVariables() {
        Score score = new Score();
        player1 = new Player(true);
        player2 = new Player(true);
        ball = new Ball(player1, player2);
        addKeyListener(new GameEventListener(this));
        setFocusable(true);
        // after every GAME_SPEED ms swing-> calls gameLoop
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.white);
//        g.drawRect(player1.getX(), player1.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
//        g.drawRect(player2.getX(), player2.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
        g.fillRect(player1.getX(), player1.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
        g.fillRect(player2.getX(), player2.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
    }

    private void drawGUI(Graphics g) {
        g.setColor(Color.white);
        int y = 0;
        for (int i = 0; i < 21; i++) {
//            g.drawRect(Constants.BOARD_WIDTH/2-1,y+15,2,10);
            g.fillRect(Constants.BOARD_WIDTH / 2 - 1, y + 15, 2, 10);
            y += 20;
        }


    }

    private void drawBall(Graphics g) {
        g.setColor(Color.white);
//        g.drawRect(ball.getX(), ball.getY(), Constants.BALL_WIDTH, Constants.BALL_HIGHT);
        g.fillRect(ball.getX(), ball.getY(), Constants.BALL_WIDTH, Constants.BALL_HIGHT);
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(g.getFont().deriveFont(40f));
        g.drawString(Integer.toString(Score.getScore_1()), Constants.BOARD_WIDTH / 2 + 50, 30);
        g.drawString(Integer.toString(Score.getScore_2()), Constants.BOARD_WIDTH / 2 - 50, 30);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
//        System.out.println("Repaint");
        doDrawing(g);

    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            drawPlayer(g);
            drawBall(g);
            drawGUI(g);
            drawScore(g);
        } else if (timer.isRunning()) {
            timer.stop();
        }
        Toolkit.getDefaultToolkit().sync();

    }

    public void doOneLoop() {
        update();
        //call paintComponent for redraw objects
        repaint();
    }

    //update coordinates gameObjects
    private void update() {
//        System.out.println("Update");
        this.player1.move();
        this.player2.move();
        this.ball.move();
    }

    public void keyReleased(KeyEvent e) {
        this.player1.keyReleased(e);
        this.player2.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.player1.keyPressed(e);
        this.player2.keyPressed(e);
    }
}
