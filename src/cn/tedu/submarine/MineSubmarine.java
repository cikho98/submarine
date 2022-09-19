package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 水雷潜艇
 */
public class MineSubmarine extends SeaObject {

    public MineSubmarine() {
        super(100, 19);
        harm=1;
    }

    @Override
    public void move() {
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.minesubm;
    }

    public Mine shootMine(){
        return  new Mine(x+width,y-11,harm);
    }

}
