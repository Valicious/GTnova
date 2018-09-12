package us.gtnova.lib.utils;

import us.gtnova.lib.global.GlobalVars;

import java.lang.reflect.Type;
import java.util.Scanner;

public class Console {
    private static Property<Boolean> active;
    private static Pause pause;

    public static void start() {
        Thread consoleListener = new Thread(getAction());
        active = new Property<>(true);
        GlobalVars.put("console", active);
        consoleListener.start();
    }

    private static Runnable getAction() {
        return () -> {
            Scanner consoleInput = new Scanner(System.in);
            while (active.value()) {
                /*if (!pause.done) continue;
                pause.pause(100);*/
                command(consoleInput.nextLine());
            }
        };
    }

    private static void command(String input) {
        input = input.replaceAll(" ", "");
        int pos = input.indexOf('=');
        String variableName = "";
        String variableValue = "";
        if (pos == -1) {
            variableName = input;
        } else {
            variableName = input.substring(0, pos);
            variableValue = input.substring(pos + 1, input.length());
        }

        Object var = GlobalVars.get(variableName);
        if (var == null) {
            System.out.println("'" + variableName + "' does not exist in this current context");
        } else if (pos == -1 && variableValue.equals("")) {
            System.out.println(var.toString());
        } else if (!variableValue.equals("")) {
            if (var instanceof Property<?>) {
                Type type = ((Property) var).value().getClass();
                if (type.equals(Integer.class)) {
                    ((Property) var).set(Integer.parseInt(variableValue));
                }
                System.out.println(variableName + " is set to " + variableValue);
            } else
                System.out.println("No handler defined for this variable type: " + var.getClass().getName());
        } else {
            System.out.println("Something went wrong! '" + input + "'");
        }
    }
}
