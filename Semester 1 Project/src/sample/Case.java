package sample;

import javafx.scene.paint.Color;

/**
 * Created by simonleyendecker on 22/11/2016.
 */

public class Case {
    boolean hoover = false;
    public int pos_x;
    public int pos_y;
    public int pos_z;

    public Hexagone hexa;
    public Ball contained;

    public Case(int x, int y, int z) {
        this.contained = null;
        this.pos_x = x;
        this.pos_y = y;
        this.pos_z = z;

        hexa = new Hexagone(x, y, z);
    }

    void setHoover(boolean newState) {
        hoover = newState;

        if (hoover)
        {
            hexa.shape.setStroke(Color.RED);
            hexa.shape.setStrokeWidth(2.0);
            hexa.shape.toFront();
        }
    }

    boolean getHoover() {
        return hoover;
    }
}
