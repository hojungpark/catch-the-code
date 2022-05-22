package test.Game;

import Game.GamePanel;
import test.Mods.Tools;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class StartScreenTest {
    static boolean flag = false;

    @BeforeEach
    public static void before(GamePanel gp) {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;
    }

    @Test
    public static void test(GamePanel gp) throws InterruptedException {
        before(gp);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "playButton", "x", gp.WIDTH / 2 + 200, gp.start.playButton.x);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "playButton", "y", 280, gp.start.playButton.y);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "playButton", "width", 100, gp.start.playButton.width);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "playButton", "height", 50, gp.start.playButton.height);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "stopButton", "x", gp.WIDTH / 2 + 400, gp.start.stopButton.x);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "stopButton", "y", 280, gp.start.stopButton.y);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "stopButton", "width", 100, gp.start.stopButton.width);
        Tools.AutoTestNums("StartScreenTest", "StartScreen", "start", "stopButton", "height", 50, gp.start.stopButton.height);
        Tools.OutPutOnLine();
        Thread.sleep(1000);
    }

}
