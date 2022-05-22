package Objects;

import java.awt.*;

/**
 * Class is subclass of SuperObject, for the end tile
 * @author Group 21
 */
public class OBJ_End extends SuperObject {

    /**
     * Constructor to set the variables for the reward: name, image, points, and collision boolean.
     */
    public OBJ_End()
    {
        name = "End Tile";

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        image = toolkit.getImage("src/main/resources/walk.png");

        points = 0;

        collision = true;

    }
}

