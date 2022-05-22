package Objects;

import Game.GamePanel;
import org.junit.jupiter.api.Test;
import test.Mods.Tools;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OBJ_CurlyBracketsTest {
    @Test
    public static void test(){
        OBJ_CurlyBrackets cb = new OBJ_CurlyBrackets();
        Tools.AutoTestNums("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "points", cb.points, 20);
        Tools.AutoTestNums("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "worldx", cb.worldX, 0);
        Tools.AutoTestNums("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "olidAreaDefaultX", cb.solidAreaDefaultX, 0);
        Tools.AutoTestNums("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "worldY", cb.worldY, 0);
        Tools.AutoTestNums("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "solidAreaDefaulty", cb.solidAreaDefaultY, 0);
        Tools.AutoTestObjs("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "solidArea", cb.solidArea, new Rectangle(0,0,48,48));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/main/resources/CurlyBrackets.png");
        Tools.AutoTestObjs("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "image", cb.image, image);
        Tools.AutoTestText("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "name", cb.name, "CurlyBrackets");
        Tools.AutoTestObjs("CurlyBracketsTest", "VariablesTest", "CurlyBrackets", "Variables", "collision", cb.collision, true);
    }
}