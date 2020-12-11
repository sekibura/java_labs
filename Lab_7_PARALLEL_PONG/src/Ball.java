import com.sun.org.apache.bcel.internal.Const;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ball extends GameObject implements Runnable {
    Player player1;
    Player player2;
    GamePanel panel;

    public Ball(Player player1, Player player2, GamePanel panel) {
        this.player1 = player1; // right
        this.player2 = player2; //left
        this.panel = panel;
        initialize();
    }

    private void initialize() {
        restart();

//        randomImpulse();
//        setxSpeed(1);

//        System.out.println(start_x + " " + start_y);

    }

    @Override
    public void move() {
        sendCoordinatesToPlayers();
        checkCollision();
        setX(getX() + getxSpeed());
        setY(getY() + getySpeed());

    }

    private void randomImpulse() {
        Random random = new Random();
        setxSpeed(Constants.BALL_SPEED_X);
        setySpeed(Constants.BALL_SPEED_Y);
    }

    private int[] hitFactor(Player player) {

        float Value = (float) (getY() - player.getY()) / Constants.PLAYER_HIGHT;
        int[] speeds = new int[]{getxSpeed(), getySpeed()};

        System.out.println("hitFactor = " + Value);
        if (Value == 1) {
            System.out.println("hitFactor 0");
            speeds[1] = 0;
        }
        if (Value < 0.5 && Value >= 0) {
            System.out.println("-hitFactor45");
            speeds[0] = -speeds[0];
            speeds[1] = -Constants.BALL_SPEED_Y;
            //            return -Constants.BALL_SPEED_Y;
//            return Math.abs(getySpeed());
            if (player.getCurrentPlayer() == 1) {
                setX(getX() - Math.abs(2));
                System.out.println("1pl");
            } else if (player.getCurrentPlayer() == 2) {
                setX(getX() + Math.abs(2));
                System.out.println("2pl");
            }
        }
        if (Value >= 0.5 && Value <= 1) {
            System.out.println("hitFactor 45");
            speeds[0] = -speeds[0];
            speeds[1] = Constants.BALL_SPEED_Y;

            if (player.getCurrentPlayer() == 1) {
                setX(getX() - Math.abs(2));
                System.out.println("1pl");
            } else if (player.getCurrentPlayer() == 2) {
                setX(getX() + Math.abs(2));
                System.out.println("2pl");
            }

//            return -Math.abs(getySpeed());
//            return Constants.BALL_SPEED_Y;
        }
        return speeds;
    }

    private void checkCollision() {
        //check up and
        //up collision
//        System.out.println("x=" + getX() + " y=" + getY() + " player1 x=" + player1.getX() + ", y=" + player1.getY() + " player2 x=" + player2.getX() + ", y=" + player2.getY());
        if (getX() <= 0) {

            player1.restart();
            player2.restart();
            Score.setScore_1(Score.getScore_1() + 1);
            restart();
        }
        if (getX() >= Constants.BOARD_WIDTH) {
            player1.restart();
            player2.restart();
            Score.setScore_2(Score.getScore_2() + 1);
            restart();
        } else {
            if (getY() <= 2) {
                setySpeed(-getySpeed());
//                System.out.println("checkColl UP");
            }
            if (getY() >= (Constants.BOARD_HIGHT - Constants.BALL_HIGHT - 40)) {
                setySpeed(-getySpeed());
                setY(Constants.BOARD_HIGHT - Constants.BALL_HIGHT - 41);
//                System.out.println("checkColl DOWN");
            }
            if ((getX() <= player2.getX() + Constants.PLAYER_WIDTH) && (getX() >= player2.getX() - Constants.PLAYER_WIDTH)) {
                int speeds[] = hitFactor(player2);
                setxSpeed(speeds[0]);
                setySpeed(speeds[1]);
//            setxSpeed(-getxSpeed());
//                System.out.println("checkColl 2Player");

            }
            if ((getX() >= player1.getX() - Constants.BALL_WIDTH) && (getX() <= player1.getX() - Constants.BALL_WIDTH + Constants.PLAYER_WIDTH)) {
                int speeds[] = hitFactor(player1);
                setxSpeed(speeds[0]);
                setySpeed(speeds[1]);
//            setxSpeed(-getxSpeed());
//                System.out.println("checkColl 1Player");
            }
        }


    }

    @Override
    public void restart() {
        Random random = new Random();
        if (getX() <= 0) {
            setxSpeed(-Constants.BALL_SPEED_X);
        } else if (getX() >= Constants.BOARD_WIDTH) {
            setxSpeed(Constants.BALL_SPEED_X);
        } else {
            setxSpeed(Constants.BALL_SPEED_X);
        }
        if (Score.checkEndGame()) {
            setxSpeed(Constants.BALL_SPEED_X);
            Score.clearScore();
        }
        int start_x = Constants.BOARD_WIDTH / 2;
        setX(start_x - Constants.PLAYER_WIDTH);
        setY(random.nextInt((300 - 50) + 1) + 50);
        setySpeed(Constants.BALL_SPEED_Y);
        player2.restart();
        player1.restart();
    }

    private void newGame() {
        Random random = new Random();
        setxSpeed(Constants.BALL_SPEED_X);
        Score.clearScore();
        int start_x = Constants.BOARD_WIDTH / 2;
        setX(start_x - Constants.PLAYER_WIDTH);
        setY(random.nextInt((300 - 50) + 1) + 50);
        setySpeed(Constants.BALL_SPEED_Y);
    }

    private void sendCoordinatesToPlayers() {
        player2.setBallCoordinateX(getX());
        player2.setBallCoordinateY(getY());

        player1.setBallCoordinateX(getX());
        player1.setBallCoordinateY(getY());
    }


    enum BallDirection {
        right,
        left
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == Constants.RESTART_GAME_BUTTON) {
            newGame();
            restart();
        }
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
//                System.out.println("11");
            }

        }

    }
}
