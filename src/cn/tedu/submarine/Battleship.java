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

    @Override
    public ImageIcon getImage() {
        return Images.battleship;
    }

}
