package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RememberTimeServlet2", urlPatterns = "/rememberTimeServlet2")
public class RememberTimeServlet2 extends HttpServlet {

    public String getTime() throws UnsupportedEncodingException {
        //获取时间并且对其进行格式化
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println("当前时间 : " + time);
        //由于cookie不支持空格这些特殊符号,所以需要将其转换为url编码
        time = URLEncoder.encode(time, "Unicode");

        return time;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=Unicode");

        //该布尔变量用于判断是否已经有指定键值对的cookie对象
        boolean flag = false;

        //获取cookie数组
        Cookie[] cookies = request.getCookies();
        //判断cookie是否有效
        if (cookies == null) {
            return;
        }
        //遍历数组判断cookie是否包含指定的键值对
        for (Cookie c : cookies) {
            String name = c.getName();
            if (name.equals("curTime")){
                //存在指定键
                flag = true;
                //获取cookie中携带的时间
                String value = c.getValue();
                //对value进行解码
                value = URLDecoder.decode(value, "Unicode");
                System.out.println("获取携带的时间 : " + value);
                response.getWriter().write("欢迎回来,您上次访问时间为 : " + value);
                //更新时间
                String time = getTime();
                c.setValue(time);
                response.addCookie(c);
                response.getWriter().write("<br/>时间更新成功!");
                break;
            }
        }

        if (flag == false) {
            //走到这里,就说明原来的cookie中没有指定的键值对,响应cookie
            response.getWriter().write("欢迎您首次访问!");
            //获取时间
            String time = getTime();
            System.out.println("发送时间 : " + URLDecoder.decode(time, "Unicode"));
            Cookie cookie = new Cookie("curTime", time);
            //设置时间持久化存储
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
