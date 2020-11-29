package com.tankv2;

public class FireStrageFourDirImpl implements FireStrage {
    @Override
    public void fire(Tank tank) {
        int bx=tank.x+ Tank.WIDTH/2- Bullet.WIDTH/2;
        int by=tank.y+ Tank.HEIGHT/2- Bullet.HEIGHT/2;
        for(Dir dir: Dir.values()){
            new Bullet(bx,by,dir,tank.group,tank.tf);
        }

    }
}
