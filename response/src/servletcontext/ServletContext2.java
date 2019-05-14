package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContext获取mime类型
 *
 */
@WebServlet(urlPatterns = "/servletContext2")
public class ServletContext2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request方式获取对象
        ServletContext context1 = req.getServletContext();

        //定义文件名称
        String file = "a.jpg";

        //获取其mime类型
        String mimeType = context1.getMimeType(file);
        System.out.println(mimeType);//image/jpeg

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
