package com.drcnet.mc.bigdata.bmap.Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 图片验证码
 * 
 * @author qi.sun
 * @time 2018年12月17日 上午10:30:46
 */
public class ValidateCodeUtil {

    private static Validate validate = null; // 验证码类，用于最后返回此对象，包含验证码图片base64和真值
    private static Random random = new Random(); // 随机类，用于生成随机参数
    private static String randString = "0123456789acdefhjkmnprtuvwxyACDEFGHJKLMNPQRTUVWXY";// 随机生成字符串的取值范围

    private static int width = 120; // 图片宽度
    private static int height = 40; // 图片高度
    private static int stringSize = 4; // 字符的数量
    private static int lineSize = 40; // 干扰线数量

    /**
     * 绘制字符串
     */
    private static String drawString(Graphics g, String randomString, int i) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Fixedsys", Font.CENTER_BASELINE, 25)); // 设置字体
        g2d.setColor(new Color(random.nextInt(128), random.nextInt(128),
            random.nextInt(128)));// 设置颜色
        String randChar = String
            .valueOf(randString.charAt(random.nextInt(randString.length())));// 随机字符
        randomString += randChar; // 组装
        int rot = random.nextInt(10) - 5;
        g2d.translate(random.nextInt(2) + 1, random.nextInt(2) + 3);
        g2d.rotate(rot * Math.PI / 180);
        g2d.drawString(randChar, width / stringSize * i, 20);
        g2d.rotate(-rot * Math.PI / 180);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private static void drawLine(Graphics g) {
        // 起点(x,y) 偏移量x1、y1
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.setColor(new Color(random.nextFloat(), random.nextFloat(),
            random.nextFloat()));
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 生成Base64图片验证码
     */
    public static Validate getRandomCode() {
        validate = validate == null ? new Validate() : validate;
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 获得BufferedImage对象的Graphics对象
        g.fillRect(0, 0, width, height);// 填充矩形
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drawLine(g);
        }
        // 绘制字符
        String randomString = "";
        for (int i = 0; i < stringSize; i++) {
            randomString = drawString(g, randomString, i);
            validate.setValue(randomString);
        }

        g.dispose();// 释放绘图资源
        ByteArrayOutputStream bs = null;
        try {
            bs = new ByteArrayOutputStream();
            ImageIO.write(image, "png", bs);// 将绘制得图片输出到流
            byte[] bytes = bs.toByteArray();
            String imgsrc = Base64.getEncoder().encodeToString(bytes);
            validate.setBase64(imgsrc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                bs = null;
            }
        }
        return validate;
    }

    /**
     * 
     * @ClassName: Validate
     * @Description: 验证码类
     * @author chenhx
     * @date 2017年11月14日 上午11:35:34
     */
    public static class Validate implements Serializable {
        private static final long serialVersionUID = 1L;
        private String base64; // Base64值
        private String value; // 验证码值

        public String getBase64() {
            return base64;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
