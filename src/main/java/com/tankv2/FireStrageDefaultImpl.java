package com.tankv2;

public class FireStrageDefaultImpl implements FireStrage {
    @Override
    public void fire(Tank tank) {

        int bx=tank.x+ Tank.WIDTH/2- Bullet.WIDTH/2;
        int by=tank.y+ Tank.HEIGHT/2- Bullet.HEIGHT/2;
        new Bullet(bx,by,tank.dir,tank.group,tank.tf);
    }
}
