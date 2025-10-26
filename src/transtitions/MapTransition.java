package transtitions;

import enums.GameState;
import main.GamePanel;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;


public class MapTransition extends JPanel {
    Font newFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
    AtomicReference<Integer> cycles = new AtomicReference<>(0);
    public MapTransition(GamePanel nextPanel) {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
        Timer timer = new Timer(200, e -> {
            if (cycles.get() < 25) {
                cycles.getAndUpdate(n -> n + 1);
                repaint();
            } else {
                ((Timer) e.getSource()).stop();
                nextPanel.gameState= GameState.PLAYING;
                SceneManager.switchTo(nextPanel);
                nextPanel.requestFocusInWindow();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        String displayText = "Loading";
        int width = g.getFontMetrics(newFont).stringWidth(displayText), height = g.getFontMetrics(newFont).getHeight();
        int radius = height/5, offsetX = 10;
        int actualCenterX = (getWidth() - width) / 2;
        int actualCenterY = (getHeight() - height) / 2;
        int[] positionOfDots = {actualCenterY - radius, actualCenterY - radius, actualCenterY - radius};
        changeY(positionOfDots);
        g.setStroke(new BasicStroke(6f));
        g.setColor(Color.WHITE);
        g.setFont(newFont);
        g.drawString(displayText, actualCenterX, actualCenterY);
        g.setColor(Color.ORANGE);
        g.fillArc(actualCenterX + width + radius, positionOfDots[0], radius, radius, 0, 360);
        g.setColor(Color.RED);
        g.fillArc(actualCenterX + width + radius * 2 + offsetX, positionOfDots[1], radius, radius, 0, 360);
        g.setColor(Color.BLUE);
        g.fillArc(actualCenterX + width + radius * 3 + 2 * offsetX, positionOfDots[2], radius, radius, 0, 360);
    }

    private void changeY(int[] changeArray) {
        if (cycles.get() % 2 == 0) {
            changeArray[0] -= 5;
            changeArray[1] += 5 / 2;
            changeArray[2] -= 5;
        } else {
            changeArray[0] += 5;
            changeArray[1] -= 5 / 2;
            changeArray[2] += 5;
        }
    }
}
