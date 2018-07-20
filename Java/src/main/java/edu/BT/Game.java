package edu.BT;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game {
    private static GraphicsContext context;
    private static long startNanoTime;

    public Game(Scene screen) {
        context = screen.getGraphicsContext2D();
        startNanoTime = System.nanoTime();
    }

    public static GraphicsContext getContext() {
        return context;
    }
}
