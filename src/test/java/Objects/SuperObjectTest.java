package Objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SuperObjectTest {
    @Test
    public static void test(){
        var cb = new SuperObject();
        test.Mods.Tools.AutoTestNums("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "points", cb.points, 0);
        test.Mods.Tools.AutoTestNums("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        test.Mods.Tools.AutoTestObjs("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "image", cb.image, null);
        test.Mods.Tools.AutoTestText("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "name", cb.name, null);
        test.Mods.Tools.AutoTestObjs("SuperObjectTest", "VariablesTest", "SuperObject", "Variables", "collision", cb.collision, false);
    }

}