package database;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.AddBook;
import dao.AuthorDao;
import dao.BookDao;
import entity.Author;
import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetDatabase extends Thread{
    private Lock lock=new ReentrantLock();
    Queue<String> queue;

    private List<String> list;
    private int amount = 0;

    public GetDatabase() {
        queue = new LinkedList<String>();
        list = new ArrayList<String>();
    }

    public static void main(String[] args) {
        String url = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B";
        GetDatabase getDatabase = new GetDatabase();
//        getDatabase.getAuthorInfo("https://book.douban.com/subject/30212126/?icn=index-editionrecommend");
//        getDatabase.getData("https://book.douban.com/subject/30206904/?icn=index-editionrecommend");
        getDatabase.start();
        getDatabase.getUrl(url, "https://book.douban.com");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BookDao bookDao = new BookDao();

            Iterator<String> iterator = this.list.iterator();
            lock.lock();
            try {
                for (String q: queue) {

                    Author author = new Author();
                    author = this.getAuthorInfo(q);
                    AuthorDao authorDao = new AuthorDao();
                    authorDao.addAuthor(author);
                    System.out.println(author);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Book book = new Book();
                    book = this.getData(q);
                    bookDao.addBook(book);
                    System.out.println(book);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e){

            } finally {
                lock.unlock();
            }
        }
    }

    public void getUrl(String url, String old_url) {
        Document document = null;
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
        //得到页面class名为cover下的所有a标签
        Elements ElementLink = document.select("div[class=pic]").select("a");
//        Elements ElementLink = document.getElementsByClass("cover").select("a");
        lock.lock();
        try {
            for (Element element : ElementLink) {
                //得到a标签的超链接
                String getUrl = element.attr("href");
                System.out.println(getUrl);
//            if (getUrl.indexOf("=pc_web") > -1) {
//                continue;
//            }
                //将链接放到List数组里面，然后再一个一个的爬取超链接里面的内容
//            list.add(getUrl);
                queue.offer(getUrl);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

        String link_next = document.select("span[class=next]").select("a").attr("href");
        url = old_url +   link_next;
        this.amount++;
        System.out.println("url = " + url);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (url.equals("https://book.douban.com")) {
            return;
        } else {
            this.getUrl(url, old_url);
        }




    }

    public static Book getData(String url) {
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
        //得到书名
        Elements titleElement = document.getElementsByClass("subject clearfix").select("a");
        book.setBook_name(titleElement.attr("title"));
        System.out.println("书名: "+book.getBook_name());

        String img = document.getElementsByClass("subject clearfix").select("img").attr("src");
        book.setBook_img(img);
        System.out.println("img : " + img);
        String binding = document.select("strong[class=ll rating_num]").text();
        book.setReview_grade(binding);
        System.out.println("星级: "+binding);

        Element info = document.getElementById("info");
        String information = info.text();
        System.out.println(information);

        if (information.indexOf("作者:") > -1) {
            String book_author = info.text().split("作者:")[1].split("出版社:")[0];
            System.out.println("作者: " + book_author);
            book.setAuthor(book_author);
        }

        //爬虫爬取书籍信息，主要是通过字符窜过分割，得到所需要的信息，其他的信息基本上也是采用这种方法
        if (information.indexOf("出版社:") > -1) {
            book.setPubliseer(info.text().split("出版社:")[1].split(" ")[1]);
            System.out.println("出版社: "+book.getPubliseer());
        }else {
            book.setPubliseer("");
        }

        if (information.indexOf("出版年:") > -1) {
            book.setPutlish_time(info.text().split("出版年:")[1].split(" ")[1]);
            System.out.println("出版年: "+book.getPutlish_time());
        } else {
            book.setPutlish_time("");
        }

        if (information.indexOf("页数:") > -1) {
            book.setPage_amount(info.text().split("页数:")[1].split(" ")[1]);
            System.out.println("页数: "+book.getPage_amount());
        } else {
            book.setPage_amount("");
        }

        if (information.indexOf("装帧:") > -1) {
            book.setBinding(info.text().split("装帧:")[1].split(" ")[1]);
            System.out.println("装帧: "+book.getBinding());
        } else {
            book.setBinding("");
        }

        if (information.indexOf("ISBN:") > -1) {
            book.setISBN(info.text().split("ISBN:")[1].split(" ")[1]);
            System.out.println("ISBN: "+book.getISBN());
        } else {
            book.setISBN("");
        }


        if (information.indexOf("译者:") > -1) {
            book.setTranslators(info.text().split("译者:")[1].split(" ")[1]);
            System.out.println("译者: "+book.getTranslators());
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
            System.out.println("定价: "+book.getPrice());
        } else {
            book.setTranslators("");
        }



        Elements ElementBookIntroduction = document.select("div[id=link-report]").select("div[class=intro]");
        List<String> book_Introduction = new ArrayList<String>();
        for (Element fo: ElementBookIntroduction) {
            book_Introduction.clear();
            String str = String.valueOf(fo.select("p"));
            String[] value = str.split("<p>");
            for (String s1: value) {
                book_Introduction.add(s1.split("</p>")[0]);
            }
            Iterator<String> it = book_Introduction.iterator();
            System.out.println("列表");
            String StringBookItroduction = "";
            while (it.hasNext()) {
                StringBookItroduction += it.next() + '\n';
            }
            book.setContent_Introduction(StringBookItroduction);
        }
        System.out.println("bookInstroduction: " +book.getContent_Introduction());


        String regex = "/(\\d+)/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        String dir = "";
        if (matcher.find()) {
            dir =dir + "dir_" + matcher.group(1) + "_full";
        }
        Element directories = document.getElementById(dir);
        if (directories == null) {
            book.setDirectory("");
        } else {
            String value = String.valueOf(directories).split("<div class=\"indent\" id=\""+dir+"\" style=\"display:none\">")[1];
            String[] directory = value.split("<br>");
            String book_direcotry = "";
            for (String di: directory) {
                if (di.indexOf("<a") > -1) {
                    continue;
                }
                if (di.indexOf("· · · · · · (") > -1) {
                    continue;
                }
                book_direcotry += di;
            }
            book.setDirectory(book_direcotry);
            System.out.println("book_direcotry: " + book_direcotry);
        }
        book.setIs_popular("0");
        book.setType("3");

        return book;
    }

    public static Author getAuthorInfo(String url) {
        Author author = new Author();
        Document document = null;
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
        Element info = document.getElementById("info");
        String information = info.text();
        System.out.println("information = "+information);

        if (information.indexOf("作者:") > -1) {
            String book_author = info.text().split("作者:")[1].split("出版社:")[0];
            System.out.println("作者: " + book_author);
            author.setAuthor_name(book_author);
        }
        Elements author_introduction = document.select("div[class=intro]");
        for (Element author_introduction1: author_introduction) {
            String author_info = "";
//            System.out.println(author_introduction1);
            String author_introduction2 = String.valueOf(author_introduction1.select("p"));
            String[] author_list = author_introduction2.split("<p>");
            for (String fo: author_list) {
                author_info = author_info + fo.split("</p>")[0] + '\n';
            }
            System.out.println(author_info);
            author.setAuthor_introduction(author_info);
            System.out.println("------------------------");
        }
        return author;
    }
}
