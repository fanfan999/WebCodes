package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * jsoup快速入门
 */
public class JsoupDemo {
    public static void main(String[] args) {
        //获取document对象
        //根据xml文档获取
        //获取student.xml的路径
        String str = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档,加载文档进内存,获取dom树,即document对象
        try {
            Document document = Jsoup.parse(new File(str), "utf-8");

            //获取元素对象,即element(标签)对象,Elements就是一个list列表,会存放所有name
            Elements elements = document.getElementsByTag("name");

            System.out.println(elements.size());
            //获取第一个name的element对象
            Element element = elements.get(0);
            //获取数据
            String name = element.text( );
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
