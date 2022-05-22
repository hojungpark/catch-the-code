package MovementLocation;

import Game.GamePanel;
import test.Mods.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class UITest {
    static boolean flag = false;

    @BeforeEach
    public static void before(GamePanel gp)
    {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;
    }

    @Test
    public static void test(GamePanel gp){
        before(gp);
        UI ui = new UI(gp, gp.gpd);

        Tools.AutoTestObjs("UITest", "UI", "Init_Object", "GamePanel", "gp", ui.gp, gp);
        Tools.AutoTestObjs("UITest", "UI", "Init_Object", "Font", "myFont", new Font("Cooper Black", Font.BOLD, 25), ui.timeScoreFont);
        Tools.AutoTestObjs("UITest", "UI", "Init_Object", "Font", "msgFont", new Font("Castellar", Font.PLAIN, 60), ui.msgFont);

        ui.gp.gpd.gameWon = true;
        ui.gp.gpd.gameThread = null;
        Tools.AutoTestObjs("UITest", "UI", "gameStatus", "WonStatus", "gameWon", true, ui.gp.gpd.gameWon);
        Tools.AutoTestObjs("UITest", "UI", "threadStatus", "WonStatus", "gameThread", null, ui.gp.gpd.gameThread);

        ui.gp.gpd.gameLost = true;
        Tools.AutoTestObjs("UITest", "UI", "gameStatus", "LostStatus", "gameWon", true, ui.gp.gpd.gameLost);
        Tools.AutoTestObjs("UITest", "UI", "threadStatus", "LostStatus", "gameThread", null, ui.gp.gpd.gameThread);
    }
}
