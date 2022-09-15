package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

public abstract class SeaObject {
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


    SeaObject(int width, int height, int x, int y, int speed, int harm) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.harm = harm;
    }


    public abstract void move();

    public abstract ImageIcon getImage();


}
