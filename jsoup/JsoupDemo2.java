package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * jsoup对象使用
 */
public class JsoupDemo2 {
    public static void main(String[] args) {
        //获取student.xml的路径
        String str = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档,加载文档进内存,获取dom树,即document对象
        try {
            //方式1,parse​(File in,String charsetName)
            Document document = Jsoup.parse(new File(str), "utf-8");
            //直接输出,会打印student.xml的字符串表示形式,就是全部都输出来
            System.out.println(document);
            System.out.println("----------------------------");
            //方式2,Document parse​(String html)
            String str2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "\n" +
                    " <students>\n" +
                    " \t<student number=\"heima_0001\">\n" +
                    " \t\t<name>tom</name>\n" +
                    " \t\t<age>18</age>\n" +
                    " \t\t<sex>male</sex>\n" +
                    " \t</student>\n" +
                    "\t\t \n" +
                    " </students>";
            Document document1 = Jsoup.parse(str2);
            System.out.println(document1);
            System.out.println("----------------------------");
            //方法3,parse​(URL url,int timeoutMillis),就相当于把网页源代码html文档拿下来了
            URL url = new URL("https://www.baidu.com/");
            Document document2 = Jsoup.parse(url, 3000);
            System.out.println(document2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
