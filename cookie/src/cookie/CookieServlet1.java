package cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * cookie的快速入门
 */
@javax.servlet.annotation.WebServlet(name = "CookieServlet1", urlPatterns = "/cookieServlet1")
public class CookieServlet1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置了这个之后,会导致response的write方法都会直接下载文件,所以要在页面上输出只需要设置编码格式即可
        //response.setContentType("content-type:text/html;charset=unicode");
        response.setCharacterEncoding("unicode");
        //创建cookie
        Cookie cookie = new Cookie("msg1", "hello我是cookie");
        //发送cookie给浏览器,通过response对象发送
        response.addCookie(cookie);
        response.getWriter().print("数据发送成功!");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);
    }
}
