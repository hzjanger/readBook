package service;

import config.mysql.ConnectionMysql;
import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "ServletSaveUserInfro")
public class ServletSaveUserInfro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始get请求");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String old_user_name = request.getParameter("old_user_name");

        UserDao userDao = new UserDao();
        int user_id = userDao.selectUserId(old_user_name);
        User user = userDao.selectOngUser(user_id);
        System.out.println("user_id = " + user_id);
        String user_name = request.getParameter("user_name");
        user.setUser_name(user_name);
        String email = request.getParameter("email");
        user.setUser_email(email);
        String user_img = request.getParameter("user_img");
        user.setUser_img(user_img);
        String birth = request.getParameter("birth");
        user.setBirth(birth);
        String sex = request.getParameter("sex");
        user.setSex(sex);
        System.out.println("user = " + user);
        userDao.updateUser(user);
        PrintWriter out = response.getWriter();
        out.print("修改成功");
        out.flush();
        out.close();


    }
}
