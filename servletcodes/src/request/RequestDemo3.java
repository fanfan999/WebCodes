package request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "RequestDemo3", urlPatterns = "/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //告诉浏览器,我响应数据是文本格式,而且是utf-8编码表的
        response.setContentType("text/html;charset=utf-8");
        // 获取请求消息体
        //获取流对象
        BufferedReader reader = request.getReader();
        System.out.println("abcdef");
        //读取数据
        String line = null;
        while ((line = reader.readLine()) != null) {
            response.getWriter().write(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
