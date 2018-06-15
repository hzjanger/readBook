package service;

import com.google.gson.Gson;
import dao.UserDao;
import entity.User;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletPersonCenter")
public class ServletPersonCenter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String user_name = request.getParameter("user");
        User user = new User();
        UserDao userDao = new UserDao();
        user = userDao.selectOngUser(userDao.selectUserId(user_name));
        request.getSession().setAttribute("user_info", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/person.jsp");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
