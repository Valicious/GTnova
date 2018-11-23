package us.gtnova.game.world;

import us.gtnova.lib.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorldGen {
    OpenSimplexNoise noise;

    public WorldGen() {
        noise = new OpenSimplexNoise();
        //generateMap();
    }

    /**
     * Small 2000x1000
     * Medium 5500x1500
     * Large 10000x2000
     */
    public void generateMap() {
        final int WIDTH = 2000;
        final int HEIGHT = 1;
        final double FEATURE_SIZE = 10;


        Log.INFO("Started map");
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                double value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE) + 1;
                int rgb = 0;
                //  if (value > 0.9)
                //   rgb = 0x010101 * 255;
                rgb = 0x010101 * (int) (value * 127.5);
                image.setRGB(x, y, rgb);
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

    private void placeSurface(){
        List<Integer> wave = getWave(2000, 10);


    }

    private List<Integer> getWave(int WIDTH, int FEATURE_SIZE) {
        Log.INFO("Started Wave map generation");
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < WIDTH; x++) {
            double value = noise.eval(x / FEATURE_SIZE, 1 / FEATURE_SIZE) + 1;
            list.add(0x010101 * (int) (value * 127.5));
        }
        Log.INFO("Done with Wave map generation");
        return list;
    }


}
