package us.gtnova.lib.utils;

import jdk.nashorn.internal.runtime.NumberToString;
import processing.core.PImage;
import us.gtnova.Main;
import us.gtnova.game.Game;

import static us.gtnova.lib.utils.Global.getContext;
import static us.gtnova.lib.utils.Log.INFO;


public class Animation {
    private PImage[] spritesheet;
    private int height;
    private int width;
    private int frames;
    private int cursprt;
    private int speed;
    private PImage temp;


    public Animation(String sprtSheet,int H,int W,int framecount){
        cursprt = 0;
        width = W;
        height = H;
        temp = getContext().loadImage(sprtSheet);
        spritesheet = new PImage[framecount];
        for(int i = 0;i<framecount;i++)
        {
            spritesheet[i] = temp.get(i*width,0,width,height);

        }
        frames = framecount;
        speed = 50;

    }

    public void draw(int xpos,int ypos)
    {
            cursprt++;// = ((Game.fps) / (speed == 0 ? 1 : speed)) % frames;
            if (cursprt == frames) cursprt = 0;
            getContext().image(spritesheet[cursprt], xpos, ypos, width, height);

    }

}
