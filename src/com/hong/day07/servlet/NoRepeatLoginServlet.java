package com.hong.day07.servlet;

import com.hong.day07.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by hong on 2016/5/21.
 */
@WebServlet(name = "NoRepeatLoginServlet", urlPatterns = {"/servlet/NoRepeatLoginServlet"})
public class NoRepeatLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户名输入框，跳转登陆成功界面
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //生成唯一的token
        UUID uuid = UUID.randomUUID();
        String token = Md5Util.encode(uuid.toString());
        request.getSession().setAttribute("token", token);

        out.write("<form action='" + request.getContextPath() + "/servlet/NoRepeatResultServlet' method='post'>");
        out.write("username:<input type='text' name='username'><br/>");
        out.write("<input type='hidden' name='token' value='" + token + "'>");
        out.write("<input type='submit' value='login'></form>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}