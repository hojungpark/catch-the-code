package SaveTest;

import Game.GamePanel;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class SaveAndReadTest {
    @Test
    public static void test(GamePanel gp) throws InterruptedException {
        KeyEvent e = new KeyEvent(gp, KeyEvent.KEY_PRESSED, System.nanoTime(), 0, KeyEvent.VK_S);
        gp.gpd.keyH.keyPressed(e);
        test.Mods.Tools.AutoTestObjs("GamePanel", "MouseEvent", "Save_Game", "KeyPressed", "getKeyCode()", e.getKeyCode(), KeyEvent.VK_S);
        test.Mods.Tools.AutoTestObjs("GamePanel", "MouseEvent", "Save_Game", "SavePressed", "keyH", gp.gpd.keyH.savePressed, true);
        Thread.sleep(1000);
    }
}
