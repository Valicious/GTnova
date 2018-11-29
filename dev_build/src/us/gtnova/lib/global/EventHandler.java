package us.gtnova.lib.global;

import java.util.ArrayList;

public class EventHandler {
    private static ArrayList<Listener> register = new ArrayList<>();

    public static boolean register(Listener clazz) {
        if (register.contains(clazz))
            return false;
        else {
            register.add(clazz);
            return true;
        }
    }

    public static boolean deregister(Listener clazz) {
        if (register.contains(clazz))
            return register.remove(clazz);
        else
            return false;

    }
}
