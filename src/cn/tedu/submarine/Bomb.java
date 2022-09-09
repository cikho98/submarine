package cn.tedu.submarine;

/**
 * 炸弹
 */
public class Bomb {
    int width;  //宽
    int height;  //高
    int x;  //x坐标
    int y;  //y坐标
    int speed;  //移动速度
    int harm;  //伤害

    Bomb(int x , int y,int harm){
        width=9;
        height=12;
        this.x=x;
        this.y=y;
        this.harm=harm;
        speed=3;
    }

    void move() {
        System.out.println("炸弹y向下移动");
    }
}
