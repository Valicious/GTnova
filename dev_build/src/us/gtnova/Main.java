package us.gtnova;

import processing.core.PApplet;
import us.gtnova.game.Game;
import us.gtnova.lib.event.GlobalVars;
import us.gtnova.lib.utils.Property;

public class Main extends PApplet {
    private Game game;

    public static void main(String[] args) {
        PApplet.main(new String[]{"us.gtnova.Main"});
    }

    /*void Setup(){}*/
    public void settings() {
        Property<Integer> screenHeight = new Property<>(700);
        Property<Integer> screenWidth = new Property<>(1000);
        Property<PApplet> app = new Property<>(this);

        GlobalVars.put("app", app);
        GlobalVars.put("screenHeight", screenHeight);
        GlobalVars.put("screenWidth", screenWidth);
        size(screenWidth.value(), screenHeight.value());
        frame.setSize(screenWidth.value(), screenHeight.value());
        game = new Game();
    }

    public void draw() {
        background(50);
        game.onDraw();
    }
}
