package edu.BT.blocks;

import edu.BT.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Block {
    private static BufferedImage text;
    private float dimX;
    private float dimY;
    private float posX;
    private float posY;
    private float friction = 0;

    abstract void giveDrops();

    private void loadImage(String filename){
        try {
            text = ImageIO.read(new File(filename));

        } catch (IOException e) {
            e.printStackTrace();
            Log.ERROR("Unable to load image for block at", String.valueOf(posX),",", String.valueOf(posY));
        }
    }

    public Block(float dimX, float dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
    }


}
