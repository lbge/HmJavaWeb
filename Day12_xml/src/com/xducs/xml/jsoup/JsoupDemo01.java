package com.xducs.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Linbo Ge
 * @date 2020/3/9 - 15:32
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //获取path
        String path = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        //解析文档，加载文档进内存
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        Element element = elements.get(0);
        String text = element.text();
        System.out.println(text);

    }
}
