package edu.BT.character;

import edu.BT.entities.LivingEntity;
import edu.BT.utils.AnimationController;

/*Cntr Alt L - respacing
ctrl shift ? - commenting*/

public class PlayerEntity extends LivingEntity {
    AnimationController sprite;

    public PlayerEntity(AnimationController image, String name)
    {
        sprite = image;
        eId = name;
    //    xpos.bindBidirectional(sprite.);
        xSpeed = 5;
        ySpeed = 5;
    }


}
