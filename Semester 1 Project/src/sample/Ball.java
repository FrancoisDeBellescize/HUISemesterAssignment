package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * Created by simonleyendecker on 22/11/2016.
 */

public class Ball {
    Circle shape;
    int stroke = 1;
    int player;
    int x, y, z;

    Ball(int player, Vector3 pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        this.player = player;
        shape = new Circle();
        shape.setStrokeWidth(stroke);
        shape.setFill(Player.getColor(player));
    }

    public void resize(double width, double height) {
        double size = width < height ?(width / 9) / 2 : (height / 9) / 2;
        double pos_x = size * Math.sqrt(3) * (x + z / 2);
        double pos_y = size * 3 / 2 * z;

        if (z % 2 != 0 && z > 0)
            pos_x += size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !
        else if (z % 2 != 0 && z < 0)
            pos_x -= size - (size / 7); // Pourquoi size / 7 ? Je ne sais pas ... a méditer !

//        System.out.println("x:" + pos_x + " y:" + pos_y + " r:" + size);
        shape.setRadius(size / 2);
        shape.setCenterX(pos_x);
        shape.setCenterY(pos_y);
        shape.toFront();
    }
}
