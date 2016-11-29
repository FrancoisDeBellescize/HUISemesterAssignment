package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

/**
 * Created by simonleyendecker on 29/11/2016.
 */

public class Hexagone extends Pane {

    public Polyline hexagone = new Polyline();

    public Hexagone(int size, int x, int y, int z)
    {
        double pos_x = size * Math.sqrt(3) * (x + z/2);
        double pos_y = size * 3/2 * z;

        System.out.println(pos_x + 20 * (Math.cos(Math.toRadians(30))));
        System.out.println(pos_y + 20 * (Math.sin(Math.toRadians(30))));

        hexagone.getPoints().addAll(
                pos_x + 20 * (Math.cos(Math.toRadians(30))), pos_y + 20 * (Math.sin(Math.toRadians(30))),
                pos_x + 20 * (Math.cos(Math.toRadians(90))), pos_y + 20 * (Math.sin(Math.toRadians(90))),
                pos_x + 20 * (Math.cos(Math.toRadians(60 * 2 + 30))), pos_y + 20 * (Math.sin(Math.toRadians(60 * 2 + 30))),
                pos_x + 20 * (Math.cos(Math.toRadians(60 * 3 + 30))), pos_y + 20 * (Math.sin(Math.toRadians(60 * 3 + 30))),
                pos_x + 20 * (Math.cos(Math.toRadians(60 * 4 + 30))), pos_y + 20 * (Math.sin(Math.toRadians(60 * 4 + 30))),
                pos_x + 20 * (Math.cos(Math.toRadians(60 * 5 + 30))), pos_y + 20 * (Math.sin(Math.toRadians(60 * 5 + 30))),
                pos_x + 20 * (Math.cos(Math.toRadians(30))), pos_y + 20 * (Math.sin(Math.toRadians(90))));

        hexagone.setFill(Color.LIGHTBLUE);
        hexagone.setStroke(Color.BLACK);

        getChildren().addAll(hexagone);
    }

}
