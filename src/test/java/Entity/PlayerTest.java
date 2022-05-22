package Entity;

import Game.GamePanel;
import Game.GamePanelData;
import Game.KeyHandler;
import test.Mods.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class PlayerTest {
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
        KeyHandler keyH = new KeyHandler();
        Player player = new Player(gp, keyH, gp.gpd);

        Tools.AutoTestObjs("PlayerTest", "Player", "Init_Variable", "PlayerScreenX", "screenX", (768/2 - 48/2), player.screenX);
        Tools.AutoTestObjs("PlayerTest", "Player", "Init_Variable", "PlayerScreenY", "screenY", (576/2 - 48/2), player.screenY);

        Tools.AutoTestObjs("PlayerTest", "Player", "Init_Variable", "Rectangle", "solidArea", new Rectangle(0, 0, 48, 48), player.solidArea);
        Tools.AutoTestNums("PlayerTest", "Player", "Init_Variable", "xCoordinate", "solidAreaDefaultX", 0, player.solidAreaDefaultX);
        Tools.AutoTestNums("PlayerTest", "Player", "Init_Variable", "yCoordinate", "solidAreaDefaultY", 0, player.solidAreaDefaultY);

        Tools.AutoTestNums("PlayerTest", "Player", "Init_Variable", "xCoordinate", "worldX", 48, player.worldX);
        Tools.AutoTestNums("PlayerTest", "Player", "Init_Variable", "yCoordinate", "worldY", 48, player.worldY);
        Tools.AutoTestNums("PlayerTest", "Player", "Init_Variable", "PlayerSpeed", "speed", 4, player.speed);
        Tools.AutoTestText("PlayerTest", "Player", "Init_Variable", "InitDirection", "direction", "down", player.direction);

        player.direction = "up";
        Tools.AutoTestText("PlayerTest", "Player", "Init_Variable", "PlayerUp", "direction", "up", player.direction);

        player.direction = "down";
        Tools.AutoTestText("PlayerTest", "Player", "Init_Variable", "PlayerDown", "direction", "down", player.direction);

        player.direction = "left";
        Tools.AutoTestText("PlayerTest", "Player", "Init_Variable", "PlayerLeft", "direction", "left", player.direction);

        player.direction = "right";
        Tools.AutoTestText("PlayerTest", "Player", "Init_Variable", "PlayerRight", "direction", "right", player.direction);

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Image testUp1 = toolkit.getImage("src/main/resources/player_up1.png");
        Image testUp2 = toolkit.getImage("src/main/resources/player_up2.png");

        Image testDown1 = toolkit.getImage("src/main/resources/player_down1.png");
        Image testDown2 = toolkit.getImage("src/main/resources/player_down2.png");

        Image testLeft1 = toolkit.getImage("src/main/resources/player_left1.png");
        Image testLeft2 = toolkit.getImage("src/main/resources/player_left2.png");

        Image testRight1 = toolkit.getImage("src/main/resources/player_right1.png");
        Image testRight2 = toolkit.getImage("src/main/resources/player_right2.png");

        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerUp1Image", "up1", testUp1, player.up1);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerUp2Image", "up2", testUp2, player.up2);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerDown1Image", "Down1", testDown1, player.down1);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerDown2Image", "Down2", testDown2, player.down2);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerLeft1Image", "left1", testLeft1, player.left1);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerLeft2Image", "left2", testLeft2, player.left2);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerRight1Image", "right1", testRight1, player.right1);
        Tools.AutoTestObjs("PlayerTest", "Player", "setImage", "PlayerRight2Image", "right2", testRight2, player.right2);

        Tools.AutoTestObjs("PlayerTest", "Player", "gameStatus", "Status", "gameLost", false, player.gp.gpd.gameLost);
    }
}
