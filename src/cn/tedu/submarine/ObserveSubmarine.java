package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 侦查潜艇
 */
public class ObserveSubmarine extends SeaObject {


    public ObserveSubmarine() {
        super(63, 19);
    }

    @Override
    public void move() {
        System.out.println("侦查潜艇x向右移动");
    }


    @Override
    public ImageIcon getImage() {
        return Images.obsersubm;
    }

}
