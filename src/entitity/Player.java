package entitity;

import interfaces.Drawable;
import main.GamePanel;
import main.KeyInputHandler;
import maps.Maps;
import objects.PlayerObjects;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static collision.CollisionManager.isColliding;
import static collision.CollisionManager.reAlign;

public final class Player extends Entity implements Drawable {
    private final PlayerObjects playerObjects;
    GamePanel gamePanel;
    KeyInputHandler keyInputHandler;
    int i = 0;
    private ArrayList<Rectangle> collisionRectanglesM1 = null;
    private ArrayList<Rectangle> collisionRectanglesM2 = null;
    private int currentMapThePlayerIsIn = 0;

    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler) {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;
        this.playerObjects = new PlayerObjects(gamePanel, this);
        setDefaultFields();
    }

    public void setDefaultFields() {
        x = 200;
        y = 200;
        speed = 5;
        hp = 100;
        getPlayerImage();
    }

    public void resetButtonClicks() {
        keyInputHandler.rightPressed =
                keyInputHandler.leftPressed =
                        keyInputHandler.upPressed =
                                keyInputHandler.downPressed = false;
    }

    public void checkCollisionByMap(Collection<ArrayList<Rectangle>> collisions) {
        int mover = 0;
        for (ArrayList<Rectangle> collision : collisions) {
            if (mover == currentMapThePlayerIsIn && collision != null && isColliding(this, collision)) {
                reAlign(this, collision);
            }
            mover++;
        }
    }

    public void updateMapForPlayer(int mapN) {
        currentMapThePlayerIsIn = mapN;
    }

    public void update() {
        playerObjects.update();
        checkCollisionByMap(Arrays.asList(collisionRectanglesM2, collisionRectanglesM1));
        boolean anyKeyPressed =
                keyInputHandler.upPressed ||
                keyInputHandler.downPressed ||
                keyInputHandler.rightPressed ||
                keyInputHandler.leftPressed ||
                keyInputHandler.pPressed ||
                keyInputHandler.hPressed;
        if (anyKeyPressed) {
            if (keyInputHandler.upPressed) {
                direction = Direction.UP;
                y -= speed;
            } else if (keyInputHandler.downPressed) {
                direction = Direction.DOWN;
                y += speed;
            } else if (keyInputHandler.rightPressed) {
                direction = Direction.RIGHT;
                x += speed;
            } else if (keyInputHandler.leftPressed) {
                direction = Direction.LEFT;
                x -= speed;
            }
            else if(keyInputHandler.hPressed){
                shouldDisplayHeart();
            }
            spriteCounter++;
            int PLAYER_MOTION = 20;
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
        g.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
        playerObjects.draw(g);
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

    private void shouldDisplayHeart() {
        long startTime = System.currentTimeMillis();
        displayHeart = true;
        Timer timer = new Timer(1000, (e) -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime == 4000) {
                displayHeart = false;
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }
}
