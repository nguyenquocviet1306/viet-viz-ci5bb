package controllers.Enemy;

import controllers.PlaneController;
import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by Viet on 8/12/2016.
 */
public class FollowShotBehavior implements ShotBehavior{
    public final static int BULLET_SPEED = 4;
    public final static int SHOT_PERIOD = 20;

    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();

            EnemyBulletController enemyBulletController =
                    new EnemyBulletController(
                            new EnemyBullet( gameObject.getMiddleX() - EnemyBullet.SIZE / 2, gameObject.getBottom()),
                            new ImageDrawer("resources/enemy_bullet.png")
                    );
            int dx = PlaneController.instance.getGameObject().getX() - gameObject.getX();
            int dy = PlaneController.instance.getGameObject().getY() - gameObject.getY();

            if (dy > 0) {
                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;

                enemyBulletController.getGameVector().dy = (int)(dy / ratio);
                enemyBulletController.getGameVector().dx = (int)(dx / ratio);

                EnemyBulletControllerManager.instance.add(enemyBulletController);
            }

        }
        }


//        if(this.gameObject.getX() >= 600 || this.gameObject.getX() <= 0) {
//            this.gameVector.dx = -this.gameVector.dx;
//        }



}
