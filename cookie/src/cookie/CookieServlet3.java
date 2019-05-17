package cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * 一次性发送多个cookie
 * 运行后在浏览器检查的网络页面中会发现响应头有两个set-Coolie键值对:Set-Cookie: msg3.1=hello我是cookie1和 Set-Cookie: msg3.2=hello我是cookie2
 *
 */
@javax.servlet.annotation.WebServlet(name = "CookieServlet3", urlPatterns = "/cookieServlet3")
public class CookieServlet3 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("unicode");
        //创建多个cookie
        Cookie cookie1 = new Cookie("msg3.1", "hello我是cookie3.1");
        Cookie cookie2 = new Cookie("msg3.2", "hello我是cookie3.2");
        //发送cookie给浏览器,通过response对象发送
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().print("cookie1数据发送成功!");
        response.getWriter().write("cookie2数据发送成功!");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);
    }
}
