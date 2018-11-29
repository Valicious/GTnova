package us.gtnova.game.Entity;

import us.gtnova.Main;
import us.gtnova.lib.utils.Animation;

public class Player {
    private int xPos;
    private int yPos;
    private Main context;
    public Animation anime;

    public Player(int X,int Y)
    {
        xPos = X;
        yPos = Y;
        anime = new Animation("Sprites/rogue_idle.png",100,100,3);

    }
    public void update(){
        anime.update(100,100);
    }
}
