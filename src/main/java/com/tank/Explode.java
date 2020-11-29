package com.tank;

import java.awt.*;

public class Explode {

    public int x,y;
    public static final int WIDTH=ResoureMgr.explodes[0].getWidth();
    public static final int HEIGHT=ResoureMgr.explodes[0].getHeight();
    public TankFrame tf=null;
    public boolean  living=true;
    private int step=0;

    public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;

        //new Thread(()->new Audio("audio/explode.wav").play()).start();

    }

    public void paint(Graphics g){
//        Color c=g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(c);

        g.drawImage(ResoureMgr.explodes[step++],x,y,null);
        if(step>=ResoureMgr.explodes.length){
            tf.explodeList.remove(this);
        }

    }




}
