package edu.BT;

import edu.BT.utils.Log;
import edu.BT.views.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        Log.SYSTEM("Closing!");
    }

    public void init() {
        Log log = new Log();
        //RegisterInput.setupInputRegistry();
        Log.SYSTEM("Initialization completed successfully!");
    }

    @Override
    public void start(Stage primaryStage) {
        Log.SYSTEM("Main Thread Started!");
        primaryStage.setTitle("GTNova");
        primaryStage.setResizable(false);
        MainMenu root = new MainMenu();
        primaryStage.setScene(root);
        new Game(root);
        primaryStage.show();
    }
}