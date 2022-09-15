package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject {

    public TorpedoSubmarine() {
        super(64, 20);
    }

    @Override
    public void move() {
        System.out.println("鱼雷潜艇x向右移动");
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }

}
