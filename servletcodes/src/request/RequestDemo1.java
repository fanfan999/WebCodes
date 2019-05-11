package request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request对象获取请求行数据演示案例
 * 1. 获取请求方式(GET): `String getMethod()`.
 * 2. (**重要**)获取虚拟目录(/requestDemo): `String getContextPath()`.
 * 3. 获取资源路径(/requestDemo1): `String getServletPath()`.
 * 4. 获取get方式的请求参数(name=fan): `String getQueryString()`.
 * 5. (**重要**)获取请求的uri,即虚拟目录+资源目录(/requestDemo(虚拟目录)/requestDemo1): `String getRequestURI()`.
 * 		* `StringBuffer getRequestURL()`: 返回整个url路径,比如`http://localhost:8080/requestDemo/requestDemo1`.
 * 6. 获取协议和版本(HTTP/1.1): `String getProtocol()`.
 * 7. 获取客户机的ip地址: `String getRemoteAddr()`.
 *
 * 因为浏览器访问默认是get方法,所以我们写在get方法中,
 * 访问的时候,可以加点参数,如:http://localhost:8080/requestDemo1?name=fanfan&add=abc
 * 输出的时候,就有参数了.
 */
@WebServlet(urlPatterns = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法
        System.out.println(req.getMethod());
        //获取虚拟目录
        System.out.println(req.getContextPath());
        //获取资源路径
        System.out.println(req.getServletPath());
        //获取get请求参数
        System.out.println(req.getQueryString());
        //获取请求uri
        System.out.println(req.getRequestURI());
        //获取请求url
        System.out.println(req.getRequestURL());
        //获取协议以及版本
        System.out.println(req.getProtocol());
        //获取客户机的ip地址
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRemoteUser());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemotePort());
    }
}
