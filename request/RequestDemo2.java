package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * request对象获取请求行信息演示案例
 * 1. String getHeader(String name): 通过请求头的名称来获取请求头的值.
 * 	2. Enumeration<String> getHeaderNames(): 获取所有请求头的名称.
 */
@WebServlet(name = "RequestDemo2",urlPatterns = "/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求头的名称获取请求头的值,例如获取referer的值,
        // 现在是null,因为我们不是从超链接过来的,我们是直接输入url地址过来的.
        String referer = request.getHeader("referer");
        //System.out.println(referer);
        //我们可以写一个html文件,放一个超链接过来,再看就有值了
        System.out.println("当前访问路径为 : " + referer);

        //在这里我们来个防盗链的操作
        if (referer != null) {
            if (referer.contains("http://localhost:8080/login.html")) {
                System.out.println("正常访问");
            } else {
                System.out.println("无法访问");
            }
        } else {
            System.out.println("不点超链接进不来的兄弟");
        }

        //获取所有请求头的名称,把返回值类型当作迭代器用就好了
        Enumeration<String> enums = request.getHeaderNames();
        while (enums.hasMoreElements()) {
            String names = enums.nextElement();
            String header = request.getHeader(names);
            System.out.println(names + ": " + header);
        }
    }
}
