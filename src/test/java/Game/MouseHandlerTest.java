package test.Game;

import Game.GamePanel;
import test.Mods.Tools;
import org.junit.jupiter.api.Test;
import java.awt.event.MouseEvent;

public class MouseHandlerTest {
    @Test
    public static void test(GamePanel gp, boolean flag) throws InterruptedException {
        if (!flag) {
            MouseEvent e = new MouseEvent(gp, 0, System.nanoTime(), 0, 271, 291, 1, false);
            gp.gpd.mouse.mousePressed(e);
            Tools.AutoTestObjs("MouseHandlerTest", "MouseEvent", "Start_Game", "mousePressed", "X", e.getX(), 271);
            Tools.AutoTestObjs("MouseHandlerTest", "MouseEvent", "Start_Game", "mousePressed", "Y", e.getY(), 291);
            Tools.AutoTestObjs("MouseHandlerTest", "MouseEvent", "Start_Game", "State", "GAME", GamePanel.State, GamePanel.STATE.GAME);
            Thread.sleep(1000);
        } else {
            MouseEvent e = new MouseEvent(gp, 0, System.nanoTime(), 0, 454, 307, 1, false);
            Tools.AutoTestObjs("MouseHandlerTest", "MouseEvent", "Exit_Game", "mousePressed", "X", e.getX(), 454);
            Tools.AutoTestObjs("MouseHandlerTest", "MouseEvent", "Exit_Game", "mousePressed", "Y", e.getY(), 307);
            Tools.AutoTestText("MouseHandlerTest", "MouseEvent", "Exit_Game", "gameThread", "getState", gp.gpd.gameThread.getState().name(), "TIMED_WAITING");
            Tools.OutPutOnLine();
            gp.gpd.mouse.mousePressed(e);
        }
        Tools.OutPutOnLine();
    }

}
