package com.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {


    public static int GAME_WIDTH=1300,GAME_HEIGHT=900;

    Tank myTank=new Tank(GAME_WIDTH/2,GAME_HEIGHT-80,Dir.UP,Group.GOOD,this);


    List<Bullet> bullets=new ArrayList<Bullet>();

    List<Tank> badTanks=new ArrayList<>();

    List<Explode> explodeList=new ArrayList<>();


    //Explode e=new Explode(100,100,this);

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setLocation(0,0);
        this.setResizable(false);
        this.setTitle("坦克大战");
        this.setVisible(true);
        this.addKeyListener(new MyKeyLisenter());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(Color.RED);
        g.drawString("坦克数量"+badTanks.size(),10,0);
        g.drawString("子弹数量"+bullets.size(),10,10);
        g.drawString("爆炸数量"+explodeList.size(),10,20);

        myTank.paint(g);

        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }


        for(int i=0;i<badTanks.size();i++){
            badTanks.get(i).paint(g);
        }

        for(int i=0;i<explodeList.size();i++){
            explodeList.get(i).paint(g);
        }


        //碰撞检测
        for (int i = 0; i <bullets.size() ; i++) {
            for (int j = 0; j <badTanks.size() ; j++) {
                bullets.get(i).collateWith(badTanks.get(j));
            }


        }





    }

    class  MyKeyLisenter extends KeyAdapter {

        boolean bL=false;
        boolean bR=false;
        boolean bU=false;
        boolean bD=false;

        @Override
        public void keyPressed(KeyEvent e) {

            int key=e.getKeyCode();

            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key=e.getKeyCode();

            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;

                default:
                    break;
            }


        }

        private void setMainTankDir() {


            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(bL==true){myTank.setDir(Dir.LEFT);}
                if(bR==true){myTank.setDir(Dir.RIGHT);}
                if(bU==true){myTank.setDir(Dir.UP);}
                if(bD==true){myTank.setDir(Dir.DOWN);}
            }


        }
    }
}
