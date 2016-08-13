package controllers.Enemy;

import controllers.Bombs.FreezzeSubcriber;
import controllers.Bombs.NotificationCenter;
import controllers.Bombs.BombSubscriber;
import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Viet on 7/31/2016.
 */
public class EnemyController extends
        SingleController implements Colliable,BombSubscriber,FreezzeSubcriber {

    public static final int SPEED = 5;
    private EnemyState enemyState;
    private EnemyDirectionType enemyDirectionType;
    private int frezzeCount;
    private int FREZZE_PERIOD = 200;
    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private CrossFlyBehavior crossFlyBehavior;
    private ZiczacFlyBehavior ziczacFlyBehavior;
    private StraightShotBehavior straightShotBehavior;


    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior,
                           CrossFlyBehavior crossFlyBehavior,
                           ZiczacFlyBehavior ziczacFlyBehavior,
                           StraightShotBehavior straightShotBehavior) {
        super(gameObject, gameDrawer);

//        this.gameVector.dx = SPEED;
//        this.gameVector.dy = SPEED;

        CollsionPool.instance.add(this);
        NotificationCenter.instance.subscribe(this);
        NotificationCenter.instance.subcribeFrezze(this);
        enemyState = EnemyState.NORMAL;
        enemyDirectionType = EnemyDirectionType.STRAIGHT;
        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.crossFlyBehavior = crossFlyBehavior;
        this.ziczacFlyBehavior = ziczacFlyBehavior;
        this.straightShotBehavior = straightShotBehavior;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    public EnemyDirectionType getEnemyDirectionType() {
        return enemyDirectionType;
    }

    public void setEnemyDirectionType(EnemyDirectionType enemyDirectionType) {
        this.enemyDirectionType = enemyDirectionType;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create( int x, int y, EnemyPlaneType type ) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(new Enemy( x , y ),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(200),null,null,
                        new ZiczacFlyBehavior(),
                        new StraightShotBehavior());

                break;
            case WHITE:
                enemyController = new EnemyController(new Enemy( x , y ),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(300),
                        new FollowShotBehavior(),
                        new CrossFlyBehavior(),null,null);

//                enemyController = new EnemyController2(new Enemy( x , y ),
//                        new ImageDrawer("resources/enemy_plane_white_1.png"));

                break;

        }
        return enemyController;
    }


    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();

    }


    @Override
    public void run() {

        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }
        if (freezeBehavior != null)
        freezeBehavior.run(this);
        if (shotBehavior != null)
            shotBehavior.doShot(this);
        if (crossFlyBehavior != null)
            crossFlyBehavior.doFly(this);
        if (ziczacFlyBehavior != null)
            ziczacFlyBehavior.doFly(this);
        if (straightShotBehavior != null)
            straightShotBehavior.doShot(this);

    }

    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyState.FREZZED;
        frezzeCount = 0;


    }
}

