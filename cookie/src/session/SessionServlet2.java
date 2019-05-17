package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * session快速入门
 */
@WebServlet(name = "SessionServlet2", urlPatterns = "/sessionServlet2")
public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession();
        //获取数据
        String msg = (String) session.getAttribute("msg");
        response.getWriter().write(msg);
        //我们希望session哪怕客户端关闭了重新打开一次会话依旧是一样的
        //因为客户端是通过cookie携带的id值来找指定的session的,所以我们可以通过给客户端响应session的id
        //并且让它持久化存储,就可以达到想要的效果了
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
