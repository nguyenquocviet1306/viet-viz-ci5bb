package models;

/**
 * Created by Viet on 8/11/2016.
 */
public class Bomb extends GameObject {
    public final static int WIDTH = 32;
    public final static int HEIGHT = 32;

    public Bomb(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
