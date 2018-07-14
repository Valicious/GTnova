package edu.BT.input;

import edu.BT.GameLoop;
import edu.BT.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

@SuppressWarnings("unused")
public class RegisterInput {
    private static HashMap<Integer,Boolean> keyCooldownSet;

    //Name of input event and the combination of keys.
    private static HashMap<String, inputTriplet> inputEvents;

    /**
     * List of keyboard inputs. See class inputTriplet for other constructors.
     *
     * @requires any unique name.
     * @requires any a key combination: key, action
     * @requires method
     */
    private RegisterInput() {
        inputEvents = new HashMap<>();
        keyCooldownSet = new HashMap<>();
        //All keyboard action are defined below!
        try {
            inputEvents.put("close", new inputTriplet(GLFW_KEY_ESCAPE, "closeWindow"));
            inputEvents.put("changecol", new inputTriplet(GLFW_KEY_2, "do2"));
        } catch (NoSuchMethodException e) {
            System.out.println("unable to find method");
            e.printStackTrace();
        }
        Log.SYSTEM("Keybindings set!");
    }

    //<editor-fold desc="Event Definitions">

    //TODO for normal movement make a flag to see if a direction is already active (cant go left and right at the same time)

    private static void closeWindow(long curWindow) {
        glfwSetWindowShouldClose(curWindow, true); // We will detect this in the rendering loop
    }

    private static void do2(long curWindow) {
        GameLoop.x += 0.01;
        //System.out.println(GameLoop.x);
    }

    //</editor-fold>

    //<editor-fold desc="Event Controllers">

    public static void setupInputRegistry() {
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        new RegisterInput();
    }

    public static void update(long curWindow) {
        inputEvents.forEach((name, input) -> {
            if (glfwGetKey(curWindow, input.key) == GLFW_TRUE) {
                if (keyCooldownSet.getOrDefault(input.key,false)) return;
                keyCooldownSet.put(input.key,true);
                new ScheduledThreadPoolExecutor(1).schedule(() ->  keyCooldownSet.put(input.key,false),100,TimeUnit.MILLISECONDS);
                try {
                    input.event.invoke(RegisterInput.class, curWindow);
                } catch (IllegalAccessException e) {
                    System.out.println("unable to access method");
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    System.out.println("unable to invoke method");
                    e.printStackTrace();
                }
            }

        });
        /*glfwSetKeyCallback(curWindow, (window, key, scancode, action, mods) -> {
            inputEvents.forEach((name, input) -> {
                if (key == input.key && mods == input.mods) {
                    if (input.action == KEY_DOWN) {
                        if (action == 0) return;

                    } else if (action != input.action) return;
                    System.out.println(action);
                    try {
                        input.event.invoke(RegisterInput.class, window);
                    } catch (IllegalAccessException e) {
                        System.out.println("unable to access method");
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        System.out.println("unable to invoke method");
                        e.printStackTrace();
                    }
                }

            });
        });*/
    }

    private class inputTriplet {
        public int key, action;
        Method event;

        public inputTriplet(int key, String method) throws NoSuchMethodException {
            this.key = key;
            this.event = RegisterInput.class.getDeclaredMethod(method, long.class);
        }

        public inputTriplet(int key, int action, String method) throws NoSuchMethodException {
            this(key, method);
            this.action = action;
        }

    }

    //</editor-fold desc="Event Controllers">
}
