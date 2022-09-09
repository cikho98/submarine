package cn.tedu.submarine;

/**
 * 水雷
 */
public class Mine {
    int width;  //宽
    int height;  //高
    int x;  //x坐标
    int y;  //y坐标
    int speed;  //移动速度
    int harm;  //伤害


    Mine(int x, int y,int harm){
        width=11;
        height=11;
        this.x=x;
        this.y=y;
        speed=1;
        this.harm=harm;
    }


    void move() {
        System.out.println("侦察潜艇y往上移动");
    }
}
