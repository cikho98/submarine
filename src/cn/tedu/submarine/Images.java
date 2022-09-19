package cn.tedu.submarine;

import javax.swing.ImageIcon;

import cn.tedu.submarine.configure.Setting;

public class Images {
    public static ImageIcon sea;
    public static ImageIcon gameover;
    public static ImageIcon battleship;
    public static ImageIcon obsersubm;
    public static ImageIcon torpesubm;
    public static ImageIcon minesubm;
    public static ImageIcon mine;
    public static ImageIcon bomb;

    static {
        String imgpath = Setting.IMGPATH;
        sea = new ImageIcon(imgpath + "sea.png");
        gameover = new ImageIcon(imgpath + "gameover.png");
        battleship = new ImageIcon(imgpath + "battleship.png");
        obsersubm = new ImageIcon(imgpath + "obsersubm.png");
        torpesubm = new ImageIcon(imgpath + "torpesubm.png");
        minesubm = new ImageIcon(imgpath + "minesubm.png");
        mine = new ImageIcon(imgpath + "mine.png");
        bomb = new ImageIcon(imgpath + "bomb.png");
    }

    public static void main(String[] args) {
        System.out.println(sea.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
    }


}
