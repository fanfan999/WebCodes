package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * servletContext获取服务器路径
 *
 */
@WebServlet(urlPatterns = "/servletContext5")
public class ServletContext5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request方式获取对象
        ServletContext context1 = req.getServletContext();
        //获取文件的服务器路径,a.txt放在src目录(所有文件都会被放在web-inf下的classes目录下)下,b.txt放在web目录下,c.txt放在web-inf目录下
        String realPath1 = context1.getRealPath("WEB-INF/classes/a.txt");
        String realPath2 = context1.getRealPath("/b.txt");
        String realPath3 = context1.getRealPath("/WEB-INF/c.txt");
        File file1 = new File(realPath1);
        File file2 = new File(realPath2);
        File file3 = new File(realPath3);

        //D:\IDEA_Codes\Web_Codes\out\artifacts\response_war_exploded\a.txt
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
