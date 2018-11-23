package us.gtnova.game.world;

import java.util.HashMap;
import java.util.HashSet;

public class AssetManager {
    private static final String rootPath = "Blocks/";
    private static HashMap<String,String> tiles;

    public static void loadAssets(){
        //loading tiles
        tiles = new HashMap<>();
        tiles.put("Sand",rootPath+"Sand.png");
        tiles.put("Dirt",rootPath+"Dirt.png");
        tiles.put("Stone",rootPath+"Stone.png");
    }
}
