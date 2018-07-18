package edu.BT.input;

import edu.BT.GameLoop;
import edu.BT.utils.Log;
import edu.BT.utils.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.lwjgl.glfw.GLFW.*;

@SuppressWarnings("unused")
public class RegisterInput {
    private static HashMap<Integer, Boolean> keyCooldownSet;

    //Name of input event and the combination of keys.
    private static HashMap<String, Pair<Integer, Method>> inputEvents;

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
        inputEvents.put("close", new Pair(GLFW_KEY_ESCAPE, getMethodFromName("closeWindow")));
        inputEvents.put("changecol", new Pair(GLFW_KEY_2, getMethodFromName("do2")));
        inputEvents.put("playerright", new Pair(GLFW_KEY_D, getMethodFromName("playermoveright")));
        inputEvents.put("playerleft", new Pair(GLFW_KEY_A, getMethodFromName("playermoveleft")));
        inputEvents.put("playerup", new Pair(GLFW_KEY_W, getMethodFromName("playermoveup")));
        inputEvents.put("playerdown", new Pair(GLFW_KEY_S, getMethodFromName("playermovedown")));
        Log.SYSTEM("Keybindings set!");
    }

    //<editor-fold desc="Event Definitions">

    //TODO for normal movement make a flag to see if a direction is already active (cant go left and right at the same time)

    private static void closeWindow(long curWindow) {
        glfwSetWindowShouldClose(curWindow, true); // We will detect this in the rendering loop
    }

    private static void do2(long curWindow) {
        GameLoop.x -= 0.01;
        System.out.println(GameLoop.x);
    }

    //</editor-fold>

    //<editor-fold desc="Event Controllers">

    public static void setupInputRegistry() {
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        new RegisterInput();
    }

    private Method getMethodFromName(String mName){
        try {
            return RegisterInput.class.getDeclaredMethod(mName, long.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Log.die(10);
        }
        return null;
    }

    public static void update(long curWindow) {
        inputEvents.forEach((name, input) -> {
            if (glfwGetKey(curWindow, input.getKey()) == GLFW_TRUE) {
                if (keyCooldownSet.getOrDefault(input.getKey(), false)) return;
                keyCooldownSet.put(input.getKey(), true);
                new ScheduledThreadPoolExecutor(1).schedule(() -> keyCooldownSet.put(input.getKey(), false), 100, TimeUnit.MILLISECONDS);
                try {
                    input.getValue().invoke(RegisterInput.class, curWindow);
                } catch (IllegalAccessException e) {
                    Log.ERROR("unable to access method");
                    e.printStackTrace();
                    Log.die(10);
                } catch (InvocationTargetException e) {
                    System.out.println("unable to invoke method");
                    e.printStackTrace();
                    Log.die(10);
                }
            }

        });
    }
    //</editor-fold desc="Event Controllers">
}
