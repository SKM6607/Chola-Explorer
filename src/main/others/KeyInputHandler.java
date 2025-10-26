package main.others;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {
    public void keyTyped(KeyEvent e) {}
    public boolean upPressed,downPressed,rightPressed,leftPressed;
    public boolean hPressed,pPressed;
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed=true;
                break;
            case KeyEvent.VK_A:
                leftPressed=true;
                break;
            case KeyEvent.VK_S:
                downPressed=true;
                break;
            case KeyEvent.VK_D:
                rightPressed=true;
                break;
            case KeyEvent.VK_H:
                hPressed=true;
                break;
            case KeyEvent.VK_P:
                pPressed=true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed=false;
                break;
            case KeyEvent.VK_A:
                leftPressed=false;
                break;
            case KeyEvent.VK_S:
                downPressed=false;
                break;
            case KeyEvent.VK_D:
                rightPressed=false;
                break;
            case KeyEvent.VK_H:
                hPressed=false;
                break;
            case KeyEvent.VK_P:
                pPressed=false;
                break;
        }
    }
}
