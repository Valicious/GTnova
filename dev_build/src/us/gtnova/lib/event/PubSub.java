package us.gtnova.lib.event;

import us.gtnova.lib.runnable.RunnableObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PubSub {
    private static HashMap<String, Set<Long>> registrar;
    private static HashMap<Long,RunnableObjects> events;
    private static long idSize = 0;

    public static void resetRegistrar() {
        registrar = new HashMap<>();
        events = new HashMap<>();
        idSize = 0;
    }

    public static void sendMessage(String topic, Object... args) {
        if (registrar.containsKey(topic)) {
            for (Long curID : registrar.get(topic)) {
                RunnableObjects curEvent = events.get(curID);
                if (curEvent != null)
                    try {
                        curEvent.run(args);
                    } catch (ClassCastException e) {
                       // Log.e("Hi :)", "Unable to cast Arguments!");
                        //TODO implement logger
                        e.printStackTrace();
                    }
            }
        }
    }

    public static long subscribe(String topic, RunnableObjects event) {
        if (!registrar.containsKey(topic)) {
            addSubscriber((Set<Long>) new ArrayList<Long>(), idSize, event, topic);
        } else {
            addSubscriber(registrar.get(topic), idSize, event, topic);
        }
        return idSize++;
    }

    public static void unsubscribe(long id, String topic) {
        registrar.get(topic).remove(id);
        events.remove(id);
    }

    private static void addSubscriber(Set<Long> subscribers, Long id, RunnableObjects newSub, String topic) {
        subscribers.add(id);
        registrar.put(topic, subscribers);
        events.put(id, newSub);
    }
}
