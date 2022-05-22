package Objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_InternetTrapTest {
    @Test
    public static void test(){
        OBJ_InternetTrap cb = new OBJ_InternetTrap();
        test.Mods.Tools.AutoTestNums("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "points", cb.points, -20);
        test.Mods.Tools.AutoTestNums("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/InternetTrap.png");
        test.Mods.Tools.AutoTestObjs("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "image", cb.image, image);
        test.Mods.Tools.AutoTestText("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "name", cb.name, "InternetTrap");
        test.Mods.Tools.AutoTestObjs("InternetTrapTest", "VariablesTest", "InternetTrap", "Variables", "collision", cb.collision, true);
    }
}