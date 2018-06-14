package service;

import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;

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

@WebServlet(name = "ServletAdminUpdataPass")
public class ServletAdminUpdataPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String now_pass = request.getParameter("now_pass");
        String new_pass = request.getParameter("new_pass");
        String user = request.getParameter("user");
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from admin where admin_user=? and admin_pass=?";
        boolean flag = true;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, now_pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("可以进行修改");
                int admin_id = resultSet.getInt(1);
                sql = "update admin set admin_pass=? where admin_id=?";
                System.out.println(sql);
                preparedStatement = null;
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, new_pass);
                preparedStatement.setInt(2, admin_id);
                preparedStatement.executeUpdate();
            } else {
                flag = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        PrintWriter out = response.getWriter();
        if (flag) {
            out.print("修改成功");
        } else {
            out.print("原密码错误");
        }
        out.flush();
        out.close();

//        response.setContentType("text/html;charset=urf-8");
//        response.setContentType("text/html;charset=UTF-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
