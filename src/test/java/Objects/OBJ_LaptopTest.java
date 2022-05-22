package Objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_LaptopTest {
    @Test
    public static void test(){
        OBJ_Laptop cb = new OBJ_Laptop();
        test.Mods.Tools.AutoTestNums("LaptopTest", "VariablesTest", "Laptop", "Variables", "points", cb.points, 50);
        test.Mods.Tools.AutoTestNums("LaptopTest", "VariablesTest", "Laptop", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("LaptopTest", "VariablesTest", "Laptop", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("LaptopTest", "VariablesTest", "Laptop", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("LaptopTest", "VariablesTest", "Laptop", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("LaptopTest", "VariablesTest", "Laptop", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/laptop.png");
        test.Mods.Tools.AutoTestObjs("LaptopTest", "VariablesTest", "Laptop", "Variables", "image", cb.image, image);
        test.Mods.Tools.AutoTestText("LaptopTest", "VariablesTest", "Laptop", "Variables", "name", cb.name, "Laptop");
        test.Mods.Tools.AutoTestObjs("LaptopTest", "VariablesTest", "Laptop", "Variables", "collision", cb.collision, true);
    }
}