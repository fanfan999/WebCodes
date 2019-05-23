package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词汇过滤器
 */
@WebFilter(filterName = "SensitiveWordsFilter", urlPatterns = "/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象,增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //判断是否是getParameter方法,是,就增强
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        //返回值不为空,说明有返回值,那么我们直接遍历集合
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                //如果不是,就原样传递就好了
                return method.invoke(req, args);
            }
        });
    }
    //装敏感词汇的list集合
    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
       list.add("坏蛋");
       list.add("笨蛋");
       list.add("菜鸟");
        /*try {
            //获取文件的真实路径加载文件,注意这个getRealPath中的路径是文件的输出路径
            String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/敏感词汇.txt");
            System.out.println("realPath : " + realPath);
            //读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine())!= null){
                list.add(line);
            }

            br.close();
            System.out.println(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
