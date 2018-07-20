package edu.BT.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class MainMenu extends Scene {
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    private static Group gameRoot = new Group();
    public Canvas temp = new Canvas(screenWidth,screenHeight);

    public MainMenu() {
        super(gameRoot, screenWidth, screenHeight);
        //Ui follows. Appended on gameRoot

        temp.setLayoutX(0);
        temp.setLayoutY(0);
    }

    public Canvas GetCanvas(){
        return temp;
    }

}
