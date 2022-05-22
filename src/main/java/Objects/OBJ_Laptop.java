package Objects;

import java.awt.*;

/**
* Class is subclass of SuperObject, for the bonus reward reward.
* @author Group 21
*/

public class OBJ_Laptop extends SuperObject {

    /**
    * Constructor to set the variables for the bonus reward: name, image, points, and collision boolean.
    */
    public OBJ_Laptop()
    {
        name = "Laptop";

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        image = toolkit.getImage("src/main/resources/laptop.png");

        points = 50;

        collision = true;

    }
}
