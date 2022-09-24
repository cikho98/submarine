package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore {

    public TorpedoSubmarine() {
        super(100, 20);
    }

    @Override
    public void move() {
        setX(getX()+getSpeed());
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }

    @Override
    public int getScore() {
        return 40;
    }
}
