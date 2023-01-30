import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Snake Game");
        jFrame.setBounds(10,10,905,700);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBackground(Color.DARK_GRAY);

        Gameplay gameplay = new Gameplay();
        jFrame.add(gameplay);
    }

}