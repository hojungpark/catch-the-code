package Entity;

import Game.GamePanel;
import Game.GamePanelData;
import test.Mods.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class EnemyTest {
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
        Enemy enemy = new Enemy(gp, gp.gpd);
        Tools.AutoTestText("EnemyTest", "Enemy", "Init_Variable", "EnemyDirection", "direction", "down", enemy.direction);
        Tools.AutoTestNums("EnemyTest", "Enemy", "Init_Variable", "EnemySpeed", "speed", 2, enemy.speed);

        enemy.direction = "up";
        Tools.AutoTestText("EnemyTest", "Enemy", "Init_Variable", "EnemyUp", "direction", "up", enemy.direction);

        enemy.direction = "down";
        Tools.AutoTestText("EnemyTest", "Enemy", "Init_Variable", "EnemyDown", "direction", "down", enemy.direction);

        enemy.direction = "left";
        Tools.AutoTestText("EnemyTest", "Enemy", "Init_Variable", "EnemyLeft", "direction", "left", enemy.direction);

        enemy.direction = "right";
        Tools.AutoTestText("EnemyTest", "Enemy", "Init_Variable", "EnemyRight", "direction", "right", enemy.direction);

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Image testUp1 = toolkit.getImage("src/main/resources/enemy_up.png");
        Image testUp2 = toolkit.getImage("src/main/resources/enemy_up.png");

        Image testDown1 = toolkit.getImage("src/main/resources/enemy_down.png");
        Image testDown2 = toolkit.getImage("src/main/resources/enemy_down.png");

        Image testLeft1 = toolkit.getImage("src/main/resources/enemy_left.png");
        Image testLeft2 = toolkit.getImage("src/main/resources/enemy_left.png");

        Image testRight1 = toolkit.getImage("src/main/resources/enemy_right.png");
        Image testRight2 = toolkit.getImage("src/main/resources/enemy_right.png");

        Tools.AutoTestObjs("EnemyTest", "Enemy", "setImage", "EnemyUp1Image", "up1", testUp1, enemy.up1);
        Tools.AutoTestObjs("EnemyTest", "Enemy", "setImage", "EnemyDown1Image", "Down1", testDown1, enemy.down1);
        Tools.AutoTestObjs("EnemyTest", "Enemy", "setImage", "EnemyLeft1Image", "left1", testLeft1, enemy.left1);
        Tools.AutoTestObjs("EnemyTest", "Enemy", "setImage", "EnemyRight1Image", "right1", testRight1, enemy.right1);

        Tools.AutoTestObjs("EnemyTest", "Enemy", "gameStatus", "Status", "gameLost", false, enemy.gp.gpd.gameLost);
    }
}
