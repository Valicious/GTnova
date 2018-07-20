package edu.BT.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimationController {
    private Image animSheet;
    private int dimX, dimY;
    private double speed;
    private int framesCount;

    public AnimationController(String location, int frameWidth, int frameHeight, int frames) {
        dimX = frameWidth;
        dimY = frameHeight;
        framesCount = frames;
        animSheet = new Image(location);
        speed = 1;
    }

    public void update(GraphicsContext context, double curSpeed, double posX, double posY) {
        int index = (int) (((curSpeed == 0 ? speed : curSpeed) % (framesCount * speed)) / speed);
        context.drawImage(
                animSheet,
                index * dimX, index * dimY, dimX, dimY,
                posX, posY, dimX, dimY
        );
    }


}