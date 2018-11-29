package us.gtnova.game;

import us.gtnova.Main;
import us.gtnova.game.Entity.Player;
import us.gtnova.lib.Controls;

public class Game {
    private Controls controls;
    private Player player;

    public Game() {
        controls = new Controls();
        player = new Player(100,100);
    }

    public void onDraw() {
        controls.update();
        player.update();
    }

    public void update() {
        //if  controls.update() stays the only method this method becomes redundant and should
        //be altered to give the key and keycode manually
        controls.update();
    }
}
