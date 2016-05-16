package com.hong.day06.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 判断是否保存cookie
 */
@WebServlet(name = "CookieDemo3", urlPatterns = {"/cookie/CookieDemo3"})
public class CookieDemo3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        System.out.println("3： "+username);
        System.out.println(password);
        System.out.println(remember);

        Cookie cookie = new Cookie("username",username);
        cookie.setPath(request.getContextPath());

        if (remember != null) {
            //保存cookie
            cookie.setMaxAge(Integer.MAX_VALUE);
        }else{
            //删除cookie
            cookie.setMaxAge(0);
        }

        response.addCookie(cookie);

        response.getWriter().write("login success<br/>");
        response.getWriter().write(request.getContextPath());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}