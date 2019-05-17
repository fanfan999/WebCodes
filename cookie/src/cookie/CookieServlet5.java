package cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * cookie存储中文案例
 *
 */
@javax.servlet.annotation.WebServlet(name = "CookieServlet5", urlPatterns = "/cookieServlet5")
public class CookieServlet5 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("unicode");
        //创建多个cookie
        Cookie cookie1 = new Cookie("msg5.1", "你好呀_哈哈哈哈");

        //发送cookie给浏览器,通过response对象发送
        response.addCookie(cookie1);

        response.getWriter().print("cookie5.1数据发送成功!");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);
    }
}
