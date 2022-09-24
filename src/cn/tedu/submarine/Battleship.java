package cn.tedu.submarine;

import javax.swing.*;

/**
 * 战舰
 */
public class Battleship extends SeaObject {
    private int life;


    public Battleship() {
        super(66, 26, 150, 150, 4, 1);
        life=1;
    }

    @Override
    public void move() {
        System.out.println("战舰x向右移动");
    }

    public void moveLeft() {
        setX(getX()-getSpeed());
    }

    public void moveRight() {
        setX(getX()+getSpeed());
    }

    @Override
    public ImageIcon getImage() {
        return Images.battleship;
    }

    public Bomb shootBomb() {
        return new Bomb(getX(), getY() + 11);
    }

    public void addLife(int num) {
        life += num;
    }

    public int getLife() {
        return life;
    }

    public void subtractLife(){
        life--;
    }

}
