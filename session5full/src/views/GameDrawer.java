package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by Viet on 7/30/2016.
 */
public interface GameDrawer {
    void draw(Graphics g, GameObject gameObject);
}
