package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) {
        //获取student.xml的路径
        String str = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        try {
            //解析xml文档,加载文档进内存,获取dom树,即document对象
            //方式1,parse​(File in,String charsetName)
            Document document = Jsoup.parse(new File(str), "utf-8");

            //根据document对象,创建JXDocument对象
            JXDocument jxDocument = new JXDocument(document);

            //结合XPath语法查询
            //查询所有的student标签
            List<JXNode> jxNodes = jxDocument.selN("//student");
            System.out.println(jxNodes);
            System.out.println("------------------------");
            for (JXNode j : jxNodes) {
                System.out.println(j);
            }
            System.out.println("------------------------");
            //查询所有student标签下的name标签
            List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
            System.out.println(jxNodes1);
            System.out.println("------------------------");

            //查询student标签下带id的name标签
            List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
            System.out.println(jxNodes2);
            System.out.println("------------------------");
            //查询student标签下带id的name标签,并且id属性值为fan
            List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id = 'fan']");
            System.out.println(jxNodes3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }

    }
}
