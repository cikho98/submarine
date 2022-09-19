package cn.tedu.submarine;

import javax.swing.ImageIcon;
import java.util.Random;
import java.awt.Graphics;

public abstract class SeaObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    protected int state = LIVE;


    protected int width;  //宽
    protected int height;  //高
    protected int x;  //x坐标
    protected int y;  //y坐标
    protected int speed;  //移动速度0.....
    protected int harm;

    SeaObject(int width, int height) {
        this.width = width;
        this.height = height;
        x = -width;
        Random rand = new Random();
        y = rand.nextInt(World.HEIGHT - height - 150 + 1) + 150;
        speed = rand.nextInt(3) + 1;
    }
    SeaObject(int x, int y, int harm) {
        this.x = x;
        this.y = y;
        this.harm = harm;
    }

    SeaObject(int width, int height, int x, int y, int speed, int harm) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y-height;
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

    public boolean isOutOfBounds(){
        return x>=World.WIDTH;
    }



    public void plantImage(Graphics g){
        if (isLive()){
            getImage().paintIcon(null,g,x,y);
        }
    }

}
