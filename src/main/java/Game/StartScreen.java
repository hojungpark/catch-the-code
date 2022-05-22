package Game;

import java.awt.*;
import java.awt.color.*;
import java.awt.font.*;

/**
* Class for the play and stop buttons on the screen
* @author Group 21
*/
public class StartScreen {

    public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 + 200, 280, 100, 50); //Button dimensions
    public Rectangle stopButton = new Rectangle(GamePanel.WIDTH / 2 + 400, 280, 100, 50); //Button specifications
    
    /**
    * Draws the buttons onto the screen using Graphics class
    * @param g Of Graphics type to draw the buttons on the screen
    */
    public void paintComponent(Graphics g, boolean check){
        Graphics2D g2d = (Graphics2D) g;

           Font fnt0 = new Font("arial", Font.BOLD, 35);
        g.setFont(fnt0);
        g.setColor(Color.white);

        if(check) {
            g.drawString("Start", playButton.x + 9, playButton.y + 31);
            g2d.draw(playButton);
            g.drawString("Quit", stopButton.x + 9, stopButton.y + 31);
            g2d.draw(stopButton);
            GamePanel.situationCheck = "true";
        }
        else
        {
            stopButton = new Rectangle(GamePanel.WIDTH / 2 + 320, 331, 100, 50);
            g.drawString("Quit", stopButton.x + 9, stopButton.y + 41);
            g2d.draw(stopButton);
            GamePanel.situationCheck = "false";
        }
    }
}
