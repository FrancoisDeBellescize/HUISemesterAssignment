package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Window;

/**
 * Created by simonleyendecker on 29/11/2016.
 */

public class Hexagone extends Pane {

    int x, y, z;
    int strokeSize = 1;

    public Polyline hexagone = new Polyline();

    public Hexagone(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.getChildren().add(hexagone);

        hexagone.setFill(Color.LIGHTBLUE);
        hexagone.setStroke(Color.BLACK);
        hexagone.setStrokeWidth(strokeSize);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);

        double size = width < height ?(width / 7) / 2 : (height / 7) / 2;

        double pos_x = size * Math.sqrt(3) * (x + z / 2);
        double pos_y = size * 3 / 2 * z;

        if (z % 2 != 0 && z > 0)
            pos_x += size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !
        else if (z % 2 != 0 && z < 0)
            pos_x -= size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !

        pos_x += width / 2;
        pos_y += height / 2;

//        System.out.println(pos_x + 20 * (Math.cos(Math.toRadians(30))));
//        System.out.println(pos_y + 20 * (Math.sin(Math.toRadians(30))));

        hexagone.getPoints().addAll(
                pos_x + size * (Math.cos(Math.toRadians(60 * 0 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 0 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 1 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 1 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 2 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 2 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 3 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 3 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 4 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 4 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 5 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 5 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 0 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 0 + 30))));
        hexagone.toFront();
    }
}
