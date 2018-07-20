package edu.BT.views;

import javafx.scene.Group;
import javafx.scene.Scene;

public class MainMenu extends Scene {
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    private static Group gameRoot = new Group();

    public MainMenu() {
        super(gameRoot, screenWidth, screenHeight);
        //Ui follows. Appended on gameRoot
    }

}
