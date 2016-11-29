package sample;


import java.lang.reflect.Array;

/**
 * Created by simonleyendecker on 22/11/2016.
 */

public class Case {

    public static final int EMPTY = 0;
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;

    public int pos_x;
    public int pos_y;
    public int pos_z;

    public Ball contained;

    public Case[] siblings = new Case[6];

    public Case(int x, int y, int z)
    {
        this.contained = null;
        this.pos_x = x;
        this.pos_y = y;
        this.pos_z = z;
    }

}
