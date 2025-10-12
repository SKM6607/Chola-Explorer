package entitity;

import interfaces.Drawable;
import main.GamePanel;
import main.KeyInputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity implements Drawable {
    GamePanel gamePanel;
    KeyInputHandler keyInputHandler;
    private int PLAYER_MOTION=20;
    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler) {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;
        setDefaultFields();
    }

    public void setDefaultFields() {
        x = 100;
        y = 100;
        speed = 4;
        getPlayerImage();
    }

    public void update() {
        if(keyInputHandler.upPressed|| keyInputHandler.downPressed||keyInputHandler.rightPressed|| keyInputHandler.leftPressed) {
            if (keyInputHandler.upPressed) {
                direction = Direction.UP;
                y -= speed;
            } else if (keyInputHandler.downPressed) {
                direction = Direction.DOWN;
                y += speed;
            } else if (keyInputHandler.rightPressed) {
                direction = Direction.RIGHT;
                x += speed;
            } else {
                direction = Direction.LEFT;
                x -= speed;
            }
            spriteCounter++;
            if (spriteCounter > PLAYER_MOTION) {
                spriteNum = 1 - spriteNum;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g) {
        BufferedImage image = null;
        switch (direction) {
            case UP -> image = up[spriteNum];
            case DOWN -> image = down[spriteNum];
            case LEFT -> image = left[spriteNum];
            case RIGHT -> image = right[spriteNum];
        }
        g.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

    private void getPlayerImage() {
        try {
            for (int i = 1; i <= 2; i++) {
                up[i-1] = ImageIO.read(new File("src/res/player/u" + (i) + ".png"));
                left[i-1] = ImageIO.read(new File("src/res/player/l" + (i) + ".png"));
                right[i-1] = ImageIO.read(new File("src/res/player/r" + (i) + ".png"));
                down[i-1] = ImageIO.read(new File("src/res/player/d" + (i) + ".png"));
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
