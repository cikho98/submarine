package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷
 */
public class Mine extends SeaObject {


    public Mine(int x, int y) {
        super(11, 11, x, y, 1, 1);
    }

    @Override
    public void move() {
        setY(getY() - getSpeed());
    }

    @Override
    public ImageIcon getImage() {
        return Images.mine;
    }

    @Override
    public boolean isOutOfBounds() {
        return getY() <= 150 - getHeight();
    }
}
