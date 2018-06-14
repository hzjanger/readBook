package service;

import config.mysql.ConnectionMysql;
import dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


@WebServlet(name = "ServletDeleteBook")
public class ServletDeleteBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ISBN = request.getParameter("ISBN");
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String sql = "delete from book_information where ISBN=?";
        PreparedStatement preparedStatement = null;
        BookDao bookDao = new BookDao();
        bookDao.DeleteBook(ISBN);
        PrintWriter out = response.getWriter();
        out.print("删除成功");
        out.flush();
        out.close();
    }
}
