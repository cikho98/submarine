package cn.tedu.submarine;

import javax.swing.ImageIcon;
import java.util.Random;
import java.awt.Graphics;

/**
 * @author tarena
 */
public abstract class
SeaObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    private int state = LIVE;


    private int width;
    private int height;


    private int x;
    private int y;
    private int speed;
    private int harm;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    SeaObject(int width, int height) {
        this.width = width;
        this.height = height;
        x = -width;
        Random rand = new Random();
        y = rand.nextInt(World.HEIGHT - height - 150 + 1) + 150;
        speed = rand.nextInt(3) + 1;
    }

    SeaObject(int width, int height, int x, int y, int speed, int harm) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y - height;
        this.speed = speed;
        this.harm = harm;
    }

    public abstract void move();

    public abstract ImageIcon getImage();

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public boolean isOutOfBounds() {
        return x >= World.WIDTH;
    }

    public boolean isHit(SeaObject other) {
        int x1 = x - other.width;
        int x2 = x + width;
        int y1 = y - other.height;
        int y2 = y + height;

        int x = other.x;
        int y = other.y;

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public void goDead() {
        state = DEAD;
    }

    public void plantImage(Graphics g) {
        if (isLive()) {
            getImage().paintIcon(null, g, x, y);
        }
    }

}
