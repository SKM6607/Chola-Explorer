package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile {
    public BufferedImage image;
    public Tile(String image){
        try {
            this.image = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public enum TileType {
        GRASS(0, "grass"),
        SAND(1, "sand"),
        EARTH(2, "earth"),
        WATER(3, "water"),
        TREE(4, "tree"),
        WALL(5, "wall"),
        LAVA(6,"lava");
        final int tileNumber;
        final String tileName;
        TileType(int tileNumber, String tileName) {
            this.tileNumber = tileNumber;
            this.tileName = tileName;

        }
    }
}
