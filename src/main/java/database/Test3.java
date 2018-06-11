package database;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test3 {
    Document doc = null;
    public void test3(){
        try {
            doc = Jsoup.connect("https://book.douban.com/subject/30180673/?icn=index-editionrecommend")
                    .data("query", "java")
                    .userAgent("Chrome")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements titleElement = doc.getElementsByClass("subject clearfix").select("a");
        Elements scoreElement = doc.select("strong");
        Elements ratingSum = doc.getElementsByClass("rating_sum").select("a").select("span");
        Elements authorElement = doc.getElementById("info").select("span").first().select("a");
        Element pressElement = doc.getElementById("info");
        // 书名
        String title = titleElement.attr("title");
        // 评分
        String score = scoreElement.html();
        // 评价人数
        String rating_sum = ratingSum.html();
        // 作者
        String author = authorElement.html();
        // 出版社
        String press = pressElement.text();
        System.out.println("为经过处理的出版社   "+press);
        if (press.indexOf("出版社:") > -1) {
            press = pressElement.text().split("出版社:")[1].split(" ")[1];
        } else {
            press = "";
        }
        // 出版日期
        String date = pressElement.text();
        if (date.indexOf("出版年:") > -1) {
            date = pressElement.text().split("出版年:")[1].split(" ")[1];
        } else {
            date = "";
        }
        String yeshu = pressElement.text();
        if (yeshu.indexOf("页数:") > -1) {
            yeshu = pressElement.text().split("页数:")[1].split(" ")[1];
        } else {
            yeshu = "";
        }
        // 价格
        String price = pressElement.text();
        if (price.indexOf("定价:") > -1) {
            price = pressElement.text().split("定价:")[1].split(" ")[1];
            if (price.equals("CNY")) {
                price = pressElement.text().split("定价:")[1].split(" ")[2];
            }
        } else {
            price = "";
        }

        System.out.println(title);
         System.out.println(score);
         System.out.println(rating_sum);
         System.out.println(author);
         System.out.println(press);
         System.out.println(date);
         System.out.println(price);
         System.out.println(yeshu);

    }

    public static void main(String[] args) {
        new Test3().test3();
    }




}
