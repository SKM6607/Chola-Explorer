package tile;
import interfaces.Drawable;
import main.GamePanel;
import java.awt.*;
import static tile.TilesUtility.*;

public class TileManager implements Drawable {
    GamePanel gamePanel;
    Point drawPoint;
    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        drawPoint =drawWallBlocks(g,0,0,1,48);
        drawPoint=drawWallBlocks(g,drawPoint.x-16,0,48,1);
        drawPoint =drawWallBlocks(g,0,0,35,1);
        drawPoint =drawWallBlocks(g,0,drawPoint.y,1,50);
    }
}
