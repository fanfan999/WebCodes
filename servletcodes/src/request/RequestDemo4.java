package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 获取请求参数通用方式演示案例
 */
@WebServlet(name = "RequestDemo4", urlPatterns = "/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        //在这里设置request参数的编码格式,防止出现乱码
        request.setCharacterEncoding("UTF-8");
        //根据参数获取值
        //String name = request.getParameter("username");
        //System.out.println("post : " + name);

        //根据参数获取你勾选的复选框对应的"value值"的数组
        /*String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));*/

        //获取所有请求的参数名称
        /*Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }*/

        //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //根据键获取值.
            String[] strings = parameterMap.get(name);
            System.out.println(name + " : " + Arrays.toString(strings));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求参数

        //根据参数获取值
        /*String name = request.getParameter("username");
        System.out.println("get : " + name);*/

        //由于上下两段代码一样的,我们在get方法里面直接调用post方法就可以了
        this.doPost(request, response);
    }
}
