package tile;

import entitity.Player;
import interfaces.Drawable;
import main.GamePanel;

import java.awt.*;

import static maps.Maps.drawMap0;
import static maps.Maps.drawMap1;

public final class MapsManager implements Drawable {
    public int mapN = 1;
    GamePanel gamePanel;

    public MapsManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        clrScreen(g);
        switch (mapN) {
            case 0 -> drawMap0(g);
            default -> drawMap1(g);
        }
    }

    public void mapSwap(Player player) {
        if (player.x < 0 || player.y < 0 || player.x > GamePanel.screenWidth || player.y > GamePanel.screenHeight) {
            mapN = 1 - mapN;
            player.x = 100;
        }
    }
    public void clrScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
        g.dispose();
    }
}
