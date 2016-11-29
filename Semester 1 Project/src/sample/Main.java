package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;

import java.lang.Math.*;

import java.awt.*;

public class Main extends Application {

    private StackPane sp_mainlayout;

    @Override

    public void init()
    {
        sp_mainlayout = new StackPane();
    }

    public void start(Stage primaryStage) throws Exception
    {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(sp_mainlayout, 300, 300));

        sp_mainlayout.getChildren().add(new Hexagone(20, 0, 0, 0).hexagone);
        //createHexagon(20, 1, -1, 0);
        /*createHexagon(20, 0, -1, 1);
        createHexagon(20, -1, 0, 1);
        createHexagon(20, -1, 1, 0);
        createHexagon(20, 0, 1, -1);
        createHexagon(20, 1, 0, -1);*/

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
