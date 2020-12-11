import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Timer timer;
    private Player player1;
    private Player player2;
    private Ball ball;
    private boolean inGame = false;
    private Frame frame;
    private boolean inMenu = true;
    private boolean inPause=false;
    private Thread thread_player_1, thread_player_2, thread_ball;


    public GamePanel() {

        initializedVariables();
        initializedLayout();
//        setTypeOfGame(typeOfGame);

    }

    private void setTypeOfGame(TypeOfGame typeOfGame) {
        switch (typeOfGame) {
            case single:
                player2.setAIPlayer(true);
                player1.setAIPlayer(false);
                break;
            case multiplayer:
                player1.setAIPlayer(false);
                player2.setAIPlayer(false);
                break;
            case computerOnly:
                player1.setAIPlayer(true);
                player2.setAIPlayer(true);
                break;
        }
    }

    private void initializedLayout() {
//        drawMenu();
    }

    private void initializedVariables() {
        Score score = new Score();
        player1 = new Player(this);
        player2 = new Player(this);
        ball = new Ball(player1, player2, this);
        thread_player_1 = new Thread(player1);
        thread_player_2 = new Thread(player2);
        thread_ball = new Thread(ball);
        addKeyListener(new GameEventListener(this));
        setFocusable(true);
        // after every GAME_SPEED ms swing-> calls gameLoop
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(player1.getX(), player1.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
        g.fillRect(player2.getX(), player2.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HIGHT);
    }

    private void drawGUI(Graphics g) {
        g.setColor(Color.white);
        int y = 0;
        for (int i = 0; i < 21; i++) {
            g.fillRect(Constants.BOARD_WIDTH / 2 - 1, y + 15, 2, 10);
            y += 20;
        }


    }

    private void drawBall(Graphics g) {
        g.setColor(Color.white);
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
        doDrawing(g);

    }

    private void doDrawing(Graphics g) {
        if (inGame && !inPause) {
            removeAll();
            drawPlayer(g);
            drawBall(g);
            drawGUI(g);
            drawScore(g);
        } else if (timer.isRunning()) {
            drawMenu();
//            setBackground(Color.CYAN);
            timer.stop();
            System.out.println("timer stop");

        } else if (!timer.isRunning()) {
            drawMenu();
            System.out.println("timer stop 2");
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
//        this.player1.move();
//        this.player2.move();
//        this.ball.move();
    }

    public void keyReleased(KeyEvent e) {
        this.player1.keyReleased(e);
        this.player2.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.player1.keyPressed(e);
        this.player2.keyPressed(e);
        this.ball.keyPressed(e);
        checkMenuButton(e);
        System.out.println("Pressed button");
    }


    enum TypeOfGame {
        single,
        multiplayer,
        computerOnly
    }

    private void drawMenu() {

        System.out.println("draw menu");
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
                setTypeOfGame(TypeOfGame.single);
                inGame = true;

                thread_player_1.start();
                thread_player_2.start();
                thread_ball.start();

                timer.start();
                inMenu = false;

            }
        });
        TwoPlrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTypeOfGame(TypeOfGame.multiplayer);
                inGame = true;
                thread_player_1.start();
                thread_player_2.start();
                thread_ball.start();
                timer.start();
                inMenu = false;
            }
        });

        OnlyPcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTypeOfGame(TypeOfGame.computerOnly);
                inGame = true;
                thread_player_1.start();
                thread_player_2.start();
                thread_ball.start();
                timer.start();
                inMenu = false;
            }
        });

    }

    private void checkMenuButton(KeyEvent event) {
        int key = event.getKeyCode();

        if (key == Constants.ESCAPE_BUTTON && !inMenu) {
            System.out.println("ESCAPE");
//            inGame = false;
            if (!inPause) {
//                inGame = false;
                timer.stop();
                setInPause(true);
            } else {
//                inGame = true;
                timer.start();
                setInPause(false);

            }

        }
    }

    public synchronized boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setInPause(boolean inPause) {
        this.inPause = inPause;
    }

    public synchronized boolean isInPause() {
        return inPause;
    }
}
