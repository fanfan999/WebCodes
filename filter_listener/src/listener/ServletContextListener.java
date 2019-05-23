package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * 监听器案例
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    /**
     * servletcontext对象创建的,该对象在服务器启动后自动创建
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontext对象被创建了");
    }

    /**
     * 服务器正常关闭后servletcontext对象被销毁,该方法自动被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontext对象被销毁了");
    }
}
