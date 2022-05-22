package Objects;

import java.awt.*;

/**
* Class is subclass of SuperObject, for the reward.
* @author Group 21
*/
public class OBJ_Semicolon extends SuperObject {

    /**
    * Constructor to set the variables for the reward: name, image, points, and collision boolean.
    */
    public OBJ_Semicolon()
    {
        name = "Semicolon";

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        image = toolkit.getImage("src/main/resources/SemiColon.png");

        points = 20;

        collision = true;

    }
}
