package us.gtnova.game.world;

import us.gtnova.lib.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static java.lang.Math.round;

public class WorldGen {
    int id;
    private int maxWidth = 100, maxHeight = 100;

    public WorldGen() {
        generateMap();
        //makeImage(grid);
        System.out.println();
    }

    private void makeImage(float[][] grid) {
        /*ByteBuffer pixels =
        for (int width = 0; width < maxWidth; width++) {
            for (int height = 0; height < maxHeight; height++) {
                int pixel = round(grid[width][height] * 255);
                pixels.put((byte) (pixel & 0xFF));
                pixels.put((byte) (pixel & 0xFF));
                pixels.put((byte) (pixel & 0xFF));
                pixels.put((byte) (255 & 0xFF));
            }
        }
        pixels.flip();*/

    }

    /**
     * Small 2000x1000
     * Medium 5500x1500
     * Large 10000x2000
     */
    private void generateMap() {
        //final int WIDTH = 1073741823;
        final int WIDTH = 2000;
        final int HEIGHT = 500;
        final double FEATURE_SIZE = 10;


        Log.INFO("Started map");
        OpenSimplexNoise noise = new OpenSimplexNoise();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        /*for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                double value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE) + 1;
                int rgb = 0;
               *//* if (value > 0.5)
                    rgb = 0x010101 * 255;*//*
                    rgb = 0x010101 * (int) (value * 127.5);
                image.setRGB(x, y, rgb);
            }
        }*/
            float frequency = 100f / (float) WIDTH;

            for(int x = 0; x < WIDTH; x++){
                for(int y = 0; y < HEIGHT; y++){
                    float value = (noise(x * frequency,y * frequency) + 1) / 2;   //generate values between 0 and 1
                    if (value > 0.9)
                        image.setRGB(x, y, 0xffffff);
                    else
                    image.setRGB(x, y, (int) (value * 0xffffff*255));
                }
            }


        try {
            ImageIO.write(image, "png", new File("noise.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.INFO("Done with map");
        System.exit(0);
    }

    private float noise(float v, float v1) {
        return 0;
    }
}
