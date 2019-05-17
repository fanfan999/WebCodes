package cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * cookie实现持久化存储案例
 *  1. 设置cookie存活时间为10秒以后,刚开始运行servlet2是会看到serlvet4中的消息的,但是10秒后刷新就看不到了
 *
 */
@javax.servlet.annotation.WebServlet(name = "CookieServlet4", urlPatterns = "/cookieServlet4")
public class CookieServlet4 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("unicode");
        //创建多个cookie
        Cookie cookie1 = new Cookie("msg4.1", "hello我是cookie4.1");
        Cookie cookie2 = new Cookie("msg4.2", "hello我是cookie4.2");

        //设置cookie存活时间为300秒
        cookie1.setMaxAge(300);
        //设置cookie存活时间为负数,表示保存在浏览器中
        cookie2.setMaxAge(-1);
        //设置cookie1存活时间为0,表示删除该cookie中的信息,本来我们是就算关闭浏览器打开还是会有这个东西的
        //但是当我们给cookie1设置为0后,再次访问servlet4后再通过servlet2访问就访问不到了,就不会有了
        cookie1.setMaxAge(0);

        //发送cookie给浏览器,通过response对象发送
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().print("cookie4.1数据发送成功!");
        response.getWriter().write("cookie4.2数据发送成功!");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);
    }
}
