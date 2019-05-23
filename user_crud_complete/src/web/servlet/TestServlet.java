package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "TestServlet", urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String msg = request.getParameter("msg");
        System.out.println(name + ":" + msg);

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> stringSet = parameterMap.keySet();
        for (String s : stringSet) {
            System.out.println(s + "---" + parameterMap.get(s)[0]);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
