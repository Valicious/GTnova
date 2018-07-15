package edu.BT;

import edu.BT.input.RegisterInput;

import static org.lwjgl.opengl.GL11.*;

public class GameLoop {
    public static double x = 1.8;

    public static void run(long curWinder) {
        RegisterInput.update(curWinder);
        //screen pos maps from -1 to 1; anything greater will be "rendered" offscreen.
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2d(-x,0.5);
        glTexCoord2f(0,1);
        glVertex2d(x,0.5);
        glTexCoord2f(1,1);
        glVertex2d(x,-0.5);
        glTexCoord2f(1,0);
        glVertex2d(-x,-0.5);
        glEnd();
    }
}
