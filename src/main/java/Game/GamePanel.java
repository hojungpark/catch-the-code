package Game;

import Entity.Enemy;
import Entity.Player;
import MovementLocation.AssetSetter;
import MovementLocation.CollisionChecker;
import MovementLocation.UI;
import Objects.*;
import Tiles.*;

import javax.swing.*;
import java.awt.*;

import static Game.GamePanel.STATE.STARTSCREEN;

/**
* GamePanel is a subclass of the JPanel class and interface Runnable. It handles the all the elements that are to be
* printed onto the screen of the game window. It overrides functions of its superclass to instantiate and draw the 
* elements of the game like the player, enemies, rewards, and punishment. It also starts and handles the game loop
* and thread.
* @author Group 21
*/
public class GamePanel extends JPanel implements Runnable {

    public GamePanelData gpd = new GamePanelData(this); //refactored to have data class for variables

    public StartScreen start; //instance of StartScreen type for play and top nuttons

    public static String situationCheck; //for buttons display

    /**
    * Enumerates the two states of the screen
    */
    public static enum STATE{
        STARTSCREEN, GAME
    };
    public static STATE State = STARTSCREEN; //static variable for state of screem


    /**
    * Sets the various dimensions and specifications of the game window.
    */
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(gpd.screenWidth, gpd.screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(gpd.keyH);
        this.setFocusable(true);
    }

    /**
    * Calls the function responsible for instantiating and initialising the enemies, rewards, and punishments.
    */
    public void setUpGame()
    {
        gpd.aSetter.setObject();
        gpd.aSetter.setEnemy();
    }

    /**
    * Intstantiates and starts the game thread.
    */
    public void startGameThread()
    {
        gpd.gameThread = new Thread(this);
        gpd.gameThread.start();
    }

    /**
    * Overrides the super class method to handle the running of the game. It initialises the game loop variables,
    * and handles the game thread. It continuosly calls the appropriate methods to update the positions and
    * appearances of the elements of the game and then redraw the screen appropriately.
    */
    @Override
    public void run() {

        double drawInterval = 1000000000/gpd.FPS;
        double nextDrawInterval = System.nanoTime() + drawInterval;

        while(gpd.gameThread != null){
            try {
                if(gpd.gamePaused == true) {
                    gpd.pauseAndResume.update();
                }
                else {
                    update();
                }
                repaint();

                double remainingTime = nextDrawInterval - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawInterval += drawInterval;
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
    * Calls the update functions for the player and enemy classes to update their positions of the game window.
    */
    public void update()
    {
        if(State == STATE.GAME) {
            gpd.player.update();
            for (int i = 0; i < gpd.enemies.length; i++) {
                gpd.enemies[i].update();
            }
            gpd.pauseAndResume.update();
            gpd.saveAndRead.update();
        }
    }


    /**
    * Uses Graphics2D class and calls the draw method of the classes to draw them onto the screen. It draws the
    * player, enemies, rewards, punishments, and the UI (time, score, losing, and winning messages) onto the screen.
    * @param g Of type Graphics to draw the elements of the game.
    */
    public void paintComponent(Graphics g)
    {
        this.start = new StartScreen();

        this.addMouseListener(gpd.mouse);

        super.paintComponent(g);

        gpd.g2 = (Graphics2D)g;

        gpd.tileM.draw(gpd.g2);

        for(int i = 0; i < gpd.obj.length; i++)
        {
            if(gpd.obj[i]!=null)
            {
                gpd.obj[i].draw(gpd.g2, this.gpd);
            }
        }

        for(int i = 0; i < gpd.enemies.length; i++)
        {
            if(gpd.enemies[i]!=null)
            {
                gpd.enemies[i].draw(gpd.g2);
            }
        }

        if(State == STATE.GAME) {
            gpd.player.draw(gpd.g2);
            gpd.pauseAndResume.draw(gpd.g2);
            gpd.ui.draw(gpd.g2);
        }else if(State == STARTSCREEN){
            this.start.paintComponent(g, true);

        }
        gpd.saveAndRead.draw(gpd.g2);
        gpd.g2.dispose();
    }

}


