package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * session快速入门
 */
@WebServlet(name = "SessionServlet1", urlPatterns = "/sessionServlet1")
public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession();
        //存储数据
        session.setAttribute("msg", "hello, session");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
