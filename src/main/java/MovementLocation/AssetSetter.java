package MovementLocation;

import Game.GamePanel;
import Game.GamePanelData;
import Objects.*;
import Entity.*;

/**
* Class to set the rewards, punishments, and enemies of the game.
* @author Group 21
*/
public class AssetSetter {

    GamePanel gp; //game oanel for game window
    GamePanelData gpd; //game panel data

    /**
    * Constructor that accepts the game panel instance and sets the member variable accordingly.
    * @param gp Of GamePanel type, to draw the elements on the screen.
     * @param gpd Of GamePanelData type to access game panel data
    */
    public AssetSetter(GamePanel gp, GamePanelData gpd)
    {
        this.gp = gp;
        this.gpd = gpd;

    }

    /**
     * Sets the coordinates of the objects: rewards and punishments
     * @param obj Of Object Type to set the coordinates of
     * @param x Of int type to set x coordinate
     * @param y Of int type to set y coordinate
     */
    public void placeObject(SuperObject obj, int x, int y)
    {
        obj.worldX = x * gpd.tileSize;
        obj.worldY = y * gpd.tileSize;
    }

    /**
    * Sets the object array of the GamePanel to rewards and punishments. Sets their x and y coordinates on the game
    * screen.
    */
    public void setObject()
    {
        gpd.obj[0] = new OBJ_HTMLTag();
        this.placeObject(gpd.obj[0], 3, 19);

        gpd.obj[1] = new OBJ_CurlyBrackets();
        this.placeObject(gpd.obj[1], 7, 35);

        gpd.obj[2] = new OBJ_Semicolon();
        this.placeObject(gpd.obj[2], 15, 22);

        gpd.obj[3] = new OBJ_HTMLTag();
        this.placeObject(gpd.obj[3], 24, 5);

        gpd.obj[4] = new OBJ_Laptop();
        this.placeObject(gpd.obj[4], 21, 46);

        gpd.obj[5] = new OBJ_InternetTrap();
        this.placeObject(gpd.obj[5], 3, 25);

        gpd.obj[6] = new OBJ_InternetTrap();
        this.placeObject(gpd.obj[6], 47, 29);

        gpd.obj[7] = new OBJ_InternetTrap();
        this.placeObject(gpd.obj[7], 32, 39);

        gpd.obj[8] = new OBJ_CurlyBrackets();
        this.placeObject(gpd.obj[8], 5, 28);

        gpd.obj[9] = new OBJ_Semicolon();
        this.placeObject(gpd.obj[9], 17, 14);

        gpd.obj[10] = new OBJ_CurlyBrackets();
        this.placeObject(gpd.obj[10], 41, 45);

        gpd.obj[11] = new OBJ_Semicolon();
        this.placeObject(gpd.obj[11], 34, 30);

        gpd.obj[12] = new OBJ_HTMLTag();
        this.placeObject(gpd.obj[12], 17, 35);

        gpd.obj[13] = new OBJ_Laptop();
        this.placeObject(gpd.obj[13], 40, 23);

        gpd.obj[14] = new OBJ_End();
        this.placeObject(gpd.obj[14], 48, 48);

    }

    /**
     * Sets the coordinates of the enemies
     * @param enemy Of Enemy Type to set the coordinates of
     * @param x Of int type to set x coordinate
     * @param y Of int type to set y coordinate
     */
    public void placeEnemy(Enemy enemy, int x, int y)
    {
        enemy.worldX = x * gpd.tileSize;
        enemy.worldY = y * gpd.tileSize;
    }

     /**
    * Sets the enemy array of the GamePanel to enemies. Sets their x and y coordinates on the game
    * screen.
    */
    public void setEnemy()
    {
        gpd.enemies[0] = new Enemy(gp,gpd);
        this.placeEnemy(gpd.enemies[0], 3, 45);

        gpd.enemies[1] = new Enemy(gp,gpd);
        this.placeEnemy(gpd.enemies[1], 29, 27);

        gpd.enemies[2] = new Enemy(gp,gpd);
        this.placeEnemy(gpd.enemies[2], 42, 5);

        gpd.enemies[3] = new Enemy(gp,gpd);
        this.placeEnemy(gpd.enemies[3], 12, 18);

        gpd.enemies[4] = new Enemy(gp,gpd);
        this.placeEnemy(gpd.enemies[4], 39, 30);

    }
}
