package edu.BT.utils;

import org.lwjgl.Version;

import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

public class Log {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public Log() {
        SYSTEM("GTnova alpha, LWJGL " + Version.getVersion() + "!");
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(ANSI_RESET + "[" + LocalTime.now() + "]: " + x + ANSI_RESET);
            }
        };
        System.setOut(myStream);
    }

    public static void ERROR(String... out) {
        System.out.println(ANSI_RED + reformat(out));
    }

    public static void INFO(String... out) {
        System.out.println(ANSI_BLUE + reformat(out));
    }

    public static void WARNING(String... out) {
        System.out.println(ANSI_YELLOW + reformat(out));
    }

    public static void SYSTEM(String... out) {
        System.out.println(ANSI_CYAN + reformat(out));
    }

    private static String reformat(String[] out){
        String formated = "";
        for (String cur:out){
            formated += cur + " ";
        }
        return formated;
    }

    private static void die(String out){
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + out);
    }

    public static void die(int code) {
        switch(code){
            case 10: {
                die("Error level 10: Operation didn't complete");
                die("An unexpected error has occurred and resulted in an unrecoverable state!");
                die("Scheduling Application close!");
                break;
            }
        }
        //TODO Schedule scene shutdown
        //glfwSetWindowShouldClose(window, true);
    }
}
