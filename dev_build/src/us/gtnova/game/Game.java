package us.gtnova.game;

import us.gtnova.lib.Controls;

public class Game {
    private Controls controls;

    public Game() {
        controls = new Controls();
    }

    public void onDraw(){
        controls.update();
    }
}
