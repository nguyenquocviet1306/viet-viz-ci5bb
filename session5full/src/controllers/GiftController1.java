package controllers;

import controllers.Enemy.EnemyControllerManager;
import models.GameObject;
import views.GameDrawer;

import java.util.Iterator;

/**
 * Created by Viet on 8/8/2016.
 */
public class GiftController1 extends SingleController implements Colliable {
    public static final int SPEED = 5;
    public GiftController1(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = SPEED;
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            Iterator<SingleController> singleControllerIterator = EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController enemyController = singleControllerIterator.next();
                enemyController.gameObject.destroy();
        }
    }

    }
}
