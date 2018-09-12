package us.gtnova.lib.utils;

import us.gtnova.lib.runnable.RunnableObjects;

public class Property<G> {
    private G value;
    private RunnableObjects actionGet = null;
    private RunnableObjects actionSet = null;

    public Property(G value) {
        this.value = value;
    }

    public G value() {
        if (actionGet != null)
            actionGet.run(value);
        return value;
    }

    public void set(G value) {
        this.value = value;
        if (actionSet != null)
            actionSet.run(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public void setActionGet(RunnableObjects actionGet) {
        this.actionGet = actionGet;
    }

    public void setActionSet(RunnableObjects actionSet) {
        this.actionSet = actionSet;
    }

}
