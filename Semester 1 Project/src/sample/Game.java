package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Game extends Pane {

    double width;
    double height;
    Case lastHoover = null;
    Hashtable board;

    Game() {
        initGrid();

        Set<Vector3> keySet = board.keySet();
        Iterator<Vector3> keySetIterator = keySet.iterator();

        while (keySetIterator.hasNext()) {
            Vector3 key = keySetIterator.next();
            Case tmp = (Case) board.get(key);
            getChildren().add(tmp.hexa.shape);
        }
        setBalls();

        // Mouse move event
        setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double size = width < height ? (width / 9) / 2 : (height / 9) / 2;
                int x = (int) Math.round((event.getX() * Math.sqrt(3) / 3 - event.getY() / 3) / size);
                int z = (int) Math.round(event.getY() * 2 / 3 / size);
                int y = (int) Math.round(-x - z);


                Case hoover = (Case) board.get(new Vector3(x, y, z));

                if (lastHoover != null) {
                    lastHoover.setHoover(false);
                }

                if (hoover != null) {
                    hoover.setHoover(true);
                    lastHoover = hoover;
                }
            }
        });
    }

    void initGrid() {
        board = new Hashtable();

        int x = 0;
        int y = 4;
        int z = -4;

        int line_size = 5;
        int size_map = 9;

        for (int j = 0; j < size_map; j++) {
            for (int i = 0; i < line_size; i++) {
                System.out.println("x:" + (x + i) + " y:" + (y - i) + " z:" + z);
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


    void setBalls() {
        Set<Vector3> keySet = board.keySet();
        Iterator<Vector3> keySetIterator = keySet.iterator();

        while (keySetIterator.hasNext()) {
            Vector3 key = keySetIterator.next();
            Case tmp = (Case) board.get(key);
            Ball ball = null;

            if (key.z <= -3 || key.z == -2 && key.y <= 2 && key.y >= 0) {
                ball = new Ball(Player.PLAYER_1, key);
            } else if (key.z >= 3 || key.z == 2 && key.y <= 0 && key.y >= -2)
                ball = new Ball(Player.PLAYER_2, key);

            if (ball != null) {
                tmp.contained = ball;
                getChildren().add(ball.shape);
            }
        }
    }

    @Override
    public void resize(double width, double height) {
        this.width = width;
        this.height = height;

        Set<Vector3> keySet = board.keySet();
        Iterator<Vector3> keySetIterator = keySet.iterator();

        while (keySetIterator.hasNext()) {
            Vector3 key = keySetIterator.next();
            Case tmp = (Case) board.get(key);
            tmp.hexa.resize(width, height);
            if (tmp.contained != null)
                tmp.contained.resize(width, height);
        }
    }
}
