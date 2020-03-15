package com.xducs.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Linbo Ge
 * @date 2020/3/14 - 10:41
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 30;

        //1.创建一个对象，在内存中创建图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        //画笔对象
        Graphics g = image.getGraphics();
        //设置画笔颜色
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, width, height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
        //生成随机角标
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);
            sb.append(c);
            //2.3写验证码
            g.drawString(c + "", width / 5 * i, 20);
        }
        String checkCode = sb.toString();
        request.getSession().setAttribute("checkCode",checkCode);
        //2.4画干扰线
        g.setColor(Color.GREEN);
        for (int i = 1; i <= 4; i++) {
            //生成随机坐标
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
