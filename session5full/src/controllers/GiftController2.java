package controllers;

import controllers.Enemy.EnemyControllerManager;
import models.GameObject;
import views.GameDrawer;

import java.util.Iterator;

/**
 * Created by Viet on 8/9/2016.
 */
public class GiftController2 extends SingleController implements Colliable {

    public final static int SPEED = 2;
    public final static int R = 200;
    public GiftController2(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);

    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            Iterator<SingleController> singleControllerIterator =
                    EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController enemyController = singleControllerIterator.next();
                int dx = this.gameObject.getX() - enemyController.gameObject.getX();
                int dy = this.gameObject.getY() - enemyController.gameObject.getY();
                double R1 = Math.sqrt(dx * dx + dy * dy);
                if ( R1 < R ) {
                    enemyController.gameObject.destroy();
                }
            }
        }

    }
}
