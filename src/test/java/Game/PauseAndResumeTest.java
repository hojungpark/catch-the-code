package test.Game;

import Game.GamePanel;
import test.Mods.Tools;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

public class PauseAndResumeTest {
    @Test
    public static void test(GamePanel gp, boolean flag) throws InterruptedException {
        if(flag){
            KeyEvent e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_P);
            gp.gpd.keyH.keyPressed(e);
            Tools.AutoTestObjs("GamePanel", "MouseEvent", "Pause_Game", "KeyPressed", "getKeyCode()", e.getKeyCode(), KeyEvent.VK_P);
            Tools.AutoTestObjs("GamePanel", "MouseEvent", "Pause_Game", "pausePressed", "keyH", gp.gpd.keyH.pausePressed, true);
            Thread.sleep(1000);
        }
        else {
            KeyEvent q = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_R);
            gp.gpd.keyH.keyPressed(q);
            Tools.AutoTestObjs("GamePanel", "MouseEvent", "Pause_Game", "KeyPressed", "getKeyCode()", q.getKeyCode(), KeyEvent.VK_R);
            Tools.AutoTestObjs("GamePanel", "MouseEvent", "Pause_Game", "resumePressed", "keyH", gp.gpd.keyH.resumePressed, true);
            Thread.sleep(1000);
            Tools.OutPutOnLine();
        }
    }

}
