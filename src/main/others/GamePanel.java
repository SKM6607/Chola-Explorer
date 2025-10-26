package main.others;

import entitity.Player;
import gameEnums.GameState;
import tile.MapsManager;
import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel implements Runnable {
    static final int scale = 3;
    private static final int FPS=90;
    //SCREEN OF GAME (RESOLUTION) 12R16C=>4/3 SCALE IN TERMS OF X:Y
    public static final int maximumRows = 12;
    public static final int maximumColumns = 16;
    private static final int originalTileSizeAsPlanned = 16;
    public static final int tileSize = originalTileSizeAsPlanned * scale;
    public static final int screenWidth = tileSize * maximumColumns;
    public static final int screenHeight = tileSize * maximumRows;
    private final KeyInputHandler keyInputHandler = new KeyInputHandler();
    public GameState gameState=GameState.PLAYING;
    private Thread gameThread = null;
    Player player;
    MapsManager mapsManager =new MapsManager(this);
    public GamePanel() {
        player=new Player(this,keyInputHandler);
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
            switch (gameState) {
                case PLAYING -> player.update();
                case TRANSITION -> {
                    player.resetButtonClicks();
                }
            }
            player.updateMapForPlayer(mapsManager.mapSwap(player));
            repaint();
            sleep(FPS);
        }
    }

    private void sleep(int FPS){
        final int secondInMilliseconds=1000;
        try {
            Thread.sleep(secondInMilliseconds/FPS);
        }catch (InterruptedException _){

        }
    }

    @Override
    protected void paintComponent( Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g=(Graphics2D)g1;
        mapsManager.draw(g);
        player.draw(g);
    }
}
