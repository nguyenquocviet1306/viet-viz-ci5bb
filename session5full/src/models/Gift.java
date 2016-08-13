package models;

/**
 * Created by Viet on 8/8/2016.
 */
public class Gift extends GameObject {

    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Gift(int x, int y ) {
        this(x, y, WIDTH, HEIGHT);
    }



}
