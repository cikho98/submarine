package cn.tedu.submarine;

public class World {
    public static void main(String[] args) {
        Battleship s = new Battleship();
        ObserveSubmarine os1 = new ObserveSubmarine();
        ObserveSubmarine os2 = new ObserveSubmarine();
        ObserveSubmarine os3 = new ObserveSubmarine();
        ObserveSubmarine os4 = new ObserveSubmarine();
        TorpedoSubmarine ts1 = new TorpedoSubmarine();
        TorpedoSubmarine ts2 = new TorpedoSubmarine();
        MineSubmarine ms1 = new MineSubmarine();
        MineSubmarine ms2 = new MineSubmarine();



        Mine m1 = new Mine(100,125,1);
        Mine m2 = new Mine(150,250,1);
        Bomb b1 = new Bomb(220,330,1);
        Bomb b2 = new Bomb(100,250,1);




    }
}
