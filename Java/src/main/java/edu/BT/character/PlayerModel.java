package edu.BT.character;

import edu.BT.entities.LivingEntity;

import java.awt.image.BufferedImage;

/*Cntr Alt L - respacing
ctrl shift ? - commenting*/

public class PlayerModel extends LivingEntity {
    BufferedImage sprite;

    public void PlayerModel(BufferedImage image, String name)
    {
        sprite = image;
        eId = name;
        xpos = 0;
        ypos = 0;
        xSpeed = 5;
        ySpeed = 5;
    }


}
