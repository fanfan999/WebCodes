
package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 记住上一次访问时间案例
 */

@WebServlet(name = "RememberTimeServlet", urlPatterns = "/rememberTimeServlet")
public class RememberTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体的数据格式以及编码
        response.setContentType("text/html;charset=Unicode");

        //定义一个布尔变量,看是否存在有time这个键的cookie
        boolean flag = false;
        //获取cookie中的值
        Cookie[] cookies = request.getCookies();
        //遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie c: cookies) {
                //获取cookie的名称
                String name = c.getName();
                //判断名称是否为time,存在表示不是第一次访问
                if (name.equals("time")) {
                    //cookie中有time这个键
                    flag = true;
                    //获取当前时间字符串,重新设置cookie的value重新发送

                    //创建时间Date对象
                    Date date = new Date();
                    //将时间格式化
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    //获取当前时间
                    String nowTime = sdf.format(date);
                    //响应数据
                    //首先获取cookie的value
                    String value = c.getValue();
                    //为了使cookie能识别特殊字符,将采用URL编码
                    nowTime = URLEncoder.encode(nowTime, "Unicode");
                    //将cookie设置为当前时间
                    c.setValue(nowTime);
                    //设置cookie的保存时间为一小时
                    c.setMaxAge(60*60);
                    //重新发送回去
                    response.addCookie(c);

                    System.out.println("解码前 : " + value);
                    //在这里要对其进行URL解码,因为之前对其进行了编码操作
                    value = URLDecoder.decode(value, "Unicode");
                    System.out.println("解码后 : " + value);
                    response.getWriter().write("<h1>欢迎回来!您上次的访问时间为 : " + value + "</h1>");
                    System.out.println("编码前 : " + value);

                    //不需要获取下一个,直接退出
                    break;
                }
            }
        }

        //当不存在有time的cookie的时候,表示是第一次访问
        if (cookies == null|| cookies.length <= 0 || flag == false) {
            response.getWriter().write("<h1>欢迎您首次访问!</h1>");
            //获取当前时间字符串,设置为cookie的value重新发送

            //创建时间Date对象
            Date date = new Date();
            //将时间格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //获取当前时间
            String nowTime = sdf.format(date);
            //为了使cookie能识别特殊字符,将采用URL编码
            nowTime = URLEncoder.encode(nowTime, "Unicode");
            Cookie c = new Cookie("time", nowTime);
            //将cookie设置为当前时间
            c.setValue(nowTime);
            //设置cookie的保存时间为一小时
            c.setMaxAge(60*60);
            //重新发送回去
            response.addCookie(c);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

