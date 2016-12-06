package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

/**
 * Created by simonleyendecker on 29/11/2016.
 */

public class Hexagone {

    int x, y, z;

    int strokeSize = 1;

    private static Color hoover = Color.RED;
    private static Color notHoover = Color.BLACK;

    public Polyline shape = new Polyline();

    public Hexagone(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        shape.setFill(Color.LIGHTGREY);
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(strokeSize);
    }

    public void resize(double width, double height) {
        double size = width < height ?(width / 9) / 2 : (height / 9) / 2;

        double pos_x = size * Math.sqrt(3) * (x + z / 2);
        double pos_y = size * 3 / 2 * z;

        if (z % 2 != 0 && z > 0)
            pos_x += size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !
        else if (z % 2 != 0 && z < 0)
            pos_x -= size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !

        shape.getPoints().clear();
        shape.getPoints().addAll(
                pos_x + size * (Math.cos(Math.toRadians(60 * 0 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 0 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 1 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 1 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 2 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 2 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 3 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 3 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 4 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 4 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 5 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 5 + 30))),
                pos_x + size * (Math.cos(Math.toRadians(60 * 0 + 30))), pos_y + size * (Math.sin(Math.toRadians(60 * 0 + 30))));
        shape.toBack();
    }

    public void setHoover(boolean state)
    {

        if (state)
        {
            shape.toFront();
            shape.setStrokeWidth(2.0);
            shape.setStroke(hoover);
        }
        else
        {
            shape.toBack();
            shape.setStrokeWidth(1.0);
            shape.setStroke(notHoover);
        }

        return;
    }
}
