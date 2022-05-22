package MovementLocation;

import java.awt.*;
import java.text.DecimalFormat;
import Game.GamePanel;
import Game.GamePanelData;

/**
* Class that handles the User Interface of the game: Time, Score, Game pause, Winning and losing messages.
* @author Group 21
*/
public class UI {

    GamePanel gp; //game panel for game window
    GamePanelData gpd; //game panel data
    Font timeScoreFont; //font of time and score
    Font msgFont; //font for messages

    public double playTime; //for the time to be displayed
    DecimalFormat df = new DecimalFormat("#0.00"); //to handle the format

    /**
    * Constructor to set member variables of the class
    * @param gp Of GamePanel type to draw the elements on screen
     *  @param gpd Of GamePanelData type to access game panel data
    */
    public UI(GamePanel gp, GamePanelData gpd) {
        this.gp = gp;
        this.gpd = gpd;
        timeScoreFont = new Font("Cooper Black", Font.BOLD, 25);
        msgFont = new Font("Castellar", Font.PLAIN, 60);
    }

    /**
    * Draws the Time, Score, and messages on the screen
    * @param g2 Of Graphics2D type to draw the elements on the screen
    */
    public void draw(Graphics2D g2) {

        if(gpd.gameLost){
            String loseMsg = "Sorry! YOU'VE LOST!!!";
            g2.setFont(msgFont);
            g2.setColor(Color.orange);
            int textLength = (int) g2.getFontMetrics().getStringBounds(loseMsg, g2).getWidth();
            g2.drawString(loseMsg, gpd.screenWidth/2 - textLength/2, gpd.screenHeight/2 + gpd.tileSize/2);
            gpd.gameThread = null;
        }
        else if(gpd.gameWon){
            String winMsg = "Congratulations!";
            String winMsg2 = "YOU WON!";
            g2.setFont(msgFont);
            g2.setColor(Color.orange);
            int textLength = (int) g2.getFontMetrics().getStringBounds(winMsg, g2).getWidth();
            int textLength2 = (int) g2.getFontMetrics().getStringBounds(winMsg2, g2).getWidth();
            g2.drawString(winMsg, gpd.screenWidth/2 - textLength/2, gpd.screenHeight/2 + gpd.tileSize/2 - 50);
            g2.drawString(winMsg2, gpd.screenWidth/2 - textLength2/2, gpd.screenHeight/2 + gpd.tileSize/2 + 50);
            gpd.gameThread = null;
        }

        if(gpd.gamePaused){
            g2.setFont(timeScoreFont);
            g2.setColor(Color.white);
            String s = "SCORE: " + gpd.score;
            g2.drawString(s, (gpd.screenWidth - s.length()) / 2 + 64, 30);

            String t = "TIME: " + df.format(playTime);
            g2.drawString(t, (gpd.screenWidth - t.length()) / 2 - 160, 30);

        } else {
            g2.setFont(timeScoreFont);
            g2.setColor(Color.white);
            String s = "SCORE: " + gpd.score;
            g2.drawString(s, (gpd.screenWidth - s.length()) / 2 + 64, 30);

            playTime += (double) 1 / 60;
            String t = "TIME: " + df.format(playTime);
            g2.drawString(t, (gpd.screenWidth - t.length()) / 2 - 160, 30);
        }
    }
}
