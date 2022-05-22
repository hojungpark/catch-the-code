package test.MovementLocation;

import Entity.*;
import Game.GamePanel;
import Objects.OBJ_CurlyBrackets;
import Objects.OBJ_InternetTrap;
import Tiles.TileManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Mods.Tools;
import test.Mods.Tools;

public class CollisionCheckerTest {

    static Entity e;
    static boolean flag = false;

    @BeforeEach
    public static void BeforeTests(GamePanel gp) {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;
    }

    @Test
    public static void test(GamePanel gp) throws InterruptedException {
        BeforeTests(gp);
        TileManager tm = new TileManager(gp, gp.gpd);

        e = new Player(gp,gp.gpd.keyH, gp.gpd);

        tm.mapTileNum[0][0] = 0;
        e.worldX = 0;
        e.worldY = 0;

        gp.gpd.cch.checkTile(e);

        Tools.AutoTestObjs("CollisionCheckerTest", "checkTile", "Collision", "Wall", "collision", e.collisionOn, true);

        gp.gpd.obj[0] = new OBJ_CurlyBrackets();

        gp.gpd.obj[0].worldX = 9;
        gp.gpd.obj[0].worldY = 9;

        e.worldX = gp.gpd.obj[0].worldX;
        e.worldY = gp.gpd.obj[0].worldY;

        Tools.AutoTestNums("CollisionCheckerTest", "checkObject", "Collision", "Reward", "collision", gp.gpd.cch.checkObject(e, true), 0);
        Tools.AutoTestObjs("CollisionCheckerTest", "checkObject", "Collision", "Reward", "collision", e.collisionOn, true);

        gp.gpd.obj[0] = new OBJ_InternetTrap();

        gp.gpd.obj[0].worldX = 8;
        gp.gpd.obj[0].worldY = 8;

        e.worldX = gp.gpd.obj[0].worldX;
        e.worldY = gp.gpd.obj[0].worldY;

        Tools.AutoTestNums("CollisionCheckerTest", "checkObject", "Collision", "Punishment", "collision", gp.gpd.cch.checkObject(e, true), 0);
        Tools.AutoTestObjs("CollisionCheckerTest", "checkObject", "Collision", "Punishment", "collision", e.collisionOn, true);
        ;

        gp.gpd.enemies[0] = new Enemy(gp, gp.gpd);

        gp.gpd.enemies[0].worldX = 10;
        gp.gpd.enemies[0].worldY = 10;
        gp.gpd.enemies[0].collisionOn = true;

        e.worldX = gp.gpd.enemies[0].worldX;
        e.worldY = gp.gpd.enemies[0].worldY;

        Tools.AutoTestNums("CollisionCheckerTest", "checkEnemy", "Collision", "Enemy", "collision", gp.gpd.cch.checkEnemy(e, true), 0);
        Tools.AutoTestObjs("CollisionCheckerTest", "checkEnemy", "Collision", "Enemy", "collision", e.collisionOn, true);

        gp.gpd.enemies[0] = new Enemy(gp, gp.gpd);
        gp.gpd.enemies[0].collisionOn = true;
        gp.gpd.enemies[0].worldX = 7;
        gp.gpd.enemies[0].worldY = 7;

        e.worldX = gp.gpd.enemies[0].worldX;
        e.worldY = gp.gpd.enemies[0].worldY;
        e.collisionOn = true;

        Tools.AutoTestObjs("CollisionCheckerTest", "checkPlayer", "Collision", "Player", "collision", e.collisionOn, true);
    }
}
