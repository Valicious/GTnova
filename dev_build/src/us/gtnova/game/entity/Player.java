package us.gtnova.game.entity;

import processing.core.PImage;
import us.gtnova.lib.global.GlobalVars;
import us.gtnova.lib.handlers.Anime;
import us.gtnova.lib.runnable.Drawable;
import us.gtnova.lib.utils.Property;

import static us.gtnova.lib.global.GlobalVars.getContext;
import static us.gtnova.lib.global.PubSub.subscribe;

public class Player implements Drawable {
    private Property<Integer> posX = new Property<>(0);
    private Property<Integer> posY = new Property<>(0);
    private Anime animationController;

    public Player(int posX, int posY) {
        this.posX.set(posX);
        this.posY.set(posY);
        GlobalVars.put("posX", this.posX);
        GlobalVars.put("posY", this.posY);
        initEvents();
        PImage image = getContext().loadImage("Sprites/rogue_idle.png");
        animationController = new Anime(image, 3, 100, 100);
    }

    private void initEvents() {
        subscribe("key_W", args -> posY.set(posY.value() + 5));
        subscribe("key_S", this::moveDown);
        subscribe("key_A", args -> posX.set(posX.value() - 5));
        subscribe("key_D", args -> posX.set(posX.value() + 5));
    }

    private void moveDown(Object... args) {
        System.out.println(posX.value());
        System.out.println(posY.value());
    }

    @Override
    public void draw() {
        animationController.draw(getContext(), 10, posX.value(), posY.value(), 2);
    }
}
