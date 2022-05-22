package Game;

import Entity.Enemy;
import Entity.Player;
import MovementLocation.AssetSetter;
import MovementLocation.CollisionChecker;
import MovementLocation.UI;
import Objects.SuperObject;
import Tiles.TileManager;

import java.awt.*;

public class GamePanelData {

    public GamePanel gp;

    /**
     * Constructor of data class to avoid data clump to set variables of the game panel
     * @param gp Of GamePanel to have variables
     */
    public GamePanelData(GamePanel gp)
    {
        this.gp = gp;
        setVariables();
    }

    public void setVariables()
    {
        originalTileSize = 16; //tiles for path and barriers
        scale = 3; //scale factor

        tileSize = originalTileSize * scale; //new tile size for the screen

        maxScreenCol = 16; //rows number
        maxScreenRow = 12; //cols number

        screenWidth = tileSize * maxScreenCol; //width of screen
        screenHeight = tileSize * maxScreenRow; //height of screen

        maxWorldCol = 50; //world col number
        maxWorldRow = 50; //world row number

        //refactored to delete unused variables

        FPS = 60; //frames per second

        score = 0; //score of player

        tileM = new TileManager(this.gp,this); //Tile Manager to handle location and drawing of tiles on screen

        keyH = new KeyHandler(); //key input
        mouse = new MouseHandler(); //key input

        cch = new CollisionChecker(this.gp, this); //for collision detection
        aSetter = new AssetSetter(this.gp, this); //setting the elements of the game

        player = new Player(this.gp, keyH, this); //player instance

        ui = new UI(this.gp, this); //user interface class for time, score, winning, and losing messages
        obj = new SuperObject[15]; //object array for all elements
        enemies = new Enemy[5]; //enemies array
        pauseAndResume = new PauseAndResume(this.gp, keyH, this); //pause and play buttons
        saveAndRead = new SaveAndRead(this.gp, keyH, this); //save and read options

        gameLost = false; //for lost message
        gameWon = false; //for winning message
        gamePaused = false; // for pausing
        gameSaved = false; // for saving
    }

    public int originalTileSize;//tiles for path and barriers
    public int scale; //scale factor

    public int tileSize; //new tile size for the screen

    public int maxScreenCol; //rows number
    public int maxScreenRow; //cols number

    public int screenWidth; //width of screen
    public int screenHeight; //height of screen

    public int maxWorldCol; //world col number
    public int maxWorldRow ; //world row number

    public int FPS; //frames per second

    public int score; //score of player

    public Thread gameThread; //game thread for game loop

    public TileManager tileM; //Tile Manager to handle location and drawing of tiles on screen

    public KeyHandler keyH; //key input
    public MouseHandler mouse; //key input

    public CollisionChecker cch; //for collision detection
    public AssetSetter aSetter; //setting the elements of the game

    public Player player; //player instance

    public UI ui; //user interface class for time, score, winning, and losing messages
    public SuperObject[] obj; //object array for all elements
    public Enemy[] enemies; //enemies array
    public PauseAndResume pauseAndResume; //pause and play buttons
    public SaveAndRead saveAndRead; //save and read options

    public boolean gameLost; //for lost message
    public boolean gameWon; //for winning message
    public boolean gamePaused; // for pausing
    public boolean gameSaved; // for saving

    public Graphics2D g2; //to draw elements on the screen
}
