package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContext对象的获取
 *
 */
@WebServlet(urlPatterns = "/servletContext1")
public class ServletContext1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request方式获取
        ServletContext context1 = req.getServletContext();
        //通过httpservlet获取
        ServletContext context2 = this.getServletContext();

        //判断两者是否为同一个对象
        System.out.println(context1 == context2);//true

        //打印两个context,均为org.apache.catalina.core.ApplicationContextFacade@546cbc37
        System.out.println(context1 + "&&" + context2);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
