package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器拦截路径演示案例
 *  1.拦截具体资源文件: urlPatterns = "/index.jsp",访问index.jsp会拦截,但是index1.jsp就不会
 *  2.拦截目录下的所有文件: urlPatterns = "/user/*, 访问user目录下的所有文件都会被拦截,但是这个user不一定非要存在,起到一个限制作用而已
 *  3.后缀名拦截的方式: urlPatterns = "*.jsp", 表示所有后缀名为.jsp的都会被拦截
 *  4.全部拦截的方式: urlPatterns = "/*", 表示访问任何资源文件都会被执行
 */
//@WebFilter(filterName = "FilterDemo1", urlPatterns = "/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //在放行前对request的请求消息做一个增强
        System.out.println("FilterDemo2的doFilter方法被执行了!!");

        //放行
        chain.doFilter(req, resp);

        //在放行后对response的响应消息做一个增强
        System.out.println("FilterDemo2的doFilter方法被执行了又回来了!!");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
