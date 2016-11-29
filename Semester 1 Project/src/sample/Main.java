package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Hashtable;

public class Main extends Application {

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
                board.put(new Vector3(x, y, z), new Case());
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
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        initGrid();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
