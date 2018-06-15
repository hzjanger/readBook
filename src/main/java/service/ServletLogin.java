package service;

import config.mysql.ConnectionMysql;

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

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {

    public void init() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        String pass= new String(request.getParameter("password"));
        Connection connection = new ConnectionMysql().getConnection();
        String sql = "select * from user where user_name=? and user_pass=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        String user_name = null;
        String user_img = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user_name = resultSet.getString(2);
                user_img = resultSet.getString(4);
                System.out.println("Login user_name  = " + user_name);
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = null;
            if (flag) {
//                System.out.println(user_img);
                request.getSession().setAttribute("user_img", user_img);
//                request.setAttribute("user", user_name);
                request.getSession().setAttribute("user",user_name);
                requestDispatcher = request.getRequestDispatcher("/index.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/login.jsp");
            }
            requestDispatcher.forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
