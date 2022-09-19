package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author tarena
 */
public class World extends JPanel {

    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;

    private Battleship ship = new Battleship();
    private SeaObject[] submarines = {};
    private Mine[] mines = {};
    private Bomb[] bombs = {};

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
                repaint();
            }
        }, interval, interval);
    }

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
