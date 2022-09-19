package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject {

    public TorpedoSubmarine() {
        super(100, 20);
    }

    @Override
    public void move() {
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }

}
