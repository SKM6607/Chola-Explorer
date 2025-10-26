package objects;

import entitity.Player;
import interfaces.Drawable;
import main.others.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class PlayerObjects implements Drawable {
    private static final BufferedImage[] heartImages = new BufferedImage[Heart.values().length];

    static {
        try {
            heartImages[0] = ImageIO.read(new File("src/res/objects/heart/Heart0.png"));
            heartImages[1] = ImageIO.read(new File("src/res/objects/heart/Heart15.png"));
            heartImages[2] = ImageIO.read(new File("src/res/objects/heart/Heart30.png"));
            heartImages[3] = ImageIO.read(new File("src/res/objects/heart/Heart50.png"));
            heartImages[4] = ImageIO.read(new File("src/res/objects/heart/Heart60.png"));
            heartImages[5] = ImageIO.read(new File("src/res/objects/heart/Heart75.png"));
            heartImages[6] = ImageIO.read(new File("src/res/objects/heart/Heart90.png"));
            heartImages[7] = ImageIO.read(new File("src/res/objects/heart/Heart100.png"));
        } catch (IOException _) {
        }
    }

    private final GamePanel gp;
    private final Player player;
    private int preferredHeartSize = 3 * GamePanel.tileSize / 2;
    private BufferedImage playerHeartImage = heartImages[Heart.values().length - 1];
    public PlayerObjects(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
    }

    @Override
    public void update() {
        setHeart(player.hp);
    }

    @Override
    public void draw(Graphics2D g) {

    }
    private void drawHeart(Graphics2D g){
        if(player.displayHeart) {
            int xOffset = player.x - preferredHeartSize / 6, yOffset = player.y - 60;
            g.drawImage(playerHeartImage, xOffset, yOffset, preferredHeartSize, preferredHeartSize, null);
        }
    }
    private void setHeart(int hp) {
        if (hp <= 100 && hp >= 90) {
            playerHeartImage = heartImages[7];
        } else if (hp >= 75 && hp < 90) {
            playerHeartImage = heartImages[6];
        } else if (hp >= 60 && hp < 75) {
            playerHeartImage = heartImages[5];
        } else if (hp >= 50 && hp < 60) {
            playerHeartImage = heartImages[4];
        } else if (hp >= 30 && hp < 50) {
            playerHeartImage = heartImages[3];
        } else if (hp >= 15 && hp < 30) {
            playerHeartImage = heartImages[2];
        } else if (hp < 15 && hp > 10) {
            playerHeartImage = heartImages[1];
        } else playerHeartImage = heartImages[0];
    }
    private enum Heart {
        ZERO(0),
        TEN(10),
        FIFTEEN(15),
        THIRTY(30),
        FIFTY(50),
        SIXTY(60),
        SEVENTY_FIVE(75),
        NINETY(90),
        HUNDRED(100);
        private final int hp;

        Heart(int hp) {
            this.hp = hp;
        }

        public int getHp() {
            return hp;
        }
    }
}
