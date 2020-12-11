import com.sun.org.apache.bcel.internal.Const;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements Runnable {
    private static int count = 0;
    private int currentPlayer = 0;
    private int UpButton = 0;
    private int DownButton = 0;
    private boolean AIPlayer = false;

    private int ballCoordinateX = 0;
    private int ballCoordinateY = 0;
    private GamePanel panel;

    public Player(GamePanel panel) {
        this.panel = panel;
        initialize();
    }

    private void initialize() {

        int start_x = 0;
        int start_y = 0;
        System.out.println(count);
        if (count == 0) {
            UpButton = Constants.FIRST_PLAYER_UP;
            DownButton = Constants.FIRST_PLAYER_DOWN;
            start_x = Constants.START_COORDINATE_X_1PLAYER;
            start_y = Constants.START_COORDINATE_Y_1PLAYER;
            currentPlayer = 1;
        } else if (count == 1) {
            UpButton = Constants.SECOND_PLAYER_UP;
            DownButton = Constants.SECOND_PLAYER_DOWN;
            start_x = Constants.START_COORDINATE_X_2PLAYER;
            start_y = Constants.START_COORDINATE_Y_2PLAYER;
            currentPlayer = 2;
        }
        count++;
        setySpeed(Constants.PLAYER_SPEED);


        setX(start_x);
        setY(start_y);

    }

    @Override
    public void move() {
        if (AIPlayer) {
            AIControl();
        }
//        y += dy;
        setY(getY() + dy);
//        System.out.println(y);
        if (getY() > Constants.BOARD_HIGHT - Constants.PLAYER_HIGHT - 40) {
//            y = Constants.BOARD_HIGHT - Constants.PLAYER_HIGHT - 40;
            setY(Constants.BOARD_HIGHT - Constants.PLAYER_HIGHT - 40);
        } else if (getY() < 0) {
//            y = 0;
            setY(0);
        }

    }


    private void AIControl() {
        if ((currentPlayer == 1) && (ballCoordinateX > Constants.BOARD_WIDTH / 2)) {
            if ((getY() + Constants.PLAYER_HIGHT / 2) < ballCoordinateY) {
                dy = getySpeed();
            } else {
                dy = -getySpeed();
            }
        } else if ((currentPlayer == 2) && (ballCoordinateX < Constants.BOARD_WIDTH / 2)) {
            if ((getY() + Constants.PLAYER_HIGHT / 2) < ballCoordinateY) {
                dy = getySpeed();
            } else {
                dy = -getySpeed();
            }
        } else {
            dy = 0;
        }
    }


    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == UpButton) {
            dy = -getySpeed();
        } else if (key == DownButton) {
            dy = getySpeed();
        }
    }


    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == UpButton) {
            dy = 0;
        } else if (key == DownButton) {
            dy = 0;
        }
    }

    @Override
    public void restart() {
        System.out.println("player restart " + count);
        if (currentPlayer == 1) {
            System.out.println("player1 restart");
            setX(Constants.START_COORDINATE_X_1PLAYER);
            setY(Constants.START_COORDINATE_Y_1PLAYER);
        } else if (currentPlayer == 2) {
            System.out.println("player2 restart");
            setX(Constants.START_COORDINATE_X_2PLAYER);
            setY(Constants.START_COORDINATE_Y_2PLAYER);
        }
        dy = 0;
    }

    public void setBallCoordinateX(int ballCoordinateX) {
        this.ballCoordinateX = ballCoordinateX;
    }

    public void setBallCoordinateY(int ballCoordinateY) {
        this.ballCoordinateY = ballCoordinateY;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setAIPlayer(boolean AIPlayer) {
        this.AIPlayer = AIPlayer;
    }

    public boolean isAIPlayer() {
        return AIPlayer;
    }

    @Override
    public void run() {
        while (panel.isInGame()) {
            while (!panel.isInPause()) {
                try {
                    move();
                    Thread.sleep(Constants.GAME_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
