package tile;

import tile.Tile.TileType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TilesUtility {
    private static final Tile[] tile = new Tile[6];
    private static final int TILE_SIZE = 16;

    static {
        tileInitializer(Tile.TileType.EARTH);
        tileInitializer(Tile.TileType.GRASS);
        tileInitializer(Tile.TileType.SAND);
        tileInitializer(Tile.TileType.TREE);
        tileInitializer(Tile.TileType.WALL);
        tileInitializer(Tile.TileType.WATER);
    }

    static private void tileInitializer(TileType tileType) {
        String tilesPath = "src/res/tiles/" + tileType.tileName + ".png";
        tile[tileType.tileNumber] = new Tile(tilesPath);
    }
    
    private static Point linearDraw(BufferedImage image, Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        if (startX < 0 || startY < 0 || numberOfColumns < 0 || numberOfRows < 0 || g == null) {
            return null;
        }
        for (int i = 0, y = startY; i < numberOfRows; i++) {
            for (int j = 0, x = startX; j < numberOfColumns; j++) {
                g.drawImage(image, x, y, null);
                x += TILE_SIZE;
            }
            y += TILE_SIZE;
        }
        return new Point(startX + numberOfColumns * TILE_SIZE, startY + numberOfRows * TILE_SIZE);
    }

    public static Point drawGrassBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.GRASS.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }

    public static Point drawWaterBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.WATER.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }

    public static Point drawTreeBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.TREE.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }

    public static Point drawSandBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.SAND.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }

    public static Point drawWallBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.WALL.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }

    public static Point drawEarthBlocks(Graphics2D g, int startX, int startY, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.EARTH.tileNumber].image, g, startX, startY, numberOfRows, numberOfColumns);
    }
}
