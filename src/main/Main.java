package main;

import transtitions.MapTransition;

import javax.swing.*;
import java.awt.*;
//TODO Circular screen swapping during transition
public class Main {
    public static void main(String[] args) {
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
