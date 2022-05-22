package Entity;

import java.awt.*;
import java.util.Objects;

import Game.GamePanel;
import Game.GamePanelData;
import Game.KeyHandler;

/**
* Class to draw, update the position, affect the score, and move the player.
* @author Group 21
*/
public class Player extends Entity{

    KeyHandler keyH; //for key input

    public final int screenX; //screen coordinates
    public final int screenY; //screen coordinates

    int rewards = 9; //to check if all rewards are collected

    /**
    * Constructor sets the values of the member variables of the player and calls methods for the same.
    * @param gp Of GamePanel type to draw and update the player on the screen
    * @param keyH Of KeyHandler type to move the player according to the key inputs
    */
    public Player(GamePanel gp, KeyHandler keyH, GamePanelData gpd)
    {
        super(gp,gpd);
        this.keyH = keyH;

        screenX = gpd.screenWidth/2 - (gpd.tileSize/2);
        screenY = gpd.screenHeight/2 - (gpd.tileSize/2);

        solidArea = new Rectangle(0, 0, gpd.tileSize, gpd.tileSize);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    /**
    * Sets the default values of the player like coordinates, speed, and direction.
    */
    public void setDefaultValues()
    {
        worldX = gpd.tileSize * 1;
        worldY = gpd.tileSize * 1;
        speed = 4;
        direction = "down";
    }

    /**
    * Sets the images of the player (2 each) for up, down, left, and right movements.
    */
    public void getPlayerImage()
    {
            Toolkit toolkit = Toolkit.getDefaultToolkit();

            up1 = toolkit.getImage("src/main/resources/player_up1.png");
            up2 = toolkit.getImage("src/main/resources/player_up2.png");

            down1 = toolkit.getImage("src/main/resources/player_down1.png");
            down2 = toolkit.getImage("src/main/resources/player_down2.png");

            left1 = toolkit.getImage("src/main/resources/player_left1.png");
            left2 = toolkit.getImage("src/main/resources/player_left2.png");

            right1 = toolkit.getImage("src/main/resources/player_right1.png");
            right2 = toolkit.getImage("src/main/resources/player_right2.png");
    }

    /**
    * Updates the direction of the player and calls methods for handling collision with rewards, punishments, and
    * enemies.
    */
    public void update() {
        if (keyH.uPressed || keyH.dPressed || keyH.lPressed || keyH.rPressed) {
            if (keyH.uPressed) {
                direction = "up";
            } else if (keyH.dPressed) {
                direction = "down";
            } else if (keyH.lPressed) {
                direction = "left";
            } else if (keyH.rPressed) {
                direction = "right";
            }

            collisionOn = false;
            gpd.cch.checkTile(this);

            int objIndex = gpd.cch.checkObject(this, true);
            pickUpObject(objIndex);

            int enemyIndex = gpd.cch.checkEnemy(this, true);
            interactEnemy(enemyIndex);

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
    }

    /**
    * Changes the score of the player according to the reward or punishment picked up, and nullifies that object
    * to make it disappear from the screen. Sets the game lost and won variables accordingly.
    * @param i Of integer type to check index of the reward or punishment
    */
    public void pickUpObject(int i)
    {
        boolean check = true;
        if (i!=999) {
            gpd.score += gpd.obj[i].points;

            if (!Objects.equals(gpd.obj[i].name, "InternetTrap") && !Objects.equals(gpd.obj[i].name, "Laptop") && !Objects.equals(gpd.obj[i].name, "End Tile"))
            {
                rewards--;
            }

            else if(Objects.equals(gpd.obj[i].name, "End Tile"))
            {
                if(rewards == 0) {
                    gpd.gameWon = true;

                }
                else
                {
                    check = false;
                }
            }

            if(gpd.score < 0)
            {
                gpd.gameLost = true;
            }

            if(check) {
                gpd.obj[i] = null;
            }
        }
    }

    /**
    * Handles collision with enemy and ends the game
    * @param i Of integer type to check the index of the enemy
    */
    public void interactEnemy(int i)
    {
        if (i!=999)
        {
            gpd.gameLost = true;
        }
    }

    /**
    * Draws the player image on the game screen with the image corresponding to its movement direction
    * @param g2 Of Graohics2D type to draw the images
    */
    public void draw(Graphics2D g2)
    {
        Image image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }
        }

        g2.drawImage(image, screenX, screenY, gpd.tileSize, gpd.tileSize, null);
    }
}
