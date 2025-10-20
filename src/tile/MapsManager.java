package tile;
import interfaces.Drawable;
import main.GamePanel;
import java.awt.*;

import static maps.Maps.*;

public class MapsManager implements Drawable {
    GamePanel gamePanel;
    public MapsManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void update() {
    }
    @Override
    public void draw(Graphics2D g) {
//        drawMap1(g);
        drawMap0(g);
    }
}
