package dao;

import entity.Book;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class RequestValue {
    public Book getBookValue(HttpServletRequest request) {
        RequestValue requestValue = new RequestValue();
        Book book = new Book();
        String img_url = this.getValue(request, "img_url");
        book.setBook_img(img_url);

        String ISBN = this.getValue(request, "ISBN");
        book.setISBN(ISBN);

        String book_name = this.getValue(request, "book_name");
        book.setBook_name(book_name);

        String publish_time = this.getValue(request, "publish_time");
        book.setPutlish_time(publish_time);

        String publiseer = this.getValue(request, "publiseer");
        book.setPubliseer(publiseer);

        String author = this.getValue(request, "author");
        book.setAuthor(author);

        String tranaslators = this.getValue(request, "tranaslators");
        book.setTranslators(tranaslators);

        String price = this.getValue(request, "price");
        book.setPrice(price);

        String binding = this.getValue(request, "binding");
        book.setBinding(binding);

        String page_amount = this.getValue(request, "page_amount");
        book.setPage_amount(page_amount);

        String type = this.getValue(request, "type");
        book.setType(type);

        String content_introduce = this.getValue(request, "content_introduce");
        book.setContent_Introduction(content_introduce);

        String author_introduce = this.getValue(request, "author_introduce");

        String directory = this.getValue(request, "directory");
        book.setDirectory(directory);
        return book;
    }

    protected String getValue(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        try {
            value = URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
