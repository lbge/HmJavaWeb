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
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //获取path
        String path = JsoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
//        System.out.println(path);  src下的student,不是别的包里面的
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements students = document.getElementsByTag("student");
        System.out.println(students);
        System.out.println("------------------------");
        Elements element1 = document.getElementsByAttribute("id");
        System.out.println(element1);

        Elements element2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(element2);
        System.out.println("------------------------");
        Element element3 = document.getElementById("itcast");
        System.out.println(element3);
    }
}
