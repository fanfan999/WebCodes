package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContext共享数据
 * 在这里设置数据
 *
 */
@WebServlet(urlPatterns = "/servletContext3")
public class ServletContext3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request方式获取对象
        ServletContext context1 = req.getServletContext();
        //存储数据
        context1.setAttribute("msg", "ServletContext3共享数据在ServletContext4中获取");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
