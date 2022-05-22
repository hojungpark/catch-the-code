package Entity;

import Game.GamePanel;
import Game.GamePanelData;
import test.Mods.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class EntityTest {
    static boolean flag = false;

    @BeforeEach
    public static void before(GamePanel gp) {
        while (gp.start == null) {
            System.out.printf("");
        }
        flag = true;
    }

    @Test
    public static void test(GamePanel gp){
        before(gp);
        Entity entity = new Entity(gp, gp.gpd);
        Image i = null;
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "GamePanel", "gp", gp, entity.gp);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "xCoordinate", "worldX",  0, entity.worldX);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "yCoordinate", "worldY",  0, entity.worldY);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "speed", "speed",  0, entity.speed);

        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "up1",  null, entity.up1);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "up2",  null, entity.up2);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "down1",  null, entity.down1);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "down2",  null, entity.down2);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "left1",  null, entity.left1);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "left2",  null, entity.left2);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "right1",  null, entity.right1);
        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Image", "right2",  null, entity.right2);

        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Direction", "direction",  null, entity.right2);

        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "Counter", "spriteCounter",  0, entity.spriteCounter);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "Number", "spriteNum",  1, entity.spriteNum);

        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Rectangle", "solidArea",  new Rectangle(0, 0, 48, 48), entity.solidArea);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "xCoordinate", "solidAreaDefaultX",  0, entity.solidAreaDefaultX);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "yCoordinate", "solidAreaDefaultY",  0, entity.solidAreaDefaultY);
        Tools.AutoTestNums("EntityTest", "Entity", "Init_Variable", "Number", "spriteNum",  1, entity.spriteNum);

        Tools.AutoTestObjs("EntityTest", "Entity", "Init_Variable", "Rectangle", "solidArea",  false, entity.collisionOn);
    }
}
