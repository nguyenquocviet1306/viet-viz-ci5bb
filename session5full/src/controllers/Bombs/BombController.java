package controllers.Bombs;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Bomb;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Viet on 8/11/2016.
 */
public class BombController extends SingleController implements Colliable {

    public BombController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    public static BombController create(int x, int y) {
        return new BombController(new Bomb(x, y),
                new ImageDrawer("resources/boom1.png"));

    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            NotificationCenter.instance.onBomExplode(gameObject.getX(),gameObject.getY());
            gameObject.destroy();
            Utils.playSound("resources/Explosion.wav",false);

        }



    }
}
