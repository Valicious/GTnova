package us.gtnova.game.Entity;

import us.gtnova.Main;
import us.gtnova.lib.utils.Animation;

public class Player {
    private int xPos;
    private int yPos;
    public Animation idle;

    public Player(int X,int Y)
    {
        xPos = X;
        yPos = Y;
        idle = new Animation("Sprites/rogue_idle.png",100,100,3);

    }
    public void update(){
        idle.draw(xPos,xPos);
    }
}
