package controllers.Bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Viet on 8/11/2016.
 */

public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezzeSubcriber> freezzeSubcribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezzeSubcribers = new Vector<FreezzeSubcriber>();
    }

    public void subscribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subcribeFrezze(FreezzeSubcriber bombSubscriber) {
        freezzeSubcribers.add(bombSubscriber);
    }

    public void onBomExplode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while (bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if (!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {

                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onFrezze(int x, int y){
        Iterator<FreezzeSubcriber> bombSubcriberIterator = freezzeSubcribers.iterator();
        while (bombSubcriberIterator.hasNext()) {
            FreezzeSubcriber freezzeSubcriber = bombSubcriberIterator.next();
            if (!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubcriberIterator.remove();
            } else {

                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}

