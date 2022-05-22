package test.MovementLocation;

import Game.GamePanel;
import test.Mods.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssetSetterTest {
    static boolean flag = false;

    @BeforeEach
    public static void before(GamePanel gp) {
        while (gp.gpd.obj == null) {
            for (int i = 0; i < 14; i++)
                while (gp.gpd.obj[i] == null)
                    System.out.print("");
            for (int i = 0; i < 5; i++)
                while (gp.gpd.enemies[i] == null)
                    System.out.print("");
        }
        flag = true;
    }

    @Test
    public static void test(GamePanel gp) throws InterruptedException {
        before(gp);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(0), "world", "X", gp.gpd.obj[0].worldX, 3 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(0), "world", "Y", gp.gpd.obj[0].worldY, 19 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(1), "world", "X", gp.gpd.obj[1].worldX, 7 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(1), "world", "Y", gp.gpd.obj[1].worldY, 35 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(2), "world", "X", gp.gpd.obj[2].worldX, 15 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(2), "world", "Y", gp.gpd.obj[2].worldY, 22 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(3), "world", "X", gp.gpd.obj[3].worldX, 24 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(3), "world", "Y", gp.gpd.obj[3].worldY, 5 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(4), "world", "X", gp.gpd.obj[4].worldX, 21 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(4), "world", "Y", gp.gpd.obj[4].worldY, 46 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(5), "world", "X", gp.gpd.obj[5].worldX, 3 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(5), "world", "Y", gp.gpd.obj[5].worldY, 25 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(6), "world", "X", gp.gpd.obj[6].worldX, 47 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(6), "world", "Y", gp.gpd.obj[6].worldY, 29 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(7), "world", "X", gp.gpd.obj[7].worldX, 32 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(7), "world", "Y", gp.gpd.obj[7].worldY, 39 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(8), "world", "X", gp.gpd.obj[8].worldX, 5 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(8), "world", "Y", gp.gpd.obj[8].worldY, 28 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(9), "world", "X", gp.gpd.obj[9].worldX, 17 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(9), "world", "Y", gp.gpd.obj[9].worldY, 14 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(10), "world", "X", gp.gpd.obj[10].worldX, 41 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(10), "world", "Y", gp.gpd.obj[10].worldY, 45 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(11), "world", "X", gp.gpd.obj[11].worldX, 34 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(11), "world", "Y", gp.gpd.obj[11].worldY, 30 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(12), "world", "X", gp.gpd.obj[12].worldX, 17 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(12), "world", "Y", gp.gpd.obj[12].worldY, 35 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(13), "world", "X", gp.gpd.obj[13].worldX, 40 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(13), "world", "Y", gp.gpd.obj[13].worldY, 23 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(14), "world", "X", gp.gpd.obj[14].worldX, 48 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "OBJ_HTMLTag", "obj" + String.valueOf(14), "world", "Y", gp.gpd.obj[14].worldY, 48 * gp.gpd.tileSize);
        Tools.OutPutOnLine();
        Thread.sleep(1000);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(0), "world", "X", gp.gpd.enemies[0].worldX, 3 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(0), "world", "Y", gp.gpd.enemies[0].worldY, 45 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(1), "world", "X", gp.gpd.enemies[1].worldX, 29 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(1), "world", "Y", gp.gpd.enemies[1].worldY, 27 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(2), "world", "X", gp.gpd.enemies[2].worldX, 42 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(2), "world", "Y", gp.gpd.enemies[2].worldY, 5 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(3), "world", "X", gp.gpd.enemies[3].worldX, 12 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(3), "world", "Y", gp.gpd.enemies[3].worldY, 18 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(4), "world", "X", gp.gpd.enemies[4].worldX, 39 * gp.gpd.tileSize);
        Tools.AutoTestNums("AssetSetterTest", "enemies", "Enemy" + String.valueOf(4), "world", "Y", gp.gpd.enemies[4].worldY, 30 * gp.gpd.tileSize);
        Tools.OutPutOnLine();
        Thread.sleep(1000);
    }

}
