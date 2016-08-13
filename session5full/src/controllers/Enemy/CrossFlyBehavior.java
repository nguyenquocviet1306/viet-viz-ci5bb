package controllers.Enemy;

import controllers.SingleController;
import models.GameObject;
import models.GameVector;

/**
 * Created by Viet on 8/13/2016.
 */
public class CrossFlyBehavior implements FlyBehaviors {
    public static final int SPEED = 3;

    @Override
    public void doFly(SingleController enemyController) {
        GameObject gameObject = enemyController.getGameObject();
        GameVector gameVector = enemyController.getGameVector();
        gameVector.dx = SPEED;
        gameVector.dy = SPEED;
//        if(gameObject.getX() >= 600 || gameObject.getX() <= 0) {
//            gameVector.dx = - gameVector.dx;
//        }

    }

}
