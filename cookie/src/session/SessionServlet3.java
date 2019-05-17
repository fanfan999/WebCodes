package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * session快速入门
 */
@WebServlet(name = "SessionServlet3", urlPatterns = "/sessionServlet3")
public class SessionServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("msg", "hello");
        //获取数据
        String msg = (String) session.getAttribute("msg");
        response.getWriter().write(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
