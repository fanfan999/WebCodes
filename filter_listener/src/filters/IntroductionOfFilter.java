package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 过滤器快速入门
 * 其配置路径写在urlPattern下,urlPattern也是它的value属性,可以不写urlPattern几个字
 * /*表示访问所有资源之前都会先执行过滤器,/demo.jsp表示只有访问demo.jsp的时候才会执行过滤器
 *
 */
//@javax.servlet.annotation.WebFilter(filterName = "IntroductionOfFilter", urlPatterns = "/*")
public class IntroductionOfFilter implements javax.servlet.Filter {

    public void destroy() {
        System.out.println("filter快速入门的destroy方法被执行了!!");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("filter快速入门的doFilter方法被执行了!!");

        //要执行下面这条语句,才表示我放行,即让index.jsp的内容显示出来
        chain.doFilter(req, resp);

    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("filter快速入门的init方法被执行了!!");
    }

}
