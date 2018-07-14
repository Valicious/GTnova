package edu.BT;

import org.lwjgl.Version;

import java.io.PrintStream;
import java.time.LocalTime;

public class Log {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static {
        SYSTEM("GTnova alpha, LWJGL " + Version.getVersion() + "!");
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(ANSI_RESET + "[" + LocalTime.now() + "]: " + x + ANSI_RESET);
            }
        };
        System.setOut(myStream);
    }

    public static void ERROR(String out) {
        System.out.println(ANSI_RED + out);
    }

    public static void INFO(String out) {
        System.out.println(ANSI_BLUE + out);
    }

    public static void WARNING(String out) {
        System.out.println(ANSI_YELLOW + out);
    }

    public static void SYSTEM(String out) {
        System.out.println(ANSI_CYAN + out);
    }
}
