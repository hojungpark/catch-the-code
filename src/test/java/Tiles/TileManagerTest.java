package test.Tiles;

import Game.GamePanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Mods.Tools;

import java.awt.*;

public class TileManagerTest{

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
    public static void test(GamePanel gp)
    {
        BeforeTests(gp);
        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.tile.length, 10);
        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.mapTileNum.length, gp.gpd.maxWorldCol);
        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.mapTileNum[0].length, gp.gpd.maxWorldRow);

        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.tile[0].collision, true);
        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.tile[0].collision, true);
        Tools.AutoTestObjs("TileManagerTest", "Variables", "tilesManager", "Tile", "tilevars", gp.gpd.tileM.tile[1].collision, false);

    }
}
