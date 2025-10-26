package tile;

import entitity.Player;
import gameEnums.GameState;
import interfaces.Drawable;
import main.others.GamePanel;
import transtitions.MapTransition;
import transtitions.SceneManager;

import java.awt.*;

import static maps.Maps.drawMap0;
import static maps.Maps.drawMap1;

public final class MapsManager implements Drawable {
    int mapNumber = 1;
    GamePanel gamePanel;

    public MapsManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void update() {}

    @Override
    public void draw(Graphics2D g) {
        clrScreen(g);
        switch (mapNumber) {
            case 0 -> drawMap0(g);
            default -> drawMap1(g);
        }
    }

    public int mapSwap(Player player) {
        if (mapNumber == 1) {
            if (player.x < 0 || player.y > GamePanel.screenHeight) {
                gamePanel.gameState= GameState.TRANSITION;
                SceneManager.switchTo(new MapTransition(gamePanel));
                mapNumber = 0;

                player.x = GamePanel.screenWidth - 100;
                player.y = GamePanel.screenHeight / 4;
            }
        }
        if (mapNumber == 0) {
            if (player.x > GamePanel.screenWidth) {
                gamePanel.gameState= GameState.TRANSITION;
                SceneManager.switchTo(new MapTransition(gamePanel));
                mapNumber = 1;
                player.x = 100;
                player.y = GamePanel.screenHeight / 4;
            }
        }
        return mapNumber;
    }

    public void clrScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
    }
}
