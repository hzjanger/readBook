package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetDatabase extends Thread{
    private List<String> list;

    public static void main(String[] args) {
        String url = "https://book.douban.com/";
        GetDatabase getDatabase = new GetDatabase();
//        getDatabase.getData("https://book.douban.com/subject/26921116/");
        getDatabase.getUrl(url);
        getDatabase.start();
    }

    @Override
    public void run() {
        InsertData insertData = new InsertData();

        Iterator<String> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            Book book = new Book();
            book = this.getData(iterator.next());
            insertData.insert(book);
            System.out.println(book);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }

    public List<String> getUrl(String url) {
        Document document = null;
        this.list = new ArrayList<String>();
        try {
            document = Jsoup.connect(url)
                    .data("query", "java")
                    .userAgent("Chrome")
                    .cookie("auth", "token")
                    .timeout(30000)
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements ElementLink = document.getElementsByClass("cover").select("a");
        for (Element element : ElementLink) {
            String getUrl = element.attr("href");
            if (getUrl.indexOf("=pc_web") > -1) {
                continue;
            }
            list.add(getUrl);
        }
        return list;
//        return url;
    }

    public Book getData(String url) {
        Document document = null;
        Book book = new Book();
        try {
            document = Jsoup.connect(url)
                    .data("query", "java")
                    .userAgent("Chrome")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements titleElement = document.getElementsByClass("subject clearfix").select("a");
        //得到书名
        book.setBook_name(titleElement.attr("title"));
        System.out.println(book.getBook_name());

        Elements authorInfo = document.getElementById("info").select("span").first().select("a");
        //得到作者
        book.setAuthor(authorInfo.text());
        System.out.println(book.getAuthor());

        Element info = document.getElementById("info");
        String information = info.text();
        if (information.indexOf("出版社:") > -1) {
            book.setPubliseer(info.text().split("出版社:")[1].split(" ")[1]);
            System.out.println(book.getPubliseer());
        }else {
            book.setPubliseer("");
        }

        if (information.indexOf("出版年:") > -1) {
            book.setPutlish_time(info.text().split("出版年:")[1].split(" ")[1]);
            System.out.println(book.getPutlish_time());
        } else {
            book.setPutlish_time("");
        }

        if (information.indexOf("页数:") > -1) {
            book.setPage_amount(info.text().split("页数:")[1].split(" ")[1]);
            System.out.println(book.getPage_amount());
        } else {
            book.setPage_amount("");
        }

        if (information.indexOf("装帧:") > -1) {
            book.setBinding(info.text().split("装帧:")[1].split(" ")[1]);
            System.out.println(book.getBinding());
        } else {
            book.setBinding("");
        }

        if (information.indexOf("ISBN:") > -1) {
            book.setISBN(info.text().split("ISBN:")[1].split(" ")[1]);
            System.out.println(book.getISBN());
        } else {
            book.setISBN("");
        }

        if (information.indexOf("译者:") > -1) {
            book.setTranslators(info.text().split("译者:")[1].split(" ")[1]);
            System.out.println(book.getTranslators());
        } else {
            book.setTranslators("");
        }
        if (information.indexOf("定价:") > -1) {
            String price = info.text();
            price = info.text().split("定价:")[1].split(" ")[1];
            if (price.equals("CNY")) {
                price = info.text().split("定价:")[1].split(" ")[2];
            }
            book.setPrice(price);
            System.out.println(book.getPrice());
        } else {
            book.setTranslators("");
        }


        Elements scoreElement = document.select("strong");
        book.setReview_grade(scoreElement.text());
        System.out.println(book.getReview_grade());


        Element content_Introduction = document.getElementById("link-report");
        book.setContent_Introduction(content_Introduction.text());
        System.out.println("简介：  "+book.getContent_Introduction());

        String regex = "/(\\d+)/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        String dir = "";
        if (matcher.find()) {
            dir =dir + "dir_" + matcher.group(1) + "_full";
        }
        System.out.println(123);
        Element directories = document.getElementById(dir);
        if (directories == null) {
            book.setDirectory("");
        } else {
            book.setDirectory(directories.text().split("\\(")[0]);
            System.out.println("book.getDirectory() = " + book.getDirectory());
        }
//        System.out.println("alll = "+directories.text());
//        System.out.println("direction = " + directories.text());
//        if ("".equals(directories.text())) {
//            System.out.println("有空");
//        }
//        if (directories.text().indexOf("收起") > -1) {
//
//        } else {
//            System.out.println("没有过");
//
//        }
        book.setIs_popular("0");
        book.setBook_img("");
        return book;
//        System.out.println(info.text());

    }
}
