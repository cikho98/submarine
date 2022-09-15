package cn.tedu.submarine;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author tarena
 */
public class World {
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+6,HEIGHT+28);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
