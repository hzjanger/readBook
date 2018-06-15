package service;


import com.google.gson.Gson;
import dao.AuthorDao;
import dao.BookDao;
import dao.RequestValue;
import database.GetDatabase;
import dao.AddBook;
import entity.Author;
import entity.Book;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@WebServlet(name = "ServletInsetBook")
public class ServletInsetBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Book book = new Book();
        Author author = new Author();
        book = new RequestValue().getBookValue(request);
        author = new RequestValue().getAuthorValue(request);
        BookDao bookDao = new BookDao();
        AuthorDao authorDao = new AuthorDao();
        authorDao.addAuthor(author);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(book);
        Book b = gson.fromJson(json, Book.class);
        System.out.println("返回的json数据"+json);
        if (bookDao.addBook(book)) {
            out.print("插入成功");
        } else {
            out.print("此书已存在");
        }
        out.flush();
        out.close();

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        System.out.println("进入Doget方法");
        String url = request.getParameter("url");
        System.out.println("url = "+url);
        Gson gson = new Gson();
        Book book = GetDatabase.getData(url);
        Author author = GetDatabase.getAuthorInfo(url);
        book.setAuthor_introduction(author.getAuthor_introduction());
        String json = gson.toJson(book);
        System.out.println(json);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
