import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel {

    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];

    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    
    private ImageIcon rightMouth;
    private ImageIcon leftMouth;
    private ImageIcon upMouth;
    private ImageIcon downMouth;
    private ImageIcon snakeBody;

    private Timer timer;
    private int delay = 100;

    private int lenghtOfSnake = 3;
    private int moves = 0;

    private ImageIcon titleImage;

    public Gameplay() {

    }

    public void paint (Graphics g) {

        if (moves == 0) {
            snakeXLength[0] = 100;
            snakeXLength[1] = 75;
            snakeXLength[2] = 50;
            
            snakeYLength[0] = 100;
            snakeYLength[1] = 100;
            snakeYLength[2] = 100;
        }

        //Title rect
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);       

        //Gameplay rect
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        rightMouth = new ImageIcon("rightmouth.png");
        rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);

        for (int i = 0; i < lenghtOfSnake; i++) {
            if (i == 0 && right) {
                rightMouth = new ImageIcon("rightmouth.png");
                rightMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && left) {
                leftMouth = new ImageIcon("leftmouth.png");
                leftMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && up) {
                upMouth = new ImageIcon("upmouth.png");
                upMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && down) {
                downMouth = new ImageIcon("downmouth.png");
                downMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i != 0) {
                snakeBody = new ImageIcon("snakeimage.png");
                snakeBody.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
        }

        g.dispose();
    }

}
