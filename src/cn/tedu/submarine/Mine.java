package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷
 */
public class Mine extends SeaObject {


    Mine( int x, int y, int harm) {
        super( x, y, harm);
    }

    @Override
    public void move() {
        y-=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.mine;
    }

}
