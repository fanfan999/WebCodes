package filters;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(filterName = "FilterDemo1", urlPatterns = "/*")
public class FilterDemo1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //在放行前对request的请求消息做一个增强
        System.out.println("FilterDemo1的doFilter方法被执行了!!");

        //放行
        chain.doFilter(req, resp);

        //在放行后对response的响应消息做一个增强
        System.out.println("FilterDemo1的doFilter方法被执行了又回来了!!");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
