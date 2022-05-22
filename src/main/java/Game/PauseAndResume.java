package Game;

import Game.GamePanel;
import Game.KeyHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Class handles pausing and resuming the game with icons on the top left corner.
 * @author Group 21
 */
public class PauseAndResume{

    KeyHandler keyH; //key input
    GamePanel gp; //game screen
    GamePanelData gpd; //game panel data
    public String state; // state : pause, resume
    public Image pause, resume; //image of pause and play icons

    /**
     * Sets the values of member variables
     * @param gp Of GamePanel type for game window display
     * @param keyH Of KeyHandler type to allow input
     */
    public PauseAndResume(GamePanel gp, KeyHandler keyH, GamePanelData gpd){
        this.gp = gp;
        this.gpd = gpd;
        this.keyH = keyH;
        state = "resume";
        getStateImage();
    }

    /**
     * Updates the game window display and game state according to the input
     */
    public void update(){
        if(keyH.pausePressed){
            state = "pause";
            gpd.gamePaused = true;
        }
        if(keyH.resumePressed){
            state = "resume";
            gpd.gamePaused = false;
        }

    }

    /**
     * Sets the images of the icons of pause and play
     */
    public void getStateImage(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        resume = toolkit.getImage("src/main/resources/pause-icon.png");
        pause = toolkit.getImage("src/main/resources/play-icon.png");
    }
    /**
    * Handles drawing the icons according to the input
     */
    public void draw(Graphics2D g2){
        Image image = null;
        switch(state){
            case "pause":
                image = pause;
                 gp.start.paintComponent((Graphics) g2, false);
                break;
            case "resume":
                image = resume;
                break;
        }
        g2.drawImage(image, 0, 0, gpd.tileSize, gpd.tileSize, null);
    }
}
