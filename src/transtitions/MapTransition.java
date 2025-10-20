package transtitions;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;


public class MapTransition extends JPanel {
    Font newFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
    AtomicReference<Integer> cycles = new AtomicReference<>(0);

    public MapTransition() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
        Timer timer = new Timer(200, e -> {
            if (cycles.get() < 100) {
                cycles.getAndUpdate(n -> n + 1);
                repaint();
            } else {
                ((Timer) e.getSource()).stop();
            }

        });
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.add(new MapTransition(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
        changeY(positionOfDots,5);
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

    private void changeY(int[] changeArray, int offSet) {
        if (cycles.get() % 2 == 0) {
            changeArray[0] -= offSet;
            changeArray[1] += offSet / 2;
            changeArray[2] -= offSet;
        } else {
            changeArray[0] += offSet;
            changeArray[1] -= offSet / 2;
            changeArray[2] += offSet;
        }
    }
}
