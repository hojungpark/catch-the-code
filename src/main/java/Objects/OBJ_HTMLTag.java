package Objects;

import java.awt.*;

/**
* Class is subclass of SuperObject, for the reward.
* @author Group 21
*/
public class OBJ_HTMLTag extends SuperObject {

    /**
    * Constructor to set the variables for the reward: name, image, points, and collision boolean.
    */
    public OBJ_HTMLTag()
    {
        name = "HTMLTag";

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        image = toolkit.getImage("src/main/resources/HTMLTag.png");

        points = 20;

        collision = true;

    }
}
