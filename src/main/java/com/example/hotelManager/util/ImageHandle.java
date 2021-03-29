package com.example.hotelManager.util;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageHandle {
    //config 配置当前文件存储位置
    public static String Dir="E://uploadImage/";
    public static String targetDir="E://VueWorkSpace/project/static/";
    //转换图像目标高度
    public static int width= 250;
    public static int height = 300;
    /*
    @param srcImageFile 要缩放的图片路径
    @param targetPath 缩放后的图片路径
    @param width 目标宽度像素
    @param height 目标高度像素
     */

    public void ImageCutting(String srcImageFile,String targetPath,int width,int height)
    {
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(srcImageFile));
            //字节流转图像对象
            Image bi = ImageIO.read(in);
            //构建图片流
            BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
            //绘制改变尺寸后的图
            tag.getGraphics().drawImage(bi,0,0,width,height,null);
            //输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetPath));
            ImageIO.write(tag,"JPEG",out);
            in.close();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//@Test
//    public static void main(String args[])
//    {
//
//        String srcImageFile= Dir+"P2.jpg";
//        String targetPath = targetDir +"P2.jpg";
//        new ImageHandle().ImageCutting(srcImageFile,targetPath,width,height);
//    }
}
