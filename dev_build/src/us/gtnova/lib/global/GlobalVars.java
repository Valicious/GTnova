package us.gtnova.lib.global;

import processing.core.PApplet;
import us.gtnova.lib.utils.Pair;
import us.gtnova.lib.utils.Property;

import java.net.URL;
import java.util.HashMap;

public class GlobalVars {
    private static HashMap<String, Object> list = new HashMap<>();

    {
        put("printAllVars",print());
    }

    public static <G> Pair<String, G> put(String name, G value) {
        if (list.put(name, value) == null)
            return null;
        else
            return new Pair<>(name, value);
    }

    public static <G extends Object> G get(String name) {
        return (G) list.get(name);
    }

    public static Property<?> getP(String name) {
        Object value = list.get(name);
        if ( value instanceof Property<?>)
            return (Property<?>) value;
        return null;
    }

    public static void clear() {
        list = new HashMap<>();
    }

    public static String print(){
        StringBuilder bob = new StringBuilder();
        list.forEach((key,value) -> bob.append(value.toString() + "\n"));
        return bob.toString();
    }

    //Special variables

    public static PApplet getContext(){
        return (PApplet) getP("app").value();
    }

}
