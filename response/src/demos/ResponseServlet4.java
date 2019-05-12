package demos;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器通过字节流输出数据到浏览器
 */
@WebServlet(name = "ResponseServlet4", urlPatterns = "/responseServlet4")
public class ResponseServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //切记这里要把请求的编码也改成utf-8,不然还是会乱码
        request.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=UTF-8");
        //获取字节流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("hello".getBytes());
        //这里也必须要写utf-8,不然就以默认格式编码,就会出错
        outputStream.write("你好".getBytes("UTF-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
