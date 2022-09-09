package cn.tedu.submarine;

import java.util.Random;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine {
    int width;  //宽
    int height;  //高
    int x;  //x坐标
    int y;  //y坐标
    int speed;  //移动速度
    int life;  //命

    TorpedoSubmarine(){
        width=64;
        height=20;
        x=-width;
        Random rand = new Random();
        y=rand.nextInt(479-height-150+1)+150;
        speed=rand.nextInt(3)+1;
        life=1;
    }


    void move() {
        System.out.println("鱼雷潜艇x向右移动");
    }
}
