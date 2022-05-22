package MovementLocation;

import Game.GamePanel;
import Entity.*;
import Objects.*;
import Game.GamePanelData;

/**
* Class to for collision detection among various objects of the game and their appropriate consequences.
* @author Group 21
*/
public class CollisionChecker {

    GamePanel gp; //game panel for game window
    GamePanelData gpd; //game panel data

    /**
    * Constructor that accepst the game panel and sets member variable accordingly.
    * @param gp Of GamePanel type to check the collision between objects and entities on the game screen
     * @param gpd Of GamePanelData type to access game panel data
    */
    public CollisionChecker(GamePanel gp, GamePanelData gpd)
    {
        this.gp = gp;
        this.gpd = gpd;
    }

    //refactored to have nested class for data variables
   public class checkTileData
   {
       Entity e;
       public checkTileData(Entity e)
       {
          this.e = e;

           entityLeftWorldX = e.worldX + e.solidArea.x;
           entityRightWorldX = e.worldX + e.solidArea.x + e.solidArea.width;
           entityTopWorldY = e.worldY + e.solidArea.y;
           entityBottomWorldY = e.worldY + e.solidArea.y + e.solidArea.height;

           entityLeftCol = entityLeftWorldX/gpd.tileSize;
           entityRightCol = entityRightWorldX/gpd.tileSize;
           entityTopRow = entityTopWorldY/gpd.tileSize;
           entityBottomRow = entityBottomWorldY/gpd.tileSize;
       }

       int entityLeftWorldX;
       int entityRightWorldX;
       int entityTopWorldY;
       int entityBottomWorldY;

       int entityLeftCol;
       int entityRightCol;
       int entityTopRow;
       int entityBottomRow;
   }

    /** Checks collision between the entities and Tiles and disallows them to cross the barriers/
    * @param e Of Entity type to accept player and enemy instances and check them with barrier/wall tiles
    */
    public void checkTile(Entity e)
    {
        checkTileData tileData = new checkTileData(e);

        int tileNum1 = 0, tileNum2 = 0;

        switch (e.direction) {
            case "up" -> {
                tileData.entityTopRow = (tileData.entityTopWorldY - e.speed) / gpd.tileSize;
                tileNum1 = gpd.tileM.mapTileNum[tileData.entityLeftCol][tileData.entityTopRow];
                tileNum2 = gpd.tileM.mapTileNum[tileData.entityRightCol][tileData.entityTopRow];
            }
            case "down" -> {
                tileData.entityBottomRow = (tileData.entityBottomWorldY + e.speed) / gpd.tileSize;
                tileNum1 = gpd.tileM.mapTileNum[tileData.entityLeftCol][tileData.entityBottomRow];
                tileNum2 = gpd.tileM.mapTileNum[tileData.entityRightCol][tileData.entityBottomRow];
            }
            case "left" -> {
                tileData.entityLeftCol = (tileData.entityLeftWorldX - e.speed) / gpd.tileSize;
                tileNum1 = gpd.tileM.mapTileNum[tileData.entityLeftCol][tileData.entityTopRow];
                tileNum2 = gpd.tileM.mapTileNum[tileData.entityLeftCol][tileData.entityBottomRow];
            }
            case "right" -> {
                tileData.entityRightCol = (tileData.entityRightWorldX + e.speed) / gpd.tileSize;
                tileNum1 = gpd.tileM.mapTileNum[tileData.entityRightCol][tileData.entityTopRow];
                tileNum2 = gpd.tileM.mapTileNum[tileData.entityRightCol][tileData.entityBottomRow];
            }
        }


            if (gpd.tileM.tile[tileNum1].collision || gpd.tileM.tile[tileNum2].collision) {
                e.collisionOn = true;
            }
    }

    /**
     * Sets the solid area of the entity in order to check for collision in the methods that follow
     * @param e Of Entity type to set its solid area according to movement
     */
    public void setSolidArea(Entity e)
    {
        switch (e.direction) {
            case "up" -> e.solidArea.y -= e.speed;
            case "down" -> e.solidArea.y += e.speed;
            case "left" -> e.solidArea.x -= e.speed;
            case "right" -> e.solidArea.x += e.speed;
        }
    }

