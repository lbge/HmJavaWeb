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
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
        //获取path
        String path = JsoupDemo04.class.getClassLoader().getResource("student.xml").getPath();
        //System.out.println(path);  src下的student,不是别的包里面的
        Document document = Jsoup.parse(new File(path), "utf-8");
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());
        System.out.println("------------------------------------");
        String number = element_student.attr("number");
        System.out.println(number);
        String text1 = ele_name.text();
        String html = ele_name.html();
        System.out.println(text1+html);
    }
}
