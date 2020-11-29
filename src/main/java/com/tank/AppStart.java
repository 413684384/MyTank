package com.tank;


import java.util.Random;

public class AppStart {
    public static void main(String[] args) throws Exception {

        TankFrame tf=new TankFrame();
        Random random=new Random();
        for (int i = 0; i <100 ; i++) {
            Tank tank = new Tank(10 + 50 * i, 0+random.nextInt(100), Dir.DOWN,Group.BAD,tf);
            tank.setMoving(true);

            tf.badTanks.add(tank);
        }

        while(true){
            Thread.sleep(35);
            tf.repaint();
        }

    }

}
