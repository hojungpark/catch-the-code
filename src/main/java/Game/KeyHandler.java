package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
* Is a subclass of the KeyListener class and handles the up, down, left, right arrow key inputs to update
* the movements and location of the player on the game screen.
* @author Group 21
*/
public class KeyHandler implements KeyListener {

    private GamePanel.STATE State = GamePanel.STATE.STARTSCREEN;
    public boolean uPressed, dPressed, lPressed, rPressed, pausePressed, resumePressed, savePressed; //variables to check which arrow key was pressed

    /**
    * Unused method to be implemented as super class is an interface.
    * @param e Of KeyEvent type
    */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
    * Overrides super class method to handle the key pressed and set the boolean accordingly
    * @param e Of KeyEvent type to accept the key input
    */
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP -> uPressed = true;
            case KeyEvent.VK_DOWN -> dPressed = true;
            case KeyEvent.VK_LEFT -> lPressed = true;
            case KeyEvent.VK_RIGHT -> rPressed = true;
            case KeyEvent.VK_P -> pausePressed = true;
            case KeyEvent.VK_R -> resumePressed = true;
            case KeyEvent.VK_S -> savePressed = true;
        }
    }

    /**
    * Releases the key pressed's consequence after the player's position is updated
    * @param e Of KeyEvent type to accept key input
    */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP)
        {
            uPressed = false;
        }

        else if(code == KeyEvent.VK_DOWN)
        {
            dPressed = false;
        }

        else if(code == KeyEvent.VK_LEFT)
        {
            lPressed = false;
        }

        else if(code == KeyEvent.VK_RIGHT)
        {
            rPressed = false;
        }

        else if(code == KeyEvent.VK_P)
        {
            pausePressed = false;
        }

        else if(code == KeyEvent.VK_R){
            resumePressed = false;
        }

        else if(code == KeyEvent.VK_S){
            savePressed = false;
        }
    }
}
