package maps;

import java.awt.*;

import static tile.TilesUtility.*;

public class Maps {
    private static final int MAX_ROWS = 36;
    private static final int MAX_COLUMNS = 48;

    public static void drawL1Map(Graphics2D g) {
        final int OPENING = 5;
        drawWallBlocks(g, 0, 0, MAX_ROWS, 1);//Vertical Boundary #1
        drawWallBlocks(g, 0, MAX_COLUMNS - 1, MAX_ROWS, 1);//Vertical Boundary#2
        drawWallBlocks(g, 0, 0, 1, MAX_COLUMNS);//Horizontal Boundary #1
        //Opening for player to exit
        drawWallBlocks(g, MAX_ROWS - 1, 0, 1, MAX_COLUMNS / 2);
        drawWallBlocks(g, MAX_ROWS - 1, MAX_COLUMNS / 2 + OPENING, 1, MAX_COLUMNS / 2 - OPENING);
        drawSandBlocks(g, 1, 1, MAX_ROWS - 2, 1);
        drawSandBlocks(g, 1, 1, 1, MAX_COLUMNS - 2);
        drawSandBlocks(g, 1, MAX_COLUMNS - 2, MAX_ROWS - 2, 1);
        drawSandBlocks(g, MAX_ROWS - 2, 1, 1, MAX_COLUMNS / 2 - 1);
        drawSandBlocks(g, MAX_ROWS - 2, MAX_COLUMNS / 2 + OPENING, 1, MAX_COLUMNS / 2 - OPENING);
        drawWaterBlocks(g, MAX_ROWS / 2 - 5, MAX_COLUMNS / 2 - 1, 5, 5);
        drawTreeBlocks(g, 3,3, MAX_ROWS - 2, 1);
        drawTreeBlocks(g, 3,3, 1, MAX_COLUMNS - 2);
    }
}
