package us.gtnova.lib.utils;

import jdk.nashorn.internal.runtime.NumberToString;
import processing.core.PImage;

import static us.gtnova.lib.utils.Global.getContext;
import static us.gtnova.lib.utils.Log.INFO;


public class Animation {
    private PImage[] spritesheet;
    private int height;
    private int width;
    private int frames;
    private int cursprt;
    private PImage temp;


    public Animation(String sprtSheet,int H,int W,int framecount){
        cursprt = 0;
        temp = getContext().loadImage(sprtSheet);
        getContext().image(temp,100,200);
        spritesheet = new PImage[framecount];
        for(int i = 0;i<framecount;i++)
        {
            spritesheet[i] = temp.get(i*width,0,width,height);

            getContext().image(temp,100+100*i,100);
        }
        frames = framecount;

    }

    public void update(int xpos,int ypos)
    {
        cursprt++;
        if (cursprt == frames) cursprt=0;
        getContext().image(spritesheet[cursprt],xpos,ypos,width,height);
    }

}
