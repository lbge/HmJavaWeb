package com.xducs.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Linbo Ge
 * @date 2020/3/9 - 15:32
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //获取path
        String path = JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
        //解析文档，加载文档进内存
       /* Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/


      /* String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
               "<students>\n" +
               "    <student number=\"heima_0001\">\n" +
               "        <name>zhangsan</name>\n" +
               "        <age>22</age>\n" +
               "        <sex>male</sex>\n" +
               "    </student>\n" +
               "\n" +
               "    <student number=\"heima_0002\">\n" +
               "        <name>lisi</name>\n" +
               "        <age>22</age>\n" +
               "        <sex>female</sex>\n" +
               "    </student>\n" +
               "</students>";

        Document document = Jsoup.parse(str);
        System.out.println(document);*/
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
