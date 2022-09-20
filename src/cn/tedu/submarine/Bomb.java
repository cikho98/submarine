package cn.tedu.submarine;

import javax.swing.*;

/**
 * 炸弹
 */
public class Bomb extends SeaObject {

    public Bomb(int x, int y) {
        super(9, 12, x, y, 3, 1);
    }

    @Override
    public void move() {
        y+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }

    @Override
    public boolean isOutOfBounds() {
        return y>=World.HEIGHT;
    }
}
