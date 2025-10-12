package main;

import entitity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int scale = 3;
    //SCREEN OF GAME (RESOLUTION) 12R16C=>4/3 SCALE IN TERMS OF X:Y
    public final int maximumRows = 12;
    public final int maximumColumns = 16;
    private final int originalTileSizeAsPlanned = 16;
    public final int tileSize = originalTileSizeAsPlanned * scale;
    final int screenWidth = tileSize * maximumColumns;
    final int screenHeight = tileSize * maximumRows;
    private final KeyInputHandler keyInputHandler = new KeyInputHandler();
    private Thread gameThread = null;
    Player player=new Player(this,keyInputHandler);
    TileManager tileManager=new TileManager(this);
    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyInputHandler);
        setFocusable(true);
        startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            player.update();
            repaint();
            sleep(90);
        }
    }

    private void sleep(int FPS){
        final int secondInMilliseconds=1000;
        try {
            Thread.sleep(secondInMilliseconds/FPS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g=(Graphics2D)g1;
        tileManager.draw(g);
        player.draw(g);
    }
}
