package Objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_EndTest {
    @Test
    public static void test(){
        OBJ_End cb = new OBJ_End();
        test.Mods.Tools.AutoTestNums("EndTest", "VariablesTest", "End", "Variables", "points", cb.points, 0);
        test.Mods.Tools.AutoTestNums("EndTest", "VariablesTest", "End", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("EndTest", "VariablesTest", "End", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("EndTest", "VariablesTest", "End", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("EndTest", "VariablesTest", "End", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("EndTest", "VariablesTest", "End", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/walk.png");
        test.Mods.Tools.AutoTestObjs("EndTest", "VariablesTest", "End", "Variables", "image", cb.image, image);
        test.Mods.Tools.AutoTestText("EndTest", "VariablesTest", "End", "Variables", "name", cb.name, "End Tile");
        test.Mods.Tools.AutoTestObjs("EndTest", "VariablesTest", "End", "Variables", "collision", cb.collision, true);
    }
}