package controllers;

import models.Gift;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Viet on 8/9/2016.
 */
public class GiftControllerManager extends ControllerManager {

    private GiftControllerManager() {
        super();
    }
    private int count;
//    @Override
//    public void run() {
//        super.run();
//        count++;
//        Random rand = new Random();
//        if(count == 300) {
//            count = 0;
//            int enX = 100;
//            int enY = rand.nextInt(500);
//            GiftController1 giftController1 = new GiftController1(
//                    new Gift(enX,enY),
//                    new ImageDrawer("resources/boom1.png")
//            );
//            this.add(giftController1);
//        }
//        else if (count == 200) {
//            int enX = rand.nextInt(700);
//            int enY = 0;
//            GiftController2 giftController2 = new GiftController2(
//                    new Gift(enX,enY),
//                    new ImageDrawer("resources/boom2.png")
//            );
//            this.add(giftController2);
//        }
//    }
    public final static GiftControllerManager instance = new GiftControllerManager();
}
