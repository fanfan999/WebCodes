package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 在这里获取cookie并输出的时候有一个需要注意的点:
 *  那就是如果,多个servlet发送的cookie的键是相同的,虽然发送会都发送,但是接收的时候只会接收最后一个发送的,
 *  即servlet1和servlet3中如果键都是"msg",最后得到的值只有"hello我是cookie3.2".
 *  同时这里我们也需要知道一点的是,运行servlet3之后再去运行servlet1,servlet1中响应头中的键值对会带过去到servlet3中,而且是在请求头中带过去
 */
@WebServlet(name = "CookieServlet2", urlPatterns = "/cookieServlet2")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("content-type:text/html;charset=unicode");
        response.setCharacterEncoding("unicode");
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //遍历cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                response.getWriter().write(name + " : " + value);
                System.out.println(name + " : " + value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
