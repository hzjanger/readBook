package service;

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
        System.out.println("ServletSubject");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        String regex = "/(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uri);
        String ISBN = "";
        if (matcher.find()) {
            ISBN += matcher.group(1);
            System.out.println("ISBN = " + ISBN);
        }
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String sql = "select * from book_information where ISBN=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
            List<Book> list = new SelectData().exact(preparedStatement);
            Book book = new Book();
            Iterator<Book> iterator = list.iterator();
            while (iterator.hasNext()) {
                book = iterator.next();
            }
            request.setAttribute("info", book);
//            获取搜索到的书籍信息
            List<String> book_introduction = book.getList(book.getContent_Introduction());
//            通拖request.serAttribute方法提交的服务器
            request.setAttribute("introduction", book_introduction);
            List<String> directory = book.getList(book.getDirectory());
            request.setAttribute("directory", directory);
//            页面跳转
            RequestDispatcher dispatcher = request.getRequestDispatcher("/book-information.jsp");
            dispatcher.forward(request, response);
            //            this.getServletConfig().getServletContext().getRequestDispatcher("/book-information.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
