package com.hong.day06.session.app1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/5/19.
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/session/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            out.write("注销成功！2秒后自动跳转到主页......");
            //Refresh:2;URL=/day04/1.html
            response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/session/IndexServlet");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
