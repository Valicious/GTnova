package edu.BT;

import edu.BT.character.PlayerEntity;
import edu.BT.utils.AnimationController;
import edu.BT.views.MainMenu;
import javafx.scene.canvas.GraphicsContext;

public class Game {
    private static GraphicsContext context;
    private static long startNanoTime;
    AnimationController sprite = new AnimationController("file:~Player.png",48,48,1);
    private PlayerEntity playerOne = new PlayerEntity(sprite,"SnowFlake");

    public Game(MainMenu screen) {
        context = screen.GetCanvas().getGraphicsContext2D();
        startNanoTime = System.nanoTime();
    }

    public static GraphicsContext getContext() {
        return context;
    }
}
