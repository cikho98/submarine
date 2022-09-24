package cn.tedu.submarine;

import javax.swing.*;
import java.util.Random;

/**
 * 水雷潜艇
 */
public class MineSubmarine extends SeaObject implements  EnemyScore,EnemyLife{

    public MineSubmarine() {
        super(100, 19);
        setHarm(1);
    }

    @Override
    public void move() {
        setX(getX()+getSpeed());
    }

    @Override
    public ImageIcon getImage() {
        return Images.minesubm;
    }

    public Mine shootMine(){
        return  new Mine(getX()+getWidth(),getY()-11);
    }

    @Override
    public int getScore() {
        return 30;
    }

    @Override
    public int getLife() {
        return 1;
    }
}
