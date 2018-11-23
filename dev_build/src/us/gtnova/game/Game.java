package us.gtnova.game;

import us.gtnova.game.entity.Player;
import us.gtnova.game.world.AssetManager;
import us.gtnova.game.world.WorldGen;
import us.gtnova.lib.Controls;

public class Game {
    private Controls controls;
    private Player player;
    private WorldGen worldGen;

    public Game() {
        /*controls = new Controls();
        player = new Player(100, 100);*/
        //todo: should be placed when world loads
        AssetManager.loadAssets();
        worldGen = new WorldGen();
    }

    public void onDraw() {
        /*player.draw();
        controls.update();*/
    }

    public void update() {
        /*//if  controls.update() stays the only method this method becomes redundant and should
        //be altered to give the key and keycode manually
        controls.update();*/
    }
}
