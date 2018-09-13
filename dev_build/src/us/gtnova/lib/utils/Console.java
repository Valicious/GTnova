package us.gtnova.lib.utils;

import us.gtnova.lib.global.GlobalVars;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        if (input.substring(0, 2).equals("<<"))
            doRunner(input.substring(2, input.length()));
        else
            doGlobalVars(input.replaceAll(" ", ""));


    }

    private static void doGlobalVars(String input) {
        int pos = input.indexOf('=');
        String variableName;
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

    private static void doRunner(String input) {
        final String loc = "us.gtnova.";
        if (input.isEmpty())
            System.out.println(loc);
        else {
            try {
                String[] path = input.split("#");
                final Class<?> clazz = Class.forName(loc + path[0]);
                String[] chain = path[1].split("\\.");
                final List<Method> methods = new ArrayList<>();

                int counter = 0;
                for (String sMeth : chain) {
                    if (counter == 0)
                        methods.add(
                                Arrays.stream(clazz.getMethods())
                                        .filter(meth -> meth.getName().equals(sMeth))
                                        .findFirst()
                                        .get()
                        );
                    else {
                        Class<?> type = methods.get(counter - 1).getReturnType();
                        methods.add(
                                Arrays.stream(type.getMethods())
                                        .filter(meth -> meth.getName().equals(sMeth))
                                        .findFirst()
                                        .get()
                        );
                    }
                    counter++;
                }
                Object prev = null;
                for (Method cur : methods) {
                    try {
                        prev = cur.invoke(prev);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("Only works on static Parent(for now :) ) and no children with parameters");
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println(prev);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
                e.printStackTrace();
            }
        }
    }
}
