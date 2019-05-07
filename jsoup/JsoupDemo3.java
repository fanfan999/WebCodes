package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Document对象使用
 */
public class JsoupDemo3 {
    public static void main(String[] args) {
        //获取student.xml的路径
        String str = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档,加载文档进内存,获取dom树,即document对象
        try {
            //方式1,parse​(File in,String charsetName)
            Document document = Jsoup.parse(new File(str), "utf-8");
            //获取Elements对象
            //1.获取所有student对象.
            Elements elements = document.getElementsByTag("name");
            String text = elements.text();
            System.out.println(text);
            System.out.println("-----------------------");

            //2.获取属性值为fan的元素对象
            Element element = document.getElementById("fan");
            String text1 = element.text();
            System.out.println(text1);
            System.out.println("-----------------------");

            //3.获取属性名为id的元素对象
            Elements elements1 = document.getElementsByAttribute("id");
            String text2 = elements1.text();
            System.out.println(text2);
            System.out.println("-----------------------");

            //4.获取number属性值为"heima_0001"的元素对象集合
            Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "heima_0001");
            String text3 = elementsByAttributeValue.text();
            System.out.println(text3);
            System.out.println("-----------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
