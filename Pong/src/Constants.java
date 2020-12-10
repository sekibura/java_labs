import java.awt.event.KeyEvent;

public class Constants {
    private Constants() {
    }

    public static final String TITLE = "PONG";
    public static final String ICON_PONG_PATH = "./ping-pong.png";

    public static final int BOARD_WIDTH = 720;
    public static final int BOARD_HIGHT = 480;

    public static final int PLAYER_HIGHT = 50;
    public static final int PLAYER_WIDTH = 10;

    public static final int BALL_HIGHT = 10;
    public static final int BALL_WIDTH = 10;


    public static final int GAME_SPEED = 1; /*ms*/

    //1player control
    public static final int FIRST_PLAYER_UP = KeyEvent.VK_UP;
    public static final int FIRST_PLAYER_DOWN = KeyEvent.VK_DOWN;
    //2player control
    public static final int SECOND_PLAYER_UP = KeyEvent.VK_W;
    public static final int SECOND_PLAYER_DOWN = KeyEvent.VK_S;
    //1player start point
    public static final int START_COORDINATE_X_1PLAYER = 660;
    public static final int START_COORDINATE_Y_1PLAYER = 200;
    //2player start point
    public static final int START_COORDINATE_X_2PLAYER = 30;
    public static final int START_COORDINATE_Y_2PLAYER = 200;
    //Max ball speed
    public static final int BALL_SPEED_X = 6;
    public static final int BALL_SPEED_Y = 6;

    public static final int MAX_SCORE = 11;
}
