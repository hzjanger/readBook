package service;

import config.mysql.ConnectionMysql;
import database.SelectData;
import entity.Book;

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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ServletSubject")
public class ServletSubject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        System.out.println(uri);
        String regex = "/(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uri);
        String ISBN = "";
        if (matcher.find()) {
            ISBN += matcher.group(1);
            System.out.println(ISBN);
        }
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String sql = "select * from book_information where ISBN=?";
        PreparedStatement preparedStatement = null;
        List<Book> list;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
            list = new SelectData().exact(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
