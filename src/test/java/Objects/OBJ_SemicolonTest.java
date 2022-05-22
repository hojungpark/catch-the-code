package Objects;


import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class OBJ_SemicolonTest {
    @Test
    public static void test(){
        var cb = new OBJ_Semicolon();
        test.Mods.Tools.AutoTestNums("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "points", cb.points, 20);
        test.Mods.Tools.AutoTestNums("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "worldx", cb.worldX, 0);
        test.Mods.Tools.AutoTestNums("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        test.Mods.Tools.AutoTestNums("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "worldY", cb.worldY, 0);
        test.Mods.Tools.AutoTestNums("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        test.Mods.Tools.AutoTestObjs("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/SemiColon.png");
        test.Mods.Tools.AutoTestObjs("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "image", cb.image, image);
        test.Mods.Tools.AutoTestText("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "points", cb.name, "Semicolon");
        test.Mods.Tools.AutoTestObjs("SemicolonTest", "VariablesTest", "Semicolon", "Variables", "collision", cb.collision, true);
    }

}