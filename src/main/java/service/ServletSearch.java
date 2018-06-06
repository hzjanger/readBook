package service;

import config.mysql.ConnectionMysql;
import database.SelectData;
import entity.Book;
import layout.ShowSearch;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletSearch")
public class ServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("key");
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String sql = "select * from book_information where book_name=?";
        PreparedStatement preparedStatement = null;
        List<Book> list;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            list = new SelectData().exact(preparedStatement);

            request.setAttribute("search", list);
            System.out.println("servietSearch服务");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
            dispatcher.forward(request, response);
//            this.getServletConfig().getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);
//            ShowSearch showSearch = new ShowSearch();
//            showSearch.setList(list);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.jsp");
//            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
