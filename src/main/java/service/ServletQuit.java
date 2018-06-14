package service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletQuit")
public class ServletQuit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletQuit");
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html; charser=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getRequestURI();
        System.out.println(url);
        request.getSession().removeAttribute("user");
        RequestDispatcher requestDispatcher = null;
        requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
