package maps;

import java.awt.*;
import java.util.ArrayList;

import static tile.TilesUtility.*;

//TODO Implement two game maps
public class Maps {
    private static final int MAX_ROWS = 36 / 3;
    private static final int MAX_COLUMNS = 48 / 3;
    private static final ArrayList<Rectangle> collisionAreaMap1 = new ArrayList<>();
    private static final ArrayList<Rectangle> collisionAreaMap2=new ArrayList<>();
    public static void drawMap1(Graphics2D g) {
        final int OPENING = 5;
        collisionAreaMap1.clear();
        collisionAreaMap1.add(drawWallBlocks(g, 0, 0, 3, 1));//Vertical Boundary #1
        collisionAreaMap1.add(drawWallBlocks(g, 5, 0, MAX_ROWS - 5, 1));
        collisionAreaMap1.add(drawWallBlocks(g, 0, MAX_COLUMNS - 1, MAX_ROWS, 1));//Vertical Boundary#2
        collisionAreaMap1.add(drawWallBlocks(g, 0, 0, 1, MAX_COLUMNS));//Horizontal Boundary #1
        collisionAreaMap1.add(drawWallBlocks(g, MAX_ROWS - 1, 0, 1, MAX_COLUMNS / 2));
        collisionAreaMap1.add(drawWallBlocks(g, MAX_ROWS - 1, MAX_COLUMNS / 2 + OPENING, 1, MAX_COLUMNS / 2 - OPENING));
        //Tree Tiles
        collisionAreaMap1.add(drawTreeBlocks(g, 5, 1, MAX_ROWS - 2, 2));
        collisionAreaMap1.add(drawTreeBlocks(g, 1, 1, 2, MAX_COLUMNS - 2));
        collisionAreaMap1.add(drawTreeBlocks(g, 3, MAX_COLUMNS - 3, MAX_ROWS - 4, 2));
        collisionAreaMap1.add(drawTreeBlocks(g, MAX_ROWS - 3, 1, 2, MAX_COLUMNS / 2 - 1));
        collisionAreaMap1.add(drawTreeBlocks(g, MAX_ROWS - 4, MAX_COLUMNS / 2 - 3, 1, 3));
        //Water
        drawLavaBlocks(g,3,1,5,5);
        drawWaterBlocks(g, MAX_ROWS / 2, MAX_COLUMNS / 2, 2, 2);
        //Walkable
        drawGrassBlocks(g, 3, 0, 2, MAX_COLUMNS - 3);
        drawGrassBlocks(g, 4, 3, 5, 2);
        drawGrassBlocks(g, 5, 5, 1, MAX_COLUMNS - 5 - 3);
        drawGrassBlocks(g, 6, 5, 2, 3);
        drawGrassBlocks(g, 6, 10, 6, 3);
        drawGrassBlocks(g, 8, 8, 4, 2);
    }
    public static ArrayList<Rectangle> getCollisionAreaMap1() {
        return collisionAreaMap1;
    }
    public static void drawMap0(Graphics2D g) {
        //MAP BOUNDARY
        collisionAreaMap2.clear();
        {
            collisionAreaMap2.add(drawWallBlocks(g, 0, 0, MAX_ROWS, 1));
            collisionAreaMap2.add(drawWallBlocks(g, 0, 0, 1, MAX_COLUMNS));
            collisionAreaMap2.add(drawWallBlocks(g, MAX_ROWS - 1, 1, 1, MAX_COLUMNS - 1));
            collisionAreaMap2.add(drawWallBlocks(g, 1, MAX_COLUMNS - 1, 3, 1));
            collisionAreaMap2.add(drawWallBlocks(g, 7, MAX_COLUMNS - 1, MAX_ROWS - 8, 1));
        }
        drawEarthBlocks(g,1,MAX_COLUMNS/2 ,MAX_ROWS-2,1);
        drawEarthBlocks(g,MAX_ROWS/2 -1,1,1,MAX_COLUMNS-1);
        drawSandBlocks(g, 1,MAX_COLUMNS/2+1,MAX_ROWS/2-2,MAX_COLUMNS/2-2);
        drawSandBlocks(g,1,1,MAX_ROWS/2-2,MAX_COLUMNS/2-1);
        drawSandBlocks(g,MAX_ROWS/2,1,MAX_ROWS/2-1,MAX_COLUMNS/2-1);
        drawSandBlocks(g,MAX_ROWS/2,MAX_COLUMNS/2+1,MAX_ROWS/2-1,MAX_COLUMNS/2-2);
        drawEarthBlocks(g,MAX_ROWS/2-2,MAX_COLUMNS/2-1,3,3);
        drawSingleGrassBlock(g,MAX_ROWS/2-2,MAX_COLUMNS-1);
        drawSingleGrassBlock(g,MAX_ROWS/2,MAX_COLUMNS-1);
    }
    public static ArrayList<Rectangle> getCollisionAreaMap2(){
        return collisionAreaMap2;
    }
}
