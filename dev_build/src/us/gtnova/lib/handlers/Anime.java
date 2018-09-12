package us.gtnova.lib.handlers;

import processing.core.PApplet;
import processing.core.PImage;
import us.gtnova.lib.global.GlobalVars;

public class Anime {
    private PImage spritesheet;
    private int defaultSpeed = 1;//dfs = 2 AND target frames are 60 => update twice in 60 frames aka every 30 frames
    private int frames;
    private int curframe;
    private int dimX;
    private int dimY;

    public Anime(PImage spritesheet, int frames, int dimX, int dimY) {
        this.spritesheet = spritesheet;
        this.frames = frames;
        this.curframe = 1;
        this.dimX = dimX;
        this.dimY = dimY;

    }

    public void draw(PApplet context, int speed, int locX, int locY, double cubicScale) {
        curframe = (((Integer) GlobalVars.getP("fps").value()) / (speed == 0 ? defaultSpeed : speed)) % frames;
        context.image(
                spritesheet.get(curframe * dimX, 0, dimX, dimY),
                locX, locY, (float) (dimX * cubicScale), (float)(dimY * cubicScale)
        );
    }
}
