package tile;

import tile.Tile.TileType;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class TilesUtility {
    private static final Tile[] tile = new Tile[TileType.values().length];
    private static final int TILE_SIZE = 48;
    private TilesUtility(){}

    static {
        tileInitializer(TileType.EARTH);
        tileInitializer(TileType.GRASS);
        tileInitializer(TileType.SAND);
        tileInitializer(TileType.TREE);
        tileInitializer(TileType.WALL);
        tileInitializer(TileType.WATER);
        tileInitializer(TileType.LAVA);
    }

    static private void tileInitializer(TileType tileType) {
        String tilesPath = "src/res/tiles/" + tileType.tileName + ".png";
        tile[tileType.tileNumber] = new Tile(tilesPath);
    }

    private static Rectangle linearDraw(BufferedImage image, Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        int startX = column * TILE_SIZE;
        int startY = row * TILE_SIZE;
        if (row < 0 || column < 0 || numberOfColumns < 0 || numberOfRows < 0 || g == null) {
            return null;
        }
        for (int i = 0, y = startY; i < numberOfRows; i++) {
            for (int j = 0, x = startX; j < numberOfColumns; j++) {
                g.drawImage(image, x, y, TILE_SIZE, TILE_SIZE, null);
                x += TILE_SIZE;
            }
            y += TILE_SIZE;
        }
        return new Rectangle(
                startX,
                startY,
                TILE_SIZE * numberOfColumns,
                TILE_SIZE * numberOfRows
        );

    }

    public static Rectangle drawGrassBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.GRASS.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawWaterBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.WATER.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawTreeBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.TREE.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawSandBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.SAND.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawWallBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.WALL.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawEarthBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.EARTH.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }
    public static Rectangle drawLavaBlocks(Graphics2D g, int row, int column, int numberOfRows, int numberOfColumns) {
        return linearDraw(tile[TileType.LAVA.tileNumber].image, g, row, column, numberOfRows, numberOfColumns);
    }

    public static Rectangle drawSingleGrassBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.GRASS.tileNumber].image, g, row, column, 1, 1);
    }

    public static Rectangle drawSingleWaterBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.WATER.tileNumber].image, g, row, column, 1, 1);
    }

    public static Rectangle drawSingleTreeBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.TREE.tileNumber].image, g, row, column, 1, 1);
    }

    public static Rectangle drawSingleSandBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.SAND.tileNumber].image, g, row, column, 1, 1);
    }

    public static Rectangle drawSingleWallBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.WALL.tileNumber].image, g, row, column, 1, 1);
    }

    public static Rectangle drawSingleEarthBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.EARTH.tileNumber].image, g, row, column, 1, 1);
    }
    public static Rectangle drawSingleLavaBlock(Graphics2D g, int row, int column) {
        return linearDraw(tile[TileType.LAVA.tileNumber].image, g, row, column, 1, 1);
    }
}
