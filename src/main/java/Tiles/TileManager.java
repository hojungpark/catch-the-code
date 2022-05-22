package Tiles;

import java.awt.*;
import java.io.File;
import java.util.Scanner;
import Game.GamePanel;
import Game.GamePanelData;

/**
* TileManager class to handle drawing the tiles on the screen according the map designed in MapData.txt
* @author Group 21
*/
public class TileManager {

    GamePanel gp; //game panel for window
    GamePanelData gpd; //game panel data
    public Tile[] tile; //tile array 

    public int mapTileNum[][]; //mao array

    /**
    * Constructor to set variables of the tiles
    * @param gp Of GamePanel type to draw on screen
     * @param gpd Of GamePanelData type to access game panel data
    */
    public TileManager(GamePanel gp, GamePanelData gpd)
    {
        this.gp = gp;
        this.gpd = gpd;
        tile = new Tile[10];

        mapTileNum = new int[gpd.maxWorldCol][gpd.maxWorldRow];

        getTileImage();
        loadMap("src/main/resources/MapData.txt");
    }

    /**
    * Sets the image of the tiles: walls and paths
    */
    public void getTileImage()
    {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        tile[0] = new Tile();
        tile[0].image = toolkit.getImage("src/main/resources/binary.png");
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].image = toolkit.getImage("src/main/resources/walk.png");

    }

    /**
    * Makes use of the map data by reading it via filestream and sets the tiles on the screen accordingly.
    * @param filepath Of String type to accept the mapdata file which could be changed easily
    */
    public void loadMap(String filepath)
    {
        try
        {
            File data = new File(filepath);

            Scanner myReader = new Scanner(data);

            int col = 0;
            int row = 0;

            while(col < gpd.maxWorldCol && row < gpd.maxWorldRow)
            {
                String line = myReader.nextLine();

                while(col < gpd.maxWorldCol)
                {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gpd.maxWorldCol)
                {
                    col = 0;
                    row++;
                }

            }
        }

        catch(Exception ignored)
        {

        }
    }

    /**
    * Draws the tiles on the screen
    * @param g2 Of Graphics2D type to draw the tiles
    */
    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gpd.maxWorldCol && worldRow < gpd.maxWorldRow)
        {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gpd.tileSize;
            int worldY = worldRow * gpd.tileSize;

            int screenX = worldX - gpd.player.worldX + gpd.player.screenX;
            int screenY = worldY - gpd.player.worldY + gpd.player.screenY;

            if(worldX + gpd.tileSize > gpd.player.worldX - gpd.player.screenX &&
               worldX - gpd.tileSize < gpd.player.worldX + gpd.player.screenX &&
               worldY + gpd.tileSize > gpd.player.worldY - gpd.player.screenY &&
               worldY - gpd.tileSize < gpd.player.worldY + gpd.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gpd.tileSize, gpd.tileSize, null);
            }

            worldCol++;

            if(worldCol == gpd.maxWorldCol)
            {
                worldCol = 0;

                worldRow++;
            }
        }
    }
}
