package Entity;

import Game.GamePanel;
import Game.GamePanelData;

import java.awt.*;

/**
* Class that is the super class for player and enemy.
* @author Group 21
*/
public class Entity {

    GamePanel gp; //game panel for game window
    GamePanelData gpd; //game panel data
    public int worldX, worldY; //coordinates of the entity on world map
    public int speed; //variable for speed of entity

    public Image up1, up2, down1, down2, right1, right2, left1, left2; //sprites of entity
    public String direction; //direction : up, down, left, right

    public int spriteCounter = 0; //to change sprites while moving
    public int spriteNum = 1; //variable to check the sprite number

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); //tile for entity
    public int solidAreaDefaultX, solidAreaDefaultY; //area coordinates
    public boolean collisionOn = false; //collision boolean

    /**
    * Constructor sets the game panel member variable.
    * @param gp Of GamePanel type to draw and update the entity coordinates on the screen
     * @param gpd Of GamePanelData type to access game panel data
    */
    public Entity(GamePanel gp, GamePanelData gpd)
    {
        this.gp = gp;
        this.gpd = gpd;
    }

}
