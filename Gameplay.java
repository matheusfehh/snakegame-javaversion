import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

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

    private int[] enemyXPos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
            475, 500, 525, 550, 575,
            600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };

    private int[] enemyYPos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
            525, 550, 575,
            600, 625 };

    private ImageIcon fruitBody;

    private Random random = new Random();

    private int xPos = random.nextInt(34);
    private int yPos = random.nextInt(23);

    private Timer timer;
    private int delay = 100;

    private int lengthOfSnake = 3;
    private int moves = 0;
    private int score = 0;

    private ImageIcon titleImage;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {

            snakeXLength[0] = 100;
            snakeXLength[1] = 75;
            snakeXLength[2] = 50;

            snakeYLength[0] = 100;
            snakeYLength[1] = 100;
            snakeYLength[2] = 100;

        }

        // Title
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);

        // Gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        // Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores : " + score, 780, 30);

        g.drawString("Length : " + lengthOfSnake, 780, 50);

        rightMouth = new ImageIcon("rightmouth.png");
        rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);

        for (int a = 0; a < lengthOfSnake; a++) {
            
            if (a == 0 && right) {
                rightMouth = new ImageIcon("rightmouth.png");
                rightMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
            }
            
            if (a == 0 && left) {
                leftMouth = new ImageIcon("leftmouth.png");
                leftMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
            }
            
            if (a == 0 && up) {
                upMouth = new ImageIcon("upmouth.png");
                upMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
            }
            
            if (a == 0 && down) {
                downMouth = new ImageIcon("downmouth.png");
                downMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
            }

            if (a != 0) {
                snakeBody = new ImageIcon("snakeimage.png");
                snakeBody.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
            }
        }

        fruitBody = new ImageIcon("enemy.png");

        if (enemyXPos[xPos] == snakeXLength[0] && enemyYPos[yPos] == snakeYLength[0]) {
            lengthOfSnake++;
            score++;
            xPos = random.nextInt(34);
            yPos = random.nextInt(23);
        }
        fruitBody.paintIcon(this, g, enemyXPos[xPos], enemyYPos[yPos]);

        for (int b = 1; b < lengthOfSnake; b++) {
            
            if (snakeXLength[b] == snakeXLength[0] && snakeYLength[b] == snakeYLength[0]) {
                
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over!", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);

            }
        
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        if (right) {
            
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYLength[i + 1] = snakeYLength[i];
            }
            
            for (int i = lengthOfSnake; i >= 0; i--) {
    
                if (i == 0) {
                    snakeXLength[i] = snakeXLength[i] + 25;
                } else {
                    snakeXLength[i] = snakeXLength[i - 1];
                }
    
                if (snakeXLength[i] > 850) {
                    snakeXLength[i] = 25;
                }
    
            }

            repaint();
        }

        if (left) {
        
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYLength[i + 1] = snakeYLength[i];
            }
        
            for (int i = lengthOfSnake; i >= 0; i--) {
        
                if (i == 0) {
                    snakeXLength[i] = snakeXLength[i] - 25;
                } else {
                    snakeXLength[i] = snakeXLength[i - 1];
                }
        
                if (snakeXLength[i] < 25) {
                    snakeXLength[i] = 850;
                }
        
            }

            repaint();
        }

        if (up) {
 
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXLength[i + 1] = snakeXLength[i];
            }
 
            for (int i = lengthOfSnake; i >= 0; i--) {
 
                if (i == 0) {
                    snakeYLength[i] = snakeYLength[i] - 25;
                } else {
                    snakeYLength[i] = snakeYLength[i - 1];
                }
 
                if (snakeYLength[i] < 75) {
                    snakeYLength[i] = 625;
                }
 
            }

            repaint();
        }
        if (down) {

            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXLength[i + 1] = snakeXLength[i];
            }

            for (int i = lengthOfSnake; i >= 0; i--) {

                if (i == 0) {
                    snakeYLength[i] = snakeYLength[i] + 25;
                } else {
                    snakeYLength[i] = snakeYLength[i - 1];
                }

                if (snakeYLength[i] > 625) {
                    snakeYLength[i] = 75;
                }

            }

            repaint();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            moves++;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            moves++;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {

            moves++;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            moves++;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            score = 0;
            moves = 0;
            lengthOfSnake = 3;
            repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

}