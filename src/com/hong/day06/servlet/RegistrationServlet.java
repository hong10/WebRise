package com.hong.day06.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/13.
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/servlet/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getOutputStream().write("success".getBytes());
        String name = request.getParameter("username");
        name =  new String(name.getBytes("ISO-8859-1"),"UTF-8");

        System.out.println(name);

        response.setContentType("text/html;charset=UTF-8");
        response.getOutputStream().write(name.getBytes("UTF-8"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
