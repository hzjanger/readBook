package service;

import check.Check_Book;
import config.mysql.ConnectionMysql;
import database.SelectData;
import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ServletShowIndex")
public class ServletShowIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletShowIndex");
//        String value = "root";
//
////        String value = request.getParameter("userName").trim();
//        if (value == null || "".equals(value)) {
//            value = "root";
//        }
//        System.out.println("ServletShoweIndex value : "+value);
//
//        ConnectionMysql connectionMysql = new ConnectionMysql();
//        Connection connection = connectionMysql.getConnection();
//        String select_user = "select * from recommend where user=?";
//        PreparedStatement preparedStatement = null;
//        List<String> ISBN = new ArrayList<String>();
//        List<Book> list_Book = new ArrayList<Book>();
//        ResultSet resultSet = null;
//        try {
//            preparedStatement = connection.prepareStatement(select_user);
//            preparedStatement.setString(1, value);
//            resultSet = preparedStatement.executeQuery();
////            得到书的ＩＳＢＮ
//            while (resultSet.next()) {
//                String str = resultSet.getString(1);
//                ISBN.add(str);
//                System.out.println("得到书的ISBN：  "+str);
//            }
//
//            if (ISBN.size() < 6) {
//                preparedStatement = connection.prepareStatement("select * from recommend user=?");
//                preparedStatement.setString(1, "root");
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    ISBN.add(resultSet.getString(1));
//                }
//            }
//
//            Iterator<String> iterator = ISBN.iterator();
//            while (iterator.hasNext()) {
//                String select_ISBN = "select * from book_information where ISBN=?";
//                preparedStatement = connection.prepareStatement(select_ISBN);
//                preparedStatement.setString(1, iterator.next());
//                Book book = new Check_Book().getOneBook(preparedStatement);
//                list_Book.add(book);
//            }
//            request.getSession().setAttribute("book", list_Book);
//            response.setContentType("text/html;charset=utf-8");
////            response.getWriter().write(String.valueOf(list_Book));
//            System.out.println("页面跳转到text.jsp页面");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
//            requestDispatcher.forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
