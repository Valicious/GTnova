package edu.BT;

import static org.lwjgl.opengl.GL11.*;

public class GameLoop {
    public static double x = 50;

    public static void run() {
        glBegin(GL_QUADS);
        glVertex2d(x,50);
        glEnd();
    }
}
