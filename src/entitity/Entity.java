package entitity;

import java.awt.image.BufferedImage;

public sealed class Entity permits Player,Enemy {
    public int x,y;
    public int speed;
    public int hp;
    public boolean displayHeart;
    public BufferedImage[] up=new BufferedImage[2];
    public BufferedImage[] down=new BufferedImage[2];
    public BufferedImage[] left=new BufferedImage[2];
    public BufferedImage[] right=new BufferedImage[2];
    public Direction direction=Direction.UP;
    public enum Direction{
        UP,DOWN,LEFT,RIGHT;
    }
    protected int spriteCounter=0;
    protected int spriteNum=0;
}
