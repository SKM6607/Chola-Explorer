package entitity;

import interfaces.Drawable;
import main.GamePanel;
import main.KeyInputHandler;
import maps.Maps;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static collision.CollisionManager.isColliding;
import static collision.CollisionManager.reAlign;

public class Player extends Entity implements Drawable {
    private final int screenWidth, screenHeight;
    private final Rectangle screen;
    GamePanel gamePanel;
    KeyInputHandler keyInputHandler;
    private ArrayList<Rectangle> collisionRectanglesM1 = null;
    private ArrayList<Rectangle> collisionRectanglesM2 = null;
    private int PLAYER_MOTION = 20;

    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler) {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;
        this.screenWidth = this.gamePanel.maximumColumns * gamePanel.tileSize;
        this.screenHeight = this.gamePanel.maximumRows * gamePanel.tileSize;
        screen = new Rectangle(0, 0, screenWidth, screenHeight);
        setDefaultFields();
    }

    public void setDefaultFields() {
        x = 100;
        y = 100;
        speed = 5;
        getPlayerImage();
    }

    public void checkCollisionByMap(ArrayList<Rectangle> collision) {
        if (collision != null && isColliding(this, collision)) {
            reAlign(this, collision);
        }
    }

    public void update() {

        if (keyInputHandler.upPressed || keyInputHandler.downPressed || keyInputHandler.rightPressed || keyInputHandler.leftPressed) {
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
        if (collisionRectanglesM1 == null || collisionRectanglesM2 == null) {
            collisionRectanglesM1 = Maps.getCollisionAreaMap1();
            collisionRectanglesM2 = Maps.getCollisionAreaMap2();
        }
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
                up[i - 1] = ImageIO.read(new File("src/res/player/u" + (i) + ".png"));
                left[i - 1] = ImageIO.read(new File("src/res/player/l" + (i) + ".png"));
                right[i - 1] = ImageIO.read(new File("src/res/player/r" + (i) + ".png"));
                down[i - 1] = ImageIO.read(new File("src/res/player/d" + (i) + ".png"));
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
