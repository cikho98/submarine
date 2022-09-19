package cn.tedu.submarine;

import javax.swing.*;

/**
 * 战舰
 */
public class Battleship extends SeaObject {
    private int life;


    public Battleship() {
        super(66, 26, 150, 150, 3, 1);
    }

    @Override
    public void move() {
        System.out.println("战舰x向右移动");
    }

    public void moveLeft(){
        x-=speed;
    }

    public void moveRight(){
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.battleship;
    }

    public Bomb shootBomb(){
        return new Bomb(x,y);
    }

}
