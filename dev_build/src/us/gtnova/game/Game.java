package us.gtnova.game;

import us.gtnova.Main;
import us.gtnova.game.Entity.Player;
import us.gtnova.lib.Controls;

public class Game {
    private Controls controls;
    private Player player;
    public static int fps;

    public Game() {
        controls = new Controls();
        player = new Player(100,100);
    }

    //INFINITE LOOP :D
    public void onDraw(float fps) {
        controls.update();
        player.update();
        this.fps = Math.round(fps);
    }

    public void update() {
        //if  controls.update() stays the only method this method becomes redundant and should
        //be altered to give the key and keycode manually
        controls.update();
        player.update();
    }
}
