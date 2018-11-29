package us.gtnova.game;

import us.gtnova.lib.Controls;

public class Game {
    private Controls controls;

    public Game() {
        controls = new Controls();
    }

    public void onDraw() {
        controls.update();
    }

    public void update() {
        //if  controls.update() stays the only method this method becomes redundant and should
        //be altered to give the key and keycode manually
        controls.update();
    }
}
