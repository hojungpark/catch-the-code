package Objects;

import java.awt.*;
import Game.*;

import java.awt.*;

/**
* Superclass for the reward and punishments of the game.
* @author Group 21
*/
public class SuperObject {

    public Image image; //to store image of reward or punishment
    public String name; //name of reward to check which is collected
    public boolean collision = false; //collision detection
    public int worldX, worldY; //world coordinates
    public int points; //points value of the reward or punishment

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); //tile of the object
    public int solidAreaDefaultX = 0; //area x coordinate
    public int solidAreaDefaultY = 0; //area  y coordinate

    /**
    * Handles drawing the rewards and punishments on the screen according to their coordinates.
    * @param g2 Of Graphics2D to handle the drawing
    * @param gpd Of GamePanelData type to access game panel variables
    */
    public void draw(Graphics2D g2, GamePanelData gpd)
    {
        int screenX = worldX - gpd.player.worldX + gpd.player.screenX;
        int screenY = worldY - gpd.player.worldY + gpd.player.screenY;

        if(worldX + gpd.tileSize > gpd.player.worldX - gpd.player.screenX &&
                worldX - gpd.tileSize < gpd.player.worldX + gpd.player.screenX &&
                worldY + gpd.tileSize > gpd.player.worldY - gpd.player.screenY &&
                worldY - gpd.tileSize < gpd.player.worldY + gpd.player.screenY) {

            g2.drawImage(image, screenX, screenY, gpd.tileSize, gpd.tileSize, null);
        }
    }

}

