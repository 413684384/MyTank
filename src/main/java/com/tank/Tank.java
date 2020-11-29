package com.tank;

import java.awt.*;
import java.util.Random;


public class Tank {

    public int x=200,y=200;
    Dir dir=Dir.DOWN;
    private static final int SPEED=5;
    private boolean moving=false;
    TankFrame tf=null;

    public Group group=Group.GOOD;
    FireStrage fireStrage=null;

    private boolean living=true;
    Random random=new Random();




    public static final int WIDTH = ResoureMgr.goodTankL.getWidth();
    public static final int HEIGHT = ResoureMgr.goodTankL.getHeight();

    public Rectangle rect=new Rectangle();
    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf=tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;


    }

    public void paint(Graphics g){
//        Color c=g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,30,30);
//        g.setColor(c);

        if(!living){
            tf.badTanks.remove(this);
            return ;
        };
        switch(dir){
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResoureMgr.goodTankL:ResoureMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResoureMgr.goodTankR:ResoureMgr.badTankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResoureMgr.goodTankU:ResoureMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResoureMgr.goodTankD:ResoureMgr.badTankD,x,y,null);
                break;
        }

        move();

    }
    public void fire() {
//        int bx=this.x+ Tank.WIDTH/2-Bullet.WIDTH/2;
//        int by=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
//        tf.bullets.add(new Bullet(bx,by,this.dir,this.group,this.tf));
        if(this.group==Group.GOOD){
            fireStrage=new FireStrageFourDirImpl();
        }else{
            fireStrage=new FireStrageDefaultImpl();
        }

        fireStrage.fire(this);

    }

    private void move() {

        if(!moving) return;
        switch(dir){
            case LEFT:
                x -=SPEED;
                break;
            case RIGHT:
                x +=SPEED;
                break;
            case UP:
                y -=SPEED;
                break;
            case DOWN:
                y +=SPEED;
                break;
            default:
                break;
        }

        if(this.group==Group.BAD&&random.nextInt(100)>95){
            this.fire();
        }

        if(this.group==Group.BAD&&random.nextInt(100)>95){
            randomDir();
        }

        bounderyCheck();

        rect.x=this.x;
        rect.y=this.y;

    }
    public void bounderyCheck(){
        if(this.x<0){ this.x=0;}
        if(this.x>TankFrame.GAME_WIDTH-50){this.x=TankFrame.GAME_WIDTH-50;}
        if(this.y<20){this.y=20;}
        if(this.y>TankFrame.GAME_HEIGHT-50){this.y=TankFrame.GAME_HEIGHT-50;}
    }


    public void randomDir(){
        this.dir=Dir.values()[random.nextInt(4)];
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void die() {
        this.living=false;
    }
}
