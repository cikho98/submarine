package cn.tedu.submarine;

/**
 * 战舰
 */
public class Battleship {
    int width;  //宽
    int height;  //高
    int x;  //x坐标
    int y;  //y坐标
    int speed;  //移动速度
    int life;  //命

    Battleship(){
        width=66;
        height=26;
        x=270;
        y=124;
        speed=20;
        life=2;
    }

    void move() {
        System.out.println("战舰在移动~");
    }
}
