package database;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {
        new Test2().test2();
    }
    public void test2(){
        try {
            Document doc=Jsoup.connect("https://book.douban.com/subject/30180673/?icn=index-editionrecommend")
                    .data("query", "java")
                    .userAgent("Chrome")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
            Element link = doc.select("a").first();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
