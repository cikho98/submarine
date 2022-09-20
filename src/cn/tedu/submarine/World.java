package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author tarena
 */
public class World extends JPanel {

    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;
    private static int SCORE = 0;

    private Battleship ship = new Battleship();
    private SeaObject[] submarines = {};
    private Mine[] mines = {};
    private Bomb[] bombs = {};

    @Override
    public void paint(Graphics g) {
        Images.sea.paintIcon(null, g, 0, 0);
        ship.plantImage(g);
        for (SeaObject sub : submarines) {
            sub.plantImage(g);
        }
        for (Mine mine : mines) {
            mine.plantImage(g);
        }

        for (Bomb bomb : bombs) {
            bomb.plantImage(g);
        }
        g.drawString("SCORE: " + SCORE, 200, 50);
        g.drawString("LIFE: " + ship.getLife(), 400, 50);
    }

    private SeaObject nextSubmarine() {
        Random ran = new Random();
        int type = ran.nextInt(20);
        if (type < 10) {
            return new ObserveSubmarine();
        } else if (type < 15) {
            return new TorpedoSubmarine();
        } else {
            return new MineSubmarine();
        }
    }

    private int subEnterIndex = 0;

    private void submarineEnterAction() {
        subEnterIndex++;
        if (subEnterIndex % 40 == 0) {
            SeaObject obj = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = obj;
        }
    }

    private int mineEnterIndex = 0;

    private void mineEnterAction() {
        mineEnterIndex++;
        if (mineEnterIndex % 100 == 0) {
            for (SeaObject seo : submarines) {
                if (seo instanceof MineSubmarine) {
                    MineSubmarine minesubmarine = (MineSubmarine) seo;
                    Mine mine = minesubmarine.shootMine();
                    mines = Arrays.copyOf(mines, mines.length + 1);
                    mines[mines.length - 1] = mine;
                }
            }

        }
    }

    private void moveAction() {
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].move();
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].move();
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].move();
        }
    }

    private void outOfBoundAction() {
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isOutOfBounds() || submarines[i].isDead()) {
                submarines[i] = submarines[submarines.length - 1];
                submarines = Arrays.copyOf(submarines, submarines.length - 1);
            }
        }
        for (int i = 0; i < mines.length; i++) {
            if (mines[i].isOutOfBounds() || mines[i].isDead()) {
                mines[i] = mines[mines.length - 1];
                mines = Arrays.copyOf(mines, mines.length - 1);
            }
        }
        for (int i = 0; i < bombs.length; i++) {
            if (bombs[i].isOutOfBounds() || bombs[i].isDead()) {
                bombs[i] = bombs[bombs.length - 1];
                bombs = Arrays.copyOf(bombs, bombs.length - 1);
            }
        }
    }

    private void bombBangAction() {
        for (int i = 0; i < bombs.length; i++) {
            Bomb b = bombs[i];
            for (int j = 0; j < submarines.length; j++) {
                if (b.isLive() && submarines[j].isLive() && submarines[j].isHit(b)) {
                    b.goDead();
                    submarines[j].goDead();
                    if (submarines[j] instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) submarines[j];
                        SCORE += es.getScore();
                        System.out.println(SCORE);
                    }
                    if (submarines[j] instanceof EnemyLife) {
                        EnemyLife el = (EnemyLife) submarines[j];
                        ship.addLife(el.getLife());
                        System.out.println("生命值：" + ship.getLife());
                    }
                }
            }
        }
    }

    private void mineBangAction() {
        for (int i = 0; i < mines.length; i++) {
            Mine mine = mines[i];
            if (ship.isHit(mine)) {
                mine.goDead();
                ship.addLife(-1);
                if (ship.getLife() <= 0) {
                    System.out.println("game over");
                }
            }
        }
    }

    private void action() {
        //监听器
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Bomb obj = ship.shootBomb();
                    bombs = Arrays.copyOf(bombs, bombs.length + 1);
                    bombs[bombs.length - 1] = obj;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    ship.moveLeft();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    ship.moveRight();
                }
            }
        };
        this.addKeyListener(k);
        requestFocus();
        //定时器·1
        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                submarineEnterAction();
                mineEnterAction();
                moveAction();
                bombBangAction();
                mineBangAction();
                outOfBoundAction();
                repaint();
            }
        }, interval, interval);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(); //3.
        frame.setVisible(true); //1)设置窗口可见
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 16, HEIGHT + 39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //1)设置窗口可见  2)尽快调用paint()方法
        world.action();

    }
}
