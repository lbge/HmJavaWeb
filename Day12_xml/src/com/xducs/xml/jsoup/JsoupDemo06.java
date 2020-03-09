package com.xducs.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/9 - 15:32
 */
public class JsoupDemo06 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //获取path
        String path = JsoupDemo06.class.getClassLoader().getResource("student.xml").getPath();
        //解析文档，加载文档进内存
        Document document = Jsoup.parse(new File(path), "utf-8");
        //创建JXpath
        JXDocument jxDocument = new JXDocument(document);
        //查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        //查询student标签下带有id属性的name标签 并且id属性值为itcast
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id = 'itcast']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}
