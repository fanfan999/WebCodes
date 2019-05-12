package demos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器通过字符流输出数据到浏览器
 */
@WebServlet(name = "ResponseServlet3", urlPatterns = "/responseServlet3")
public class ResponseServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题,获取流对象之前获取流的默认编码为Unicode,下面这一行可以不要,
        //response.setCharacterEncoding("Unicode");
        //同时告诉浏览器,服务器发送的消息体数据的编码,建议浏览器使用该编码解码
        //response.setHeader("content-type", "text/html;charset=unicode");

        //简单的形式来设置编码,告诉浏览器我的响应数据是文本类型的,而且字符集是utf-8的
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //输出数据,在流中我们知道用print可以自动刷新缓冲区,而write方法不能自动刷新缓冲区
        //但是在这里我们都不用去刷新缓冲区,这个流是response获取的,本次请求结束后,response会自动销毁
        //则流也会自动关闭,缓冲区也就自动刷新了
        writer.print("访问到了ResponseSevlet3的dopost()方法");
        writer.write("----------------------------");
        writer.write("访问到了ResponseSevlet3的dopost()方法");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