    /**
     * Sets the boolean variable of the Entity by checking the intersection for collision
     * @param e Of Entity type to set collision variable
     * @param collidedAgainst Of SuperObject type to check the other thing collided with
     * @return boolean variable: true if intersects or false otherwise
     */
    public boolean setVariablesObject(Entity e, SuperObject collidedAgainst)
    {
        if (e.solidArea.intersects(collidedAgainst.solidArea)) {
            if (collidedAgainst.collision) {
                e.collisionOn = true;
            }

            return true;
        }

        return false;
    }

    /**
     * Sets the boolean variable of the Entity by checking the intersection for collision
     * @param e Of Entity type to set collision variable
     * @param collidedAgainst Of Entity type to check the other thing collided with
     * @return boolean variable: true if intersects or false otherwise
     */
    public boolean setVariablesEntity(Entity e, Entity collidedAgainst)
    {
        if (e.solidArea.intersects(collidedAgainst.solidArea)) {
            if (collidedAgainst.collisionOn) {
                e.collisionOn = true;
            }

           return true;
        }

        return false;
    }
    /**
    * Checks collision between objects (rewards and punishments) and the players, and returns index to increase
    * or decrease points accordingly.\
    * @param e Of Entity type to accept the player to be checked with reward and punishment
    * @param player Of boolean type to check if that entity is a player 
    * @return the index of the reward or punishment to affect the score accordingly
    */
     public int checkObject(Entity e, boolean player) {
        int index = 999;

        for (int i = 0; i < gpd.obj.length; i++) {
            if (gpd.obj[i] != null) {
                e.solidArea.x = e.worldX + e.solidArea.x;
                e.solidArea.y = e.worldY + e.solidArea.y;

                gpd.obj[i].solidArea.x = gpd.obj[i].worldX + gpd.obj[i].solidArea.x;
                gpd.obj[i].solidArea.y = gpd.obj[i].worldY + gpd.obj[i].solidArea.y;

                this.setSolidArea(e);

                if (this.setVariablesObject(e,gpd.obj[i]))
                {
                    if (player) {
                        index = i;
                    }
                }

                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;

                gpd.obj[i].solidArea.x = gpd.obj[i].solidAreaDefaultX;
                gpd.obj[i].solidArea.y = gpd.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }

     /**
    * Checks collision of enemies and players by their coordinates and end the game.
    * @param e Of Entity type to accept the player
    * @param player Of boolean type to check if the entity is a player
    * @return the index of the enemy that makes the player lose
    */
     //refactored if cases
    public int checkEnemy(Entity e, boolean player) {
        int index = 999;

        for (int i = 0; i < gpd.enemies.length; i++) {
            if (gpd.enemies[i] != null) {
                e.solidArea.x = e.worldX + e.solidArea.x;
                e.solidArea.y = e.worldY + e.solidArea.y;

                gpd.enemies[i].solidArea.x = gpd.enemies[i].worldX + gpd.enemies[i].solidArea.x;
                gpd.enemies[i].solidArea.y = gpd.enemies[i].worldY + gpd.enemies[i].solidArea.y;

                this.setSolidArea(e);

                if (this.setVariablesEntity(e,gpd.enemies[i]) && player) {
                        index = i;
                }

                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;

                gpd.enemies[i].solidArea.x = gpd.enemies[i].solidAreaDefaultX;
                gpd.enemies[i].solidArea.y = gpd.enemies[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    //refactored if cases
    public int checkPlayer(Entity e, boolean enemy) {
        int index = 999;

            if (gpd.player != null) {
                e.solidArea.x = e.worldX + e.solidArea.x;
                e.solidArea.y = e.worldY + e.solidArea.y;

                gpd.player.solidArea.x = gpd.player.worldX + gpd.player.solidArea.x;
                gpd.player.solidArea.y = gpd.player.worldY + gpd.player.solidArea.y;

                this.setSolidArea(e);

                if (this.setVariablesEntity(e, gpd.player) && enemy){
                        index = 0;
                }

                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;

                gpd.player.solidArea.x = gpd.player.solidAreaDefaultX;
                gpd.player.solidArea.y = gpd.player.solidAreaDefaultY;
            }

        return index;
    }
}
