package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象使用
 */
public class JsoupDemo4 {
    public static void main(String[] args) {
        //获取student.xml的路径
        String str = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        try {
            //解析xml文档,加载文档进内存,获取dom树,即document对象
            //方式1,parse​(File in,String charsetName)
            Document document = Jsoup.parse(new File(str), "utf-8");

            //先获取student标签对象,再在student标签对象中通过Element对象找到name标签对象,那么久只有一个了
            Element student = document.getElementsByTag("student").get(0);
            Elements name = student.getElementsByTag("name");
            System.out.println(name.text());
            System.out.println("-----------------------");

            //获取Elements对象
            //1.获取所有student对象,会有两个
            Elements elements = document.getElementsByTag("name");
            String text = elements.text();
            System.out.println(text);
            System.out.println("-----------------------");

            //获取student对象的属性值
            String number = student.attr("number");
            System.out.println(number);
            System.out.println("-----------------------");

            //获取文本内容
            String text1 = student.text();
            System.out.println(text1);
            String html = student.html();
            System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
