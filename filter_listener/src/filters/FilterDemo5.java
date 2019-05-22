package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo5", urlPatterns = "/*")
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo5执行了");

        chain.doFilter(req, resp);

        System.out.println("FilterDemo5回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
