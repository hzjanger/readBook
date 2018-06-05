package database;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/*******
 * created by DuFei at 2017.08.25 21:00
 * web crawler example
 * ******/

public class DataLearnerCrawler {

    public static void main(String[] args) {

//        String url = "http://www.datalearner.com/blog_list";
        String url = "https://book.douban.com/subject/30180673/?icn=index-editionrecommend";
        String rawHTML = null;
        try {
            rawHTML = getHTMLContent(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将当前页面转换成Jsoup的Document对象
        Document doc = Jsoup.parse(rawHTML);

        //获取所有的博客列表集合
        Elements blogList = doc.select("div[id=wrapper]");

        //针对每个博客内容进行解析，并输出
        for( Element element : blogList ){
            String ISBN = element.select("span[class=pl]").text();
            System.out.println(ISBN);
//            String publish_time = element.select("")

            String title = element.select("h1").text();

            String introduction = element.select("p[class=card-text]").text();
            String author = element.select("span[class=fa fa-user]").text();
            String number = element.select("span[class=fa fa-eye second]").text();
            System.out.println("Title:\t"+title);
            System.out.println("introduction:\t"+introduction);
            System.out.println("Author:\t"+author);
            System.out.println("number:\t" + number);
            System.out.println("--------------------------");

        }

    }

    //根据url地址获取对应页面的HTML内容，我们将上一节中的内容打包成了一个方法，方便调用
    private static String getHTMLContent( String url ) throws IOException {

        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet(url);

        //获取网址的返回结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获取返回结果中的实体
        HttpEntity entity = response.getEntity();
//        System.out.println(EntityUtils.toString(entity));
        String content = EntityUtils.toString(entity);
//        System.out.println(content);

        //关闭HttpEntity流
        EntityUtils.consume(entity);

        return content;

    }

}