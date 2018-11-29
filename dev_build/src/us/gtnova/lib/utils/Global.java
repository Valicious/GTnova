package us.gtnova.lib.utils;

import processing.core.PApplet;
import us.gtnova.Main;

public class Global {
    private static PApplet context;

    public static PApplet getContext() {
        return context;
    }

    public static void setContext(Main main) {
        context = main;
    }
}
