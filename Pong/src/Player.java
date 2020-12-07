import java.awt.event.KeyEvent;

public class Player extends GameObject {
    public Player() {
        initialize();
    }

    private void initialize() {
        setySpeed(5);
        int start_x = 30;
        int start_y = 200;

        setX(start_x);
        setY(start_y);

    }

    @Override
    public void move() {
        y += dy;
//        System.out.println(y);
        if (y > Constants.BOARD_HIGHT - Constants.PLAYER_HIGHT - 40) {
            y = Constants.BOARD_HIGHT - Constants.PLAYER_HIGHT - 40;
        } else if (y < 0) {
            y = 0;
        }

    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -getySpeed();
        } else if (key == KeyEvent.VK_DOWN) {
            dy = getySpeed();
        }
    }


    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }


}
