package us.gtnova;

import processing.core.PApplet;
import processing.event.KeyEvent;
import us.gtnova.game.Game;
import us.gtnova.lib.global.GlobalVars;
import us.gtnova.lib.runnable.RunnableObjects;
import us.gtnova.lib.utils.Console;
import us.gtnova.lib.utils.Property;

import static us.gtnova.lib.global.PubSub.resetRegistrar;

public class Main extends PApplet {
    private Game game;
    private Property<Integer> fps = new Property<>(0);

    public static void main(String[] args) {
        PApplet.main(new String[]{"us.gtnova.Main"});
    }

    /*void Setup(){}*/
    public void settings() {
        resetRegistrar();
        Property<Integer> screenHeight = new Property<>(700);
        Property<Integer> screenWidth = new Property<>(1000);
        Property<PApplet> app = new Property<>(this);

        GlobalVars.put("app", app);
        GlobalVars.put("screenHeight", screenHeight);
        GlobalVars.put("screenWidth", screenWidth);
        GlobalVars.put("fps", fps);
        size(screenWidth.value(), screenHeight.value());

        game = new Game();
        fps.setActionGet(args -> fps.set(frameCount));
        //  frameRate(60);
        Console.start();
    }

    public void draw() {
        background(50);
        text(frameRate, 10, 10);
        //frame.setSize(screenWidth.value(), screenHeight.value());
        game.onDraw();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        game.update();
    }



}
