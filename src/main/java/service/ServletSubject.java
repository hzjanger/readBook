package service;

import config.mysql.ConnectionMysql;
import dao.AuthorDao;
import dao.BookDao;
import dao.SelectData;
import entity.Author;
import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ServletSubject")
public class ServletSubject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        String regex = "/(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uri);
        String ISBN = "";
        if (matcher.find()) {
            ISBN += matcher.group(1);
//            System.out.println("ISBN = " + ISBN);
        }
        BookDao bookDao = new BookDao();
        Book book = bookDao.selectOneBook(ISBN);
//        System.out.println("Subject Book = " + book);
        request.setAttribute("info", book);
        List<String> book_introduction = book.getList(book.getContent_Introduction());
//      通拖request.serAttribute方法提交的服务器
        request.setAttribute("introduction", book_introduction);
        List<String> directory = book.getList(book.getDirectory());
        request.setAttribute("directory", directory);
        AuthorDao authorDao = new AuthorDao();
        Author author = authorDao.selectOneAuthor(authorDao.selectAuthor(book.getAuthor()));
//        System.out.println(author);
        List<String> author_troduction = author.getList(author.getAuthor_introduction());
        request.setAttribute("author_troduction", author_troduction);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-information.jsp");
        dispatcher.forward(request, response);
    }
}
