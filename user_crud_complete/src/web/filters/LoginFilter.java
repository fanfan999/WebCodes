package web.filters;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
       //获取资源请求路径
        //http://localhost:8080/user/checkCodeServlet
        //StringBuffer requestURL = request.getRequestURL();
        //http://localhost:8080/user/
        String requestURI = request.getRequestURI();
        //判断路径是否是登录路径,是,就直接放行
        //但是这里会有一个问题,那就是这样子直接运行会导致验证码出不来,因为这个放行的页面太少了
        //以至于生成验证码的servlet没有被放行,所以显示不出来
        //切记要注意scss,js,图片,验证码等资源
        if (requestURI.contains("login.jsp") || requestURI.contains("loginServlet")
        || requestURI.contains("/css/*") || requestURI.contains("checkCodeServlet")
        || requestURI.contains("/js/*")) {
            chain.doFilter(req, resp);
        }else {
            //不是,就判断用户是否登录
            //首先从session中获取user
            User user = (User) request.getSession().getAttribute("user");
            //当用户不为空时,就登录
            if (user != null) {
                //说明已经登录了,放行
                chain.doFilter(req, resp);
            }else {
                //说明没有登录,存点信息
                request.setAttribute("loginFilter_msg","用户未登录!");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
