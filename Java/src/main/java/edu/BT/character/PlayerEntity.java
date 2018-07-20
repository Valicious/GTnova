package edu.BT.character;

import edu.BT.entities.LivingEntity;

import java.awt.image.BufferedImage;

/*Cntr Alt L - respacing
ctrl shift ? - commenting*/

public class PlayerEntity extends LivingEntity {
    BufferedImage sprite;

    public PlayerEntity(BufferedImage image, String name)
    {
        sprite = image;
        eId = name;
        xpos.setValue(0);
        ypos.setValue(0);
        xSpeed = 5;
        ySpeed = 5;
    }


}
