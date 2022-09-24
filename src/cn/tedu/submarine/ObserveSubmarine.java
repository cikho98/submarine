package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 侦查潜艇
 */
public class ObserveSubmarine extends SeaObject  implements EnemyScore{


    public ObserveSubmarine() {
        super(63, 19);
    }

    @Override
    public void move() {
        setX(getX()+getSpeed());
    }


    @Override
    public ImageIcon getImage() {
        return Images.obsersubm;
    }

    @Override
    public int getScore() {
        return 10;
    }
}
