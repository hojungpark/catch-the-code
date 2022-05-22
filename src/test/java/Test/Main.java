package Test;

import Entity.EnemyTest;
import Entity.EntityTest;
import Entity.Player;
import Entity.PlayerTest;
import Game.GamePanel;
import Game.GamePanelTest;
import Game.SaveAndRead;
import MovementLocation.UITest;
import Objects.*;
import SaveTest.SaveAndReadTest;
import test.Game.PauseAndResumeTest;
import test.MovementLocation.AssetSetterTest;
import test.MovementLocation.CollisionCheckerTest;
import test.Tiles.TileManagerTest;
import test.Game.KeyHandlerTest;
import test.Game.MouseHandlerTest;
import test.Game.StartScreenTest;
import test.Mods.Tools;

import javax.swing.*;

public class Main {
    static GamePanel gp;

    public static void prepare() {
        gp = new GamePanel();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Catch the Code");
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.setUpGame();
        gp.startGameThread();

    }

    public static void main(String[] args) throws InterruptedException{
        prepare();
        Tools.AutoTestMenu();
        GamePanelTest.test(gp);
        Tools.AutoTestMenu();
        KeyHandlerTest.test(gp);
        Tools.AutoTestMenu();
        TileManagerTest.test(gp);
        Tools.AutoTestMenu();
        StartScreenTest.test(gp);
        Tools.AutoTestMenu();
        AssetSetterTest.test(gp);
        Tools.AutoTestMenu();
        MouseHandlerTest.test(gp, false);
        Tools.AutoTestMenu();
        PauseAndResumeTest.test(gp,true);
        Tools.AutoTestMenu();
        PauseAndResumeTest.test(gp,false);
        Tools.AutoTestMenu();
        PauseAndResumeTest.test(gp,true);
        Tools.AutoTestMenu();
        MouseHandlerTest.test(gp, true);

        SuperObjectTest.test();
        OBJ_SemicolonTest.test();
        OBJ_LaptopTest.test();
        OBJ_InternetTrapTest.test();
        OBJ_HTMLTagTest.test();
        OBJ_EndTest.test();
        OBJ_CurlyBracketsTest.test();

        Tools.AutoTestMenu();
        EntityTest.test(gp);

        Tools.AutoTestMenu();
        EnemyTest.test(gp);
        Tools.AutoTestMenu();
        PlayerTest.test(gp);
        Tools.AutoTestMenu();
        UITest.test(gp);
        Tools.AutoTestMenu();
        CollisionCheckerTest.test(gp);
        Tools.AutoTestMenu();
        SaveAndReadTest.test(gp);

        System.exit(0);
    }
}
