package controllers.Bombs;

import models.GameObject;

/**
 * Created by Viet on 8/12/2016.
 */
public interface FreezzeSubcriber {
    void onFrezze(int x, int y);
    GameObject getGameObject();
}
