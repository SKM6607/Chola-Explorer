package main;
import transtitions.SceneManager;

import javax.swing.*;
//TODO Circular screen swapping during transition
public class Main {
    public static void main(String[] args) {
        JFrame gameWindow=new JFrame("Chola Explorer- THE GAME");
        GamePanel gamePanel=new GamePanel();
        SceneManager.init(gameWindow);
        gameWindow.add(gamePanel);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }
}
