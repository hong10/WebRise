package com.hong.day07.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hong on 2016/5/21.
 */
@WebServlet(name = "NoRepeatResultServlet", urlPatterns = {"/servlet/NoRepeatResultServlet"})
public class NoRepeatResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        if (token.equals(session.getAttribute("token"))) {
            //如果session中的token相等，就是正确的提交方式，然后删除session中的token
            String username = request.getParameter("username");
            System.out.println("欢迎：" + username);
            session.removeAttribute("token");

        } else {
            //如果session中的token不等，就是重复提交，需要提醒用户
            System.out.println("请不要重复提交");


        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}