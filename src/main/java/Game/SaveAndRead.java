package Game;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
* Class to display and act when save and read options are selected
* @author Group 21
*/
public class SaveAndRead {
    KeyHandler keyH; //key input
    GamePanel gp; //game screen
    GamePanelData gpd; //game panel data
    public String state; // state : save
    Font saveFont = new Font("Castellar", Font.PLAIN, 60); //save message font

    /**
     * Sets the default values of the member variables and calls the image setting function
     *
     * @param gp   Of GamePanel type to draw buttons on screen
     * @param keyH Of KeyHandler type to handle key input
     */
    public SaveAndRead(GamePanel gp, KeyHandler keyH, GamePanelData gpd) {
        this.gp = gp;
        this.gpd = gpd;
        this.keyH = keyH;
        state = "save";
    }

    /**
     * Updates the game state according to the key input
     */
    public void update() {
        if (keyH.savePressed) {
            state = "save";
            gpd.gameSaved = true;
        }
    }


    /**
     * Draws the icon and save message on the screen and handles pausing the game when save id pressed
     *
     * @param g2 Of Graphics2D type to draw the icon and message
     */
    public void draw(Graphics2D g2) {

        if (gpd.gameSaved) {
            gpd.gamePaused = true;
            g2.setFont(saveFont);
            g2.setColor(Color.white);
            String saveMsg = "SAVED";
            int saveLength = (int) g2.getFontMetrics().getStringBounds(saveMsg, g2).getWidth();
            g2.drawString(saveMsg, gpd.screenWidth / 2 - saveLength / 2, gpd.screenHeight / 2 + gpd.tileSize / 2);
            gp.start.paintComponent((Graphics) g2, false);
            saveGame();
        }

    }

    /**
     * Uses file writer to create a SavedGame text file to write the game data: score, time, and player coordinates
     */
    public void saveGame() {

        try {
            FileWriter gameSave = new FileWriter("src/main/java/Saves/SavedGame.txt");
            gameSave.write("GAME SAVED \nSCORE: " + gpd.score + "\nTIME" + gpd.ui.playTime
                    + "\n PLAYER COORDINATES : (" + gpd.player.worldX + "," + gpd.player.worldY + ") \n"
                    + "REWARDS AND PUNISHMENTS LEFT:");
            if(createTxtFile("SavedGame.txt")) {
                for (int i = 0; i < gpd.obj.length; i++) {
                    if (gpd.obj[i] != null) {
                        gameSave.write(gpd.obj[i].name + " Coordinates: (" +
                                gpd.obj[i].worldX + "," + gpd.obj[i].worldY + ")\n");
                    }
                }
                gameSave.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean createTxtFile(String name) throws IOException {
        boolean flag = false;
        String filenameTemp;
        filenameTemp = "src/main/java/Saves/SavedGame.txt";
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
            flag = true;
        }
        return flag;
    }
}





