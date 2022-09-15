package cn.tedu.submarine;

import javax.swing.*;

/**
 * 炸弹
 */
public class Bomb extends SeaObject {

    public Bomb(int width, int height, int x, int y, int speed, int harm) {
        super(width, height, x, y, speed, harm);
    }

    @Override
    public void move() {
        System.out.println("水雷y向下移动");
    }

    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }

}
