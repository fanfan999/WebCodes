package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) {
        //获取student.xml的路径
        String str = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        try {
            //解析xml文档,加载文档进内存,获取dom树,即document对象
            //方式1,parse​(File in,String charsetName)
            Document document = Jsoup.parse(new File(str), "utf-8");

            //查询name标签
            Elements name = document.select("name");
            System.out.println(name.text());
            System.out.println("---------------------");

            //查询id值为fan的元素,记得是`#id`
            Elements elements = document.select("#fan");
            System.out.println(elements.text());
            System.out.println("---------------------");

            //获取number属性值为"heima_0001"下的student标签下的age子标签
            //1.获取number属性值为"heima_0001"下的student标签
            Elements elements1 = document.select("student[number='heima_0001']");
            System.out.println(elements1.text());
            System.out.println("---------------------");

            //2.获取student便签下的age标签
            Elements age = elements1.select("age");
            System.out.println(age.text());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
