package cn.tedu.submarine;

import java.util.Random;

/**
 * 侦查潜艇
 */
public class ObserveSubmarine {
    int width;  //宽
    int height;  //高
    int x;  //x坐标
    int y;  //y坐标
    int speed;  //移动速度
    int life;  //命

    ObserveSubmarine(){
        width=63;
        height=19;
        x=-width;
        Random rand = new Random();
        y=rand.nextInt(479-height-150+1)+150;
        speed=rand.nextInt(3)+1;
        life=1;
    }


    void move() {
        System.out.println("侦察潜艇x向右移动");
    }
}
