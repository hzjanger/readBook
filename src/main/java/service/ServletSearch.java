package service;

import com.google.gson.Gson;
import config.mysql.ConnectionMysql;
import dao.SelectData;
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
import java.util.List;

@WebServlet(name = "ServletSearch")
public class ServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //得到搜索的内容
        String value = request.getParameter("key");
        //判断从那个页面发出的请求
        String page = request.getParameter("type");
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String sql = "select * from book_information where book_name=?";
        PreparedStatement preparedStatement = null;
        List<Book> list;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            list = new SelectData().exact(preparedStatement);
            request.setAttribute("search_value", value);
            request.setAttribute("search", list);
            request.setAttribute("amount", list.size());
            RequestDispatcher dispatcher = null;
            if ("search".equals(page)) {
                dispatcher = request.getRequestDispatcher("/search.jsp");
                dispatcher.forward(request, response);
            } else if ("delete".equals(page)) {
                PrintWriter out = response.getWriter();
                Gson gson = new Gson();
                String json = gson.toJson(list);
                out.print(json);
                out.flush();
                out.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
