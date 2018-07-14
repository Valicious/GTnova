package edu.BT;

import edu.BT.input.RegisterInput;
import edu.BT.world.WorldGen;

import static org.lwjgl.opengl.GL11.*;

public class GameLoop {
    public static double x = 0.001;

    public static void run(long curWinder) {
        RegisterInput.update(curWinder);

        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2d(-x,x);
        glTexCoord2f(0,1);
        glVertex2d(x,0.5);
        glTexCoord2f(1,1);
        glVertex2d(0.5,-0.5);
        glTexCoord2f(1,0);
        glVertex2d(-0.5,-0.5);
        glEnd();
    }
}
