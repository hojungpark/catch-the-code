package Objects;

import java.awt.*;

/**
* Class is subclass of SuperObject, for the punishment.
* @author Group 21
*/

public class OBJ_InternetTrap extends SuperObject {

    /**
    * Constructor to set the variables for the punisnment: name, image, points, and collision boolean.
    */
    public OBJ_InternetTrap()
    {
        name = "InternetTrap";

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        image = toolkit.getImage("src/main/resources/InternetTrap.png");

        points = -20;

        collision = true;

    }
}
