package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
* Class to handle the mouse click inputs to start and stop the game
* @author Group 21
*/
public class MouseHandler implements MouseListener {

    /**
    * Method should be overriden as MouseListener is an interface
    */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
    * Accepts mouse input and acts to play the game or stop accordingly
    * @param e Of MouseEvent type to take mouse click input
    */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //play button
        //refactored if cases
        if (x >= GamePanel.WIDTH / 2 + 200 && x <= GamePanel.WIDTH / 2 + 320 && y >= 280 && y <= 330) {
                GamePanel.State = GamePanel.STATE.GAME;
        }

        //stop button
        if (GamePanel.situationCheck == "true" && x >= GamePanel.WIDTH / 2 + 400 && x <= GamePanel.WIDTH / 2 + 520 && y >= 280 && y <= 330) {
            System.exit(1);
        }

        else if(GamePanel.situationCheck == "false" && x>= GamePanel.WIDTH / 2 + 320 && x <= GamePanel.WIDTH / 2 + 440 && y >= 331 && y <= 381) {
                System.exit(1);
        }
    }

    /**
    * Method should be overriden as MouseListener is an interface
    */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
    * Method should be overriden as MouseListener is an interface
    */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
    * Method should be overriden as MouseListener is an interface
    */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
