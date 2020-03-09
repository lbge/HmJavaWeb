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
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
        //获取path
        String path = JsoupDemo05.class.getClassLoader().getResource("student.xml").getPath();
        //System.out.println(path);  src下的student,不是别的包里面的
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("----------------------");
        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);
        System.out.println("----------------------");
        Elements elements2 = document.select("student[number = heima_0001]");
        System.out.println(elements2);
        System.out.println("------------------------------");
        Elements elements3 = document.select("student[number = heima_0001] > age");
        System.out.println(elements3);
    }
}
