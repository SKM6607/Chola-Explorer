package entitity;
import interfaces.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
public final class Enemy extends Entity implements Drawable {
    public Enemy(){
        getImages();
    }
    public void getImages()  {
        try {
            for (int i = 1; i <= 2; i++) {
                down[i - 1] = ImageIO.read(new File("src/res/enemy/enemyd" + i + ".png"));
                left[i - 1] = ImageIO.read(new File("src/res/enemy/enemyl" + i + ".png"));
                up[i - 1] = ImageIO.read(new File("src/res/enemy/enemyu" + i + ".png"));
                right[i - 1] = ImageIO.read(new File("src/res/enemy/enemyr" + i + ".png"));
            }
        } catch (Exception _) {}
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

    }
}
