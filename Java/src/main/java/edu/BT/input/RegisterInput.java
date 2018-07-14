package edu.BT.input;

import edu.BT.GameLoop;
import edu.BT.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.lwjgl.glfw.GLFW.*;

@SuppressWarnings("unused")
public class RegisterInput {
    //Name of input event and the combination of keys.
    private static HashMap<String, inputTriplet> inputEvents;

    /**
     * List of keyboard inputs. See class inputTriplet for other constructors.
     * @requires any unique name.
     * @requires any a key combination: key, action, mod
     * @requires method
     */
    private RegisterInput() {
        inputEvents = new HashMap<>();
        //All keyboard action are defined below!
        try {
            inputEvents.put("close", new inputTriplet(GLFW_KEY_ESCAPE, "closeWindow"));
            inputEvents.put("showSomething", new inputTriplet(GLFW_KEY_3, "printHi"));
            inputEvents.put("changecol", new inputTriplet(GLFW_KEY_2, "do2"));
        } catch (NoSuchMethodException e) {
            System.out.println("unable to find method");
            e.printStackTrace();
        }
        Log.SYSTEM("Keybindings set!");
    }

    //<editor-fold desc="Event Definitions">

    private static void closeWindow(long curWindow) {
        glfwSetWindowShouldClose(curWindow, true); // We will detect this in the rendering loop
    }

    private static void printHi(long curWindow){
        System.out.println("Hi");
    }

    private static void do2(long curWindow){
        GameLoop.x += 1;
        System.out.println(GameLoop.x);
    }

    //</editor-fold>

    //<editor-fold desc="Event Controllers">

    public static void setupInputRegistry(long curWindow) {
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        new RegisterInput();
        glfwSetKeyCallback(curWindow, (window, key, scancode, action, mods) -> {
            inputEvents.forEach((name, input) -> {
                if (key == input.key && action == input.action && mods == input.mods) {
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
        });
    }

    private class inputTriplet {
        public int key, action, mods;
        Method event;

        public inputTriplet(int key, String method) throws NoSuchMethodException {
            this.key = key;
            this.event = RegisterInput.class.getDeclaredMethod(method, long.class);
        }

        public inputTriplet(int key, int action, String method) throws NoSuchMethodException {
            this(key, method);
            this.action = action;
        }

        public inputTriplet(int key, int action, int mods, String method) throws NoSuchMethodException {
            this(key, action, method);
            this.mods = mods;
        }

    }

    //</editor-fold desc="Event Controllers">
}
