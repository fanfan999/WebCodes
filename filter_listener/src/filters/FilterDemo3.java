package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器拦截方式演示案例
 *  1.urlPatterns = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST, 表示浏览器直接输入网址请求资源index.jsp时,该过滤器会被执行,但是转发就不会被过滤
 *  2.urlPatterns = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD, 表示只有转发访问index.jsp时,过滤器才会执行
 *  3.urlPatterns = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST}, 表示转发和直接请求都会被过滤器过滤
 *  4.urlPatterns = "/*", dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST}, 表示转发和直接请求访问所有类型资源都会被过滤器加强
 *  ,但是这样子的话,假如是以请求转发的方式访问index.jsp,过滤器就会被执行两次.
 */
@WebFilter(filterName = "FilterDemo3", urlPatterns = "/*" , dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //在放行前对request的请求消息做一个增强
        System.out.println("FilterDemo3的doFilter方法被执行了!!");

        //放行
        chain.doFilter(req, resp);

        //在放行后对response的响应消息做一个增强
        System.out.println("FilterDemo3的doFilter方法被执行了又回来了!!");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
