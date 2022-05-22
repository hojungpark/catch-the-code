package Objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_HTMLTagTest {
    @Test
    public static void test(){
        OBJ_HTMLTag cb = new OBJ_HTMLTag();
        test.Mods.Tools.AutoTestNums("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "points", cb.points, 20);
        test.Mods.Tools.AutoTestNums("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/HTMLTag.png");
        test.Mods.Tools.AutoTestObjs("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "image", cb.image, image);
        test.Mods.Tools.AutoTestText("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "name", cb.name, "HTMLTag");
        test.Mods.Tools.AutoTestObjs("HTMLTagTest", "VariablesTest", "HTMLTag", "Variables", "collision", cb.collision, true);
    }
}