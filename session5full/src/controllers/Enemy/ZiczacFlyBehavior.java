package controllers.Enemy;

import controllers.SingleController;
import models.GameObject;
import models.GameVector;

import java.util.Random;

/**
 * Created by Viet on 8/13/2016.
 */
public class ZiczacFlyBehavior implements FlyBehaviors {
    public static final int SPEED1 = 2;
    private int count;

    @Override
    public void doFly(SingleController enemyController) {
//        GameObject gameObject = enemyController.getGameObject();
////        GameVector gameVector = enemyController.getGameVector();

        if (enemyController.getGameVector().dx >= 0) {
            enemyController.getGameVector().dy = SPEED1;
            enemyController.getGameVector().dx = SPEED1;
        }


//        Random rand = new Random();
//        count = rand.nextInt(200);
//        if (count == 50) {
//            count = 0;
//            System.out.println("1");
//            enemyController.getGameVector().dx = -enemyController.getGameVector().dx;
////        }
            if (enemyController.getGameObject().getX() >= 300 ) {
                enemyController.getGameVector().dx = -SPEED1;
                System.out.println("1");
            }
            if (enemyController.getGameObject().getX() <= 100) {
                enemyController.getGameVector().dx = SPEED1;
            }

        }
    }


