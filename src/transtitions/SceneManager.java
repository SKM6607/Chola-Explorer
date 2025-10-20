package transtitions;

import javax.swing.*;

public class SceneManager {
    private static JFrame frame;
    private SceneManager(){}
    public static void init(JFrame frame){
        SceneManager.frame=frame;
    }
    public static void switchTo(JPanel other){
        frame.getContentPane().removeAll();
        frame.add(other);
        frame.revalidate();
        frame.repaint();
    }
}
