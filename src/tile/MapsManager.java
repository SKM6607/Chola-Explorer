package tile;
import interfaces.Drawable;
import main.GamePanel;
import java.awt.*;
import java.util.ArrayList;

import static maps.Maps.*;

public class TileManager implements Drawable {
    GamePanel gamePanel;
    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        drawMap1(g);
    }

}
