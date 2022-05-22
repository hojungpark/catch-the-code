package test.Game;

import Game.GamePanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Mods.Tools;

import java.awt.event.KeyEvent;


public class KeyHandlerTest{

    static boolean flag = false;

    @BeforeEach
    public static void BeforeTests(GamePanel gp)
    {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;
    }

   @Test
    public static void test(GamePanel gp) {
       BeforeTests(gp);
       KeyEvent e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_UP);
       gp.gpd.keyH.keyPressed(e);
       Tools.AutoTestObjs("KeyHandlerTest", "UpKeyTest", "KeyInput", "Keys", "up", gp.gpd.keyH.uPressed, true);
       gp.gpd.keyH.keyReleased(e);
       Tools.AutoTestObjs("KeyHandlerTest", "UpKeyTest", "KeyInput", "Keys", "up", gp.gpd.keyH.uPressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_DOWN);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "DownKeyTest", "KeyInput", "Keys", "down", gp.gpd.keyH.dPressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "DownKeyTest", "KeyInput", "Keys", "down", gp.gpd.keyH.dPressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_RIGHT);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "RightKeyTest", "KeyInput", "Keys", "right", gp.gpd.keyH.rPressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "RightKeyTest", "KeyInput", "Keys", "right", gp.gpd.keyH.rPressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_LEFT);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "LeftKeyTest", "KeyInput", "Keys", "left", gp.gpd.keyH.lPressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "LeftKeyTest", "KeyInput", "Keys", "left", gp.gpd.keyH.lPressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_P);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "PauseTest", "KeyInput", "Keys", "pause", gp.gpd.keyH.pausePressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "PauseTest", "KeyInput", "Keys", "up", gp.gpd.keyH.pausePressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_R);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "ResumeTest", "KeyInput", "Keys", "resume", gp.gpd.keyH.resumePressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "ResumeTest", "KeyInput", "Keys", "resume", gp.gpd.keyH.resumePressed, false);

        e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_S);
        gp.gpd.keyH.keyPressed(e);
        Tools.AutoTestObjs("KeyHandlerTest", "SaveTest", "KeyInput", "Keys", "save", gp.gpd.keyH.savePressed, true);
        gp.gpd.keyH.keyReleased(e);
        Tools.AutoTestObjs("KeyHandlerTest", "SaveTest", "KeyInput", "Keys", "save", gp.gpd.keyH.savePressed, false);
    }

}

