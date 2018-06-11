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
import java.sql.SQLException;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {

    public void init() {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletRegister :");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html;charset=UTF-8");
        String user_name = new String(request.getParameter("user").getBytes("iso-8859-1"), "utf-8");
//        System.out.println("Register user_name = "+user_name);
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Connection  connection = new ConnectionMysql().getConnection();
        String sql = "insert into user (user_name, user_pass, user_email)"+"values(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
