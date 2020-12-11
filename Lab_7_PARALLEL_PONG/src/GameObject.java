import java.awt.event.KeyEvent;

public abstract class GameObject {

    private boolean isDead;

    protected int x = 0;
    protected int y = 0;
    protected int dx = 0;
    protected int dy = 0;
    protected int xSpeed = 0;
    protected int ySpeed = 0;

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public abstract void move();

    public abstract void restart();

    public GameObject() {
        this.isDead = false;
    }

    public void ToDie() {
        this.isDead = true;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }


}
