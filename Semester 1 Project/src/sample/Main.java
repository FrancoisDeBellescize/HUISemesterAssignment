package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
//                System.out.println((x + i) + " " + (y - i) + " " + z);
                board.put(new Vector3(x + i, y - i, z), new Case(x + i, y - i, z));
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
    public void init() {
        sp_mainlayout = new StackPane();
        initGrid();

        Set<Vector3> keySet = board.keySet();
        Iterator<Vector3> keySetIterator = keySet.iterator();

        while (keySetIterator.hasNext()) {
            Vector3 key = keySetIterator.next();
            Case tmp = (Case)board.get(key);
            sp_mainlayout.getChildren().add(tmp.hexa);
        }
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Abalon");
        primaryStage.setScene(new Scene(sp_mainlayout, 500, 500));

//        sp_mainlayout.getChildren().add(new Hexagone(1, -1, 0));
//        sp_mainlayout.getChildren().add(new Hexagone(0, -1, 1));
//        sp_mainlayout.getChildren().add(new Hexagone(-1, 0, 1));
//        sp_mainlayout.getChildren().add(new Hexagone(-1, 1, 0));
//        sp_mainlayout.getChildren().add(new Hexagone(0, 1, -1));
//        sp_mainlayout.getChildren().add(new Hexagone(1, 0, -1));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
