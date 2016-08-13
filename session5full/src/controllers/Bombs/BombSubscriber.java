package controllers.Bombs;

import models.GameObject;

/**
 * Created by Viet on 8/12/2016.
 */
public interface BombSubscriber {
    public void onBombExplode (int x, int y);
    public GameObject getGameObject();
}
