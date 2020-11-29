package com.tankv2;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ResoureMgr {


    public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes=new BufferedImage[16];


    static {

        try{
//            goodTankL= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//            goodTankD= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
//            goodTankR= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
//            goodTankU= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));


            goodTankU= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            goodTankD= ImageUtil.rotateImage(goodTankU,-180);
            goodTankR= ImageUtil.rotateImage(goodTankU,90);
            goodTankL= ImageUtil.rotateImage(goodTankU,-90);


            badTankU= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankD= ImageUtil.rotateImage(badTankU,-180);
            badTankR= ImageUtil.rotateImage(badTankU,90);
            badTankL= ImageUtil.rotateImage(badTankU,-90);



            bulletL= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            for (int i = 0; i <16 ; i++) {
                explodes[i]= ImageIO.read(ResoureMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }

            System.out.println("图片加载成功");

        }
        catch(Exception ex){
            System.out.println("加载图片异常");
            ex.printStackTrace();
        }
    }

}
