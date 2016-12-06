package sample;

import javafx.scene.paint.Color;

/**
 * Created by frdeb on 05/12/2016.
 */
public class Player {

    static int EMPTY = 0;
    static int PLAYER_1 = 1;
    static int PLAYER_2 = 2;

    static private Color player_1_color = Color.WHITE;
    static private Color player_1_selectedColor = Color.YELLOW;

    static private Color player_2_color = Color.BLACK;
    static private Color player_2_selectedColor = Color.GREY;

    static int CURRENT = PLAYER_1;

    static Color getColor(int player) {
        if (player == PLAYER_1)
            return player_1_color;
        else if (player == PLAYER_2)
            return player_2_color;
        return null;
    }

    static Color getSelectedColor(int player)
    {
        return (player == 1 ? player_1_selectedColor : player_2_selectedColor);
    }
}
