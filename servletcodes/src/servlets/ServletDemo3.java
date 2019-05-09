package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 使用注解配置servlet而不是xml配置文件
 * @WebServlet(urlPatterns = "/demo")等同于
 * @WebServlet(value = "/demo")等同于
 * @WebServlet("/demo")
 */
@WebServlet(urlPatterns = "/demo")
public class ServletDemo3 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("这是servlet3.0的特有配置方式");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
