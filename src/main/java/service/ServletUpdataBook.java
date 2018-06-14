package service;

import com.google.gson.Gson;
import dao.BookDao;
import dao.RequestValue;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUpdataBook")
public class ServletUpdataBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Book book = new Book();
        book = new RequestValue().getBookValue(request);
        new BookDao().upDataBook(book);
        System.out.println("update Book " + book);
        PrintWriter out = response.getWriter();
        out.print("修改成功");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ISBN = request.getParameter("ISBN");
        Book book = new Book();
        BookDao bookDao = new BookDao();
        book = bookDao.selectOneBook(ISBN);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(book);
        out.print(json);
        out.flush();
        out.close();
    }
}
