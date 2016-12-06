package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Main extends Application {

    private StackPane sp_mainlayout;

    @Override
    public void init() {
        Game game = new Game();

        sp_mainlayout = new StackPane();
        sp_mainlayout.getChildren().add(game);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Abalon");
        primaryStage.setScene(new Scene(sp_mainlayout, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
