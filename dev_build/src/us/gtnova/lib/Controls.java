package us.gtnova.lib;

import processing.core.PApplet;
import processing.core.PConstants;
import us.gtnova.lib.utils.Pause;

import java.util.HashMap;

import static us.gtnova.lib.global.GlobalVars.getContext;
import static us.gtnova.lib.global.PubSub.sendMessage;

public class Controls {
    //TODO save and load controls to a file
    private HashMap<Character, Runnable> cKeys = new HashMap<>();
    private HashMap<Integer, Runnable> iKeys = new HashMap<>();

    private Pause pause = new Pause();

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
        if (!pause.done) return;
        pause.pause(20);

        PApplet app = getContext();
        if (app.keyPressed) {
            try {
                cKeys.get(app.key).run();
            } catch (NullPointerException ec) {
                try {
                    iKeys.get(app.keyCode).run();
                } catch (NullPointerException ei) {
                    System.out.println("no global for " + app.key + " and " + app.keyCode);
                }
            }
        }

    }

    private Runnable getRunner(String name) {
        return () -> sendMessage(name);
    }
}

