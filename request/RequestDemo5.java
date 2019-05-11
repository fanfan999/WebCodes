package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求参数通用方式演示案例
 */
@WebServlet(name = "RequestDemo5", urlPatterns = "/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置流的字符集编码格式
        request.setCharacterEncoding("UTF-8");

        //post获取请求参数username
        //根据参数获取值
        String name = request.getParameter("username");
        System.out.println(name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //由于上下两段代码一样的,我们在get方法里面直接调用post方法就可以了
        this.doPost(request, response);
    }
}
