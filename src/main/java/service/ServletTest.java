package service;

import test.people;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@WebServlet(name = "ServletTest")
public class ServletTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        userName=URLDecoder.decode(userName, "UTF-8");

        String content = request.getParameter("content");
        content=URLDecoder.decode(content, "UTF-8");

        System.out.println("userName:"+userName);
        System.out.println("content:"+content);

        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //将数据拼接成JSON格式
        out.print("{\"yourName\":\"" + userName + "\",\"yourContent\":\""+content+"\"}");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    protected String getValue(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        try {
            value = URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
