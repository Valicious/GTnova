package us.gtnova;

import processing.core.PApplet;
import processing.event.KeyEvent;
import us.gtnova.game.Game;
import us.gtnova.lib.utils.Global;

public class Main extends PApplet {
    private Game game;

    public static void main(String[] args) {
        PApplet.main(new String[]{"us.gtnova.Main"});
    }

    /*void Setup(){}*/
    public void settings() {
        //Property<PApplet> app = new Property<>(this);
        Global.setContext(this);
        size(1000, 700);

        game = new Game();
    }

    public void draw() {
        background(50);
        text(frameRate, 10, 10);
        //frame.setSize(screenWidth.value(), screenHeight.value());
        game.onDraw(frameRate);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        game.update();
    }



}
