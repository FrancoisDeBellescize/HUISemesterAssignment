package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Hashtable;

public class Main extends Application {

    private StackPane sp_mainlayout;
    Hashtable board;


    void initGrid() {
        board = new Hashtable();

        int x = 0;
        int y = 3;
        int z = -3;

        int line_size = 4;
        int size_map = 7;

        for (int j = 0; j < size_map; j++) {
            for (int i = 0; i < line_size; i++) {
                board.put(new Vector3(x, y, z), new Case(x, y, z));
            }
            if (j < size_map / 2) {
                x -= 1;
                line_size += 1;
            } else {
                y -= 1;
                line_size -= 1;
            }
            z += 1;
        }
    }

    @Override
    public void init()
    {
//        initGrid();
        sp_mainlayout = new StackPane();
        sp_mainlayout.getChildren().add(new Hexagone(20, 0, 0, 0));
    }

    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(sp_mainlayout, 300, 300));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
