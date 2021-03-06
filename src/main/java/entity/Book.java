package entity;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String ISBN;    //图书的唯一标识
    private String putlish_time;    //出版时间
    private String author;  //作者
    private String publiseer;   //出版社
    private String translators;//翻译者
    private String book_name;   //书名
    private String directory;   //目录
    private String is_popular;  //是否热门
    private String content_Introduction;    //简介
    private String book_img;    //书的图片地址
    private String price;   //书的价格
    private String binding; //书的装帧类型
    private String review_grade;    //书的评价等级
    private String page_amount;    //书的页数
    private String type;   //书类型
    private String author_introduction; //作者简介

    public Book(){}

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPutlish_time() {
        return putlish_time;
    }

    public void setPutlish_time(String putlish_time) {
        this.putlish_time = putlish_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubliseer() {
        return publiseer;
    }

    public void setPubliseer(String publiseer) {
        this.publiseer = publiseer;
    }

    public String getTranslators() {
        return translators;
    }

    public void setTranslators(String translators) {
        this.translators = translators;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getIs_popular() {
        return is_popular;
    }

    public void setIs_popular(String is_popular) {
        this.is_popular = is_popular;
    }

    public String getContent_Introduction() {
        return content_Introduction;
    }

    public void setContent_Introduction(String content_Introduction) {
        this.content_Introduction = content_Introduction;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getReview_grade() {
        return review_grade;
    }

    public void setReview_grade(String review_grade) {
        this.review_grade = review_grade;
    }

    public String getPage_amount() {
        return page_amount;
    }

    public void setPage_amount(String page_amount) {
        this.page_amount = page_amount;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor_introduction() {
        return author_introduction;
    }

    public void setAuthor_introduction(String author_introduction) {
        this.author_introduction = author_introduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", putlish_time='" + putlish_time + '\'' +
                ", author='" + author + '\'' +
                ", publiseer='" + publiseer + '\'' +
                ", translators='" + translators + '\'' +
                ", book_name='" + book_name + '\'' +
                ", directory='" + directory + '\'' +
                ", is_popular='" + is_popular + '\'' +
                ", content_Introduction='" + content_Introduction + '\'' +
                ", book_img='" + book_img + '\'' +
                ", price='" + price + '\'' +
                ", binding='" + binding + '\'' +
                ", review_grade='" + review_grade + '\'' +
                ", page_amount='" + page_amount + '\'' +
                ", type='" + type + '\'' +
                ", author_introduction='" + author_introduction + '\'' +
                '}';
    }

    public List<String> getList(String value) {
        List<String> list = new ArrayList<String>();
        String[] split = value.split("\n");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }

        return list;
    }
}
