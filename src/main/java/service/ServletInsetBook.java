package service;

import database.GetDatabase;
import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import test.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInsetBook")
public class ServletInsetBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getParameter("url");
        Test test = new Test();
        test.start();
//        GetDatabase getDatabase = new GetDatabase();
//        getDatabase.getData("https://book.douban.com/subject/30206904/?icn=index-editionrecommend");

//        GetDatabase getDatabase = new GetDatabase();
//        getDatabase.getData(url);
//        Book book = new GetDatabase().getData(url);
//        System.out.println(book);
//        request.setAttribute("insertBook", book);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminIndex.jsp");
//        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


    }
}
