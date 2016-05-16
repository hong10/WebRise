package com.hong.day06.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 展示登陆界面，同时读取cookie
 */
@WebServlet(name = "CookieDemo2", urlPatterns = {"/cookie/CookieDemo2"})
public class CookieDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = "";
        String remember = "";

        Cookie[] cookies = request.getCookies();
        for (int i=0;cookies!=null && i<cookies.length;i++) {

            if ("username".equals(cookies[i].getName())) {
                username = cookies[i].getValue();
                remember = "checked='checked'";
                break;
            }
        }

        System.out.println(username);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<form action='"+request.getContextPath()+"/cookie/CookieDemo3' method='post'>");
        out.write("username: <input type='text' name='username' value='"+username+"'/><br/>");
        out.write("password: <input type='password' name='password'/><br/>");
        out.write("remember: <input type='checkbox' name='remember' "+remember+"/><br/>");
        out.write("<input type='submit' value='login'/></form>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}