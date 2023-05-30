package com.qfedu.servlets;

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

@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收客户端请求生成一个验证码图片响应给客户端

        //使用awt工具包动态生成一个验证码
        //创建一张图片
        int width = 300;//验证码的宽度
        int height = 90;//验证码的高度
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //绘制图片
        //从图片对象中获取绘制图片的笔
        Graphics2D pen = image.createGraphics();

        //绘制背景
        pen.setColor(getRandomColor());
        //fillRect绘制实心矩形
        pen.fillRect(0, 0, width, height);
        //绘制验证码字符串
        int letterNum = 4;//验证码上的字符的个数
        int space = 20;//验证码图片字母空隙
        int letterWidth = (width-space * (letterNum+1))/letterNum;//计算每个字母占据的宽度
        //每循环一次绘制一个字母
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i=0; i < letterNum; i++){
            int ascii = random.nextInt(26) + 97;
            byte[] bs = new byte[1];
            bs[0] = (byte) ascii;
            String letter = new String(bs);
            code.append(letter);
            pen.setColor(getRandomColor());
            //绘制字母
            pen.setFont(new Font("Gulim", Font.BOLD, random.nextInt(31)+40));
            pen.drawString(letter, space+(letterWidth+space)*i, height-space);
        }
        String vCode = code.toString();
        //将生成的验证码存入session
        HttpSession session = req.getSession();
        session.setAttribute("vCode", vCode);

        //为了让图片不是很容易被程序识别可以绘制干扰线

        //图片绘制完成之后，将图片通过response的输出流响应到客户端
        ImageIO.write(image, "png", resp.getOutputStream());
    }

    private Color getRandomColor(){
        int r = (int) Math.floor(Math.random() * 256);
        int g = (int) Math.floor(Math.random() * 256);
        int b = (int) Math.floor(Math.random() * 256);
        return new Color(r, g, b);
    }
}
