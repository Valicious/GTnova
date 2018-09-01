package us.gtnova.lib.runnable;

@FunctionalInterface
public interface RunnableGeneric<G> {
    void run(G... ggg);
}
