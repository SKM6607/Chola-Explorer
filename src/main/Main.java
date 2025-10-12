package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Dimension trial=Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(trial.width+","+ trial.height);
        JFrame gameWindow=new JFrame("Chola Explorer- THE GAME");
        GamePanel gamePanel=new GamePanel();
        gameWindow.add(gamePanel);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }
}