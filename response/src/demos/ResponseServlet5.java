package demos;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 服务器通过字节流输出数据到浏览器
 */
@WebServlet(name = "ResponseServlet5", urlPatterns = "/responseServlet5")
public class ResponseServlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图片的宽高
        int width = 100;
        int height = 100;

        //创建一个对象,能在内存中去画图(这个图就是验证码的图片对象)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        //创建填充图片的画笔对象,填充背景色,
        Graphics graphics = image.getGraphics();
        //给画笔设置颜色
        graphics.setColor(Color.pink);
        //填充矩形,就相当于设置背景色
        graphics.fillRect(0, 0, width, height);
        //画边框,用来填充数字
        graphics.setColor(Color.blue);
        //从0,0开始画
        graphics.drawRect(0, 0, width - 1, height - 1);

        //设置验证码可能出现的所有中文
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        //随机生成其中的几个下标
        Random rand = new Random();
        for (int i = 1; i <= 4; i++) {
            int j = rand.nextInt(str.length() + 1);
            //获取随机字符
            char c = str.charAt(j);
            //写验证码
            graphics.drawString(c+"", 20*i, 50);
        }

        //生成10条随机的线
        for (int i = 0; i < 10; i++) {
            //随机生成坐标点
            int x1 = rand.nextInt(width);
            int x2 = rand.nextInt(width);

            int y1 = rand.nextInt(height);
            int y2 = rand.nextInt(height);
            //在验证码上面画一些横线
            graphics.setColor(Color.green);
            graphics.drawLine(x1,x2,y1,y2);
        }

        //将图片输出到页面,展示给用户看
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
