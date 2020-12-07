import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Timer timer;
    private Player player;
    private boolean inGame = true;

    public GamePanel() {
        initializedVariables();
        initializedLayout();
    }

    private void initializedLayout() {
        //smth to init;
    }

    private void initializedVariables() {
        player = new Player();
        addKeyListener(new GameEventListener(this));
        setFocusable(true);
        // after every GAME_SPEED ms swing-> calls gameLoop
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(player.getX(), player.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
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
        this.player.move();
    }

    public void keyReleased(KeyEvent e) {
        this.player.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.player.keyPressed(e);
    }
}
