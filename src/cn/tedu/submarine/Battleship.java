package cn.tedu.submarine;

/**
 * 战舰
 */
public class Battleship extends SeaObject {
    private int life;


    public Battleship() {
        super(9, 12, 10, 10, 3, 1);
    }

    @Override
    public void move() {
        System.out.println("战舰x向右移动");
    }

}
