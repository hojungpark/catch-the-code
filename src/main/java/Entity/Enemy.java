package Entity;

import java.awt.*;
import java.util.Random;
import Game.GamePanel;
import Game.GamePanelData;

/**
 * Class to create instances of the enemy, move it on the screen, update its coordinates, and draw it on the screen.
 * @author Group 21
 */
public class Enemy extends Entity{

    public int actionLockCounter = 0; //counter variable for actions and handling movement

    /**
     * Constructor that accepts GamePanel and sets member variable accordingly. Sets the other values of the class.
     * @param gp Of GamePanel type to draw enemies on screen
     */
    public Enemy(GamePanel gp, GamePanelData gpd)
    {
        super(gp, gpd);

        direction = "down";
        speed = 2;

        getEnemyImage();
    }

    /**
     * Sets the actions of the enemy at random by setting its direction. Uses the random class for this purpose.
     */
    public void setAction()
    {
        actionLockCounter++;

        if(actionLockCounter == 120)
        {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25)
            {
                direction = "up";
            }

            else if(i <= 50)
            {
                direction = "down";
            }

            else if(i <= 75)
            {
                direction = "left";
            }

            else if(i <= 100)
            {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    /**
     * Updates the coordinates of the enemy accroding to the randomly generated direction and checks its collision
     * with tiles to disallow it.
     */
    public void update()
    {
        setAction();
        collisionOn = false;
        gpd.cch.checkTile(this);

        int ifIndex = gpd.cch.checkPlayer(this, true);
        interactPlayer(ifIndex);


        if (!collisionOn) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }

    /**
     * Handles collision with player from enemy side to set the GamePanel boolean for it to true and end the game.
     * @param i Of integer type to check the index of the enemy
     */
    public void interactPlayer(int i)
    {
        if(i != 999)
        {
            gpd.gameLost = true;
        }
    }


    /**
     * Sets the (two each) up, down, right, and left images of the enemy to affect its moving appearance on screen.
     */
    public void getEnemyImage()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        up1 = toolkit.getImage("src/main/resources/enemy_up.png");

        down1 = toolkit.getImage("src/main/resources/enemy_down.png");

        left1 = toolkit.getImage("src/main/resources/enemy_left.png");

        right1 = toolkit.getImage("src/main/resources/enemy_right.png");
    }

    /**
     * Draws the image of the enemy on the screen according to its location and direction of movement.
     * @param g2 Of Graphics2D type to handle drawing of enemies
     */
    public void draw(Graphics2D g2)
    {

        Image image = null;

        switch(direction)
        {
            case "up" -> {
                if (spriteNum == 1 || spriteNum == 2) {
                    image = up1;
                }
            }
            case "down" -> {
                if (spriteNum == 1 || spriteNum == 2) {
                    image = down1;
                }
            }
            case "left" -> {
                if (spriteNum == 1 || spriteNum == 2) {
                    image = left1;
                }

            }
            case "right" -> {
                if (spriteNum == 1 || spriteNum == 2) {
                    image = right1;
                }
            }
        }


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
