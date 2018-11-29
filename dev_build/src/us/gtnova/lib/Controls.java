package us.gtnova.lib;

import processing.core.PConstants;
import us.gtnova.lib.utils.Log;

import java.util.HashMap;

public class Controls {
    //TODO save and load controls to a file
    private HashMap<Character, Runnable> cKeys = new HashMap<>();
    private HashMap<Integer, Runnable> iKeys = new HashMap<>();


    public Controls() {
        cKeys.put('w', getRunner("key_W"));
        cKeys.put('W', getRunner("key_W"));
        iKeys.put(PConstants.UP, getRunner("key_W"));

        cKeys.put('s', getRunner("key_S"));
        cKeys.put('S', getRunner("key_S"));
        iKeys.put(PConstants.DOWN, getRunner("key_S"));

        cKeys.put('a', getRunner("key_A"));
        cKeys.put('A', getRunner("key_A"));
        iKeys.put(PConstants.LEFT, getRunner("key_A"));

        cKeys.put('d', getRunner("key_D"));
        cKeys.put('D', getRunner("key_D"));
        iKeys.put(PConstants.RIGHT, getRunner("key_D"));

    }

    public void update() {


    }

    private Runnable getRunner(String name) {
        return () -> Log.INFO(name);
    }
}

