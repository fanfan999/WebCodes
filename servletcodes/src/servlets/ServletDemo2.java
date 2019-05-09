package servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet方法
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 在servlet创建的时候执行,只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法");
    }

    /**
     * 获取ServletConfig对象,该对象就是servlet的配置文件对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次servlet被访问的时候执行,会执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法");
    }

    /**
     * 获取servlet的一些信息,如版本,作者等.
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在servlet被杀死时执行,即服务器正常关闭时执行
     * 只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy方法");
    }
}
