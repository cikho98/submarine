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
        setY(getY()+getSpeed());
    }

    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }

    @Override
    public boolean isOutOfBounds() {
        return getY()>=World.HEIGHT;
    }
}
