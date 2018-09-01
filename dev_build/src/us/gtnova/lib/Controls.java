package us.gtnova.lib;

import processing.core.PApplet;
import us.gtnova.lib.event.GlobalVars;

import java.util.HashMap;
import java.util.Set;

import static us.gtnova.lib.event.PubSub.sendMessage;

public class Controls {
    //TODO save and load controls to a file
    private HashMap<Character,Set<>>

    public Controls() {

    }

    public void update(){
        PApplet app = GlobalVars.get("app");
        if (app.keyPressed){

        }
        sendMessage("key_W");
    }
}

