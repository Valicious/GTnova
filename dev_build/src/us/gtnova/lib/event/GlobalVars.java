package us.gtnova.lib.event;

import us.gtnova.lib.utils.Pair;

import java.util.HashMap;

public class GlobalVars {
    private static HashMap<String, Pair<Class<?>, Object>> list = new HashMap<>();

    public static <G> Pair<String, G> put(String name, G value) {
        if (list.put(name, new Pair<>(value.getClass(), value)) == null)
            return null;
        else
            return new Pair<>(name, value);
    }

    public void clear(){
        list = new HashMap<>();
    }

    public static <G> G get(String name){
        Object cur = list.get(name).getValue();
        return (G) list.get(name).getKey().cast(cur);
    }
}
