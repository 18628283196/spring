package com.itheima.cocntroller;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;


public class ImgUtil {

    public static void main(String[] args) throws ParseException {

        String bigImg = "E:\\360downloads\\323763.jpg";
        String smallImg = "E:\\360downloads\\1000295.jpg";
        String content = "好久不见，你还好吗";
        String outPath = "E:\\360downloads\\" + System.currentTimeMillis() + ".jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, smallImg, 1000, 300, null, 200, 200, outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /***
     * 在一张大图张添加小图和文字
     * @param bigImgPath 大图的路径
     * @param smallImgPath 小图的路径
     * @param sx    小图在大图上x抽位置
     * @param sy    小图在大图上y抽位置
     * @param content   文字内容
     * @param cx    文字在大图上y抽位置
     * @param cy    文字在大图上y抽位置
     * @param outPathWithFileName 结果输出路径
     */
    public static void bigImgAddSmallImgAndText(String bigImgPath
            , String smallImgPath, int sx, int sy
            , String content, int cx, int cy
            , String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //小图片的路径
        ImageIcon imgIcon = new ImageIcon(smallImgPath);
        //得到Image对象。
        Image img = imgIcon.getImage();
        //将小图片绘到大图片上,5,300 .表示你的小图片在大图片上的位置。
        g.drawImage(img, sx, sy, null);
        //设置颜色。
        g.setColor(Color.WHITE);

        //最后一个参数用来设置字体的大小
        if (content != null) {
            Font f = new Font("宋体", Font.PLAIN, 25);
            Color mycolor = Color.red;//new Color(0, 0, 255);
            g.setColor(mycolor);
            g.setFont(f);
            g.drawString(content, cx, cy); //表示这段文字在图片上的位置(cx,cy) .第一个是你设置的内容。
        }
        g.dispose();
        OutputStream os = new FileOutputStream(outPathWithFileName);
        //创键编码器，用于编码内存中的图象数据。
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }

}
