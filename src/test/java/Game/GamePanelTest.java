package Game;

import Game.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import test.Mods.Tools;

import java.awt.*;

public class GamePanelTest{

    static boolean flag = false;

    @BeforeEach
    public static void BeforeTest(GamePanel gp)
    {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;

    }

    @Test
    public static void test(GamePanel gp)
    {
        BeforeTest(gp);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "ogTileSize", gp.gpd.originalTileSize, 16);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "scaleFactor", gp.gpd.scale, 3);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "TileSize", gp.gpd.tileSize, 48);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "ScreenCol", gp.gpd.maxScreenCol, 16);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "ScreenRow", gp.gpd.maxScreenRow, 12);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "ScreenHeight", gp.gpd.screenHeight, 576);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "ScreenWidth", gp.gpd.screenWidth, 768);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "WorldCol", gp.gpd.maxWorldCol, 50);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "WorldRow", gp.gpd.maxWorldRow, 50);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "FramesPerSecond", gp.gpd.FPS, 60);
        Tools.AutoTestNums("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "Score", gp.gpd.score, 0);

        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "paused", gp.gpd.gamePaused, false);
        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "saved", gp.gpd.gameSaved, false);
        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "lost", gp.gpd.gameWon, false);
        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "won", gp.gpd.gameLost, false);

        Dimension d = new Dimension(768,576);
        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "size", gp.getPreferredSize(), d);
        Tools.AutoTestObjs("GamePanelTest", "VariablesTest", "GamePanel", "Variables", "background", gp.getBackground(), Color.darkGray);

    }


}
