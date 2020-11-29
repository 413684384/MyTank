package com.tank;

import java.awt.*;

public class Bullet {
    private int x,y;
    private static final int SPEED=18;
    private Dir dir;


    public static final int WIDTH=ResoureMgr.bulletD.getWidth();
    public static final int HEIGHT=ResoureMgr.bulletD.getHeight();


    public TankFrame tf=null;

    public boolean  living=true;

    private Group group=Group.BAD;


    public Rectangle rect=new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf=tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;


        tf.bullets.add(this);


    }

    public void paint(Graphics g){
//        Color c=g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(c);
        if(!living){ tf.bullets.remove(this);}
        switch(dir){
            case LEFT:
                g.drawImage(ResoureMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResoureMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResoureMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResoureMgr.bulletD,x,y,null);
                break;
        }

        move();

    }
    private void move() {



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

        rect.x=this.x;
        rect.y=this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }


    public void collateWith(Tank tank) {

        if(this.group.equals(tank.getGroup()))return;

        if(this.rect.intersects(tank.rect)){
            this.die();
            tank.die();
            int ex=tank.getX()+ Tank.WIDTH/2-Explode.WIDTH/2;
            int ey=tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
            this.tf.explodeList.add(new Explode(ex,ey,this.tf));
        }
    }

    private void die() {
        this.living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
