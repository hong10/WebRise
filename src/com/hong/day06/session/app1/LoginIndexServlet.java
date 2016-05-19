package com.hong.day06.session.app1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/5/19.
 */
@WebServlet(name = "LoginIndexServlet", urlPatterns = {"/session/LoginIndexServlet"})
public class LoginIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.write("<form action='" + request.getContextPath() + "/session/ResultServlet' method='get'>");
        out.write("用户名：<input type='text' name='username'><br/>");
        out.write("密码：<input type='password' name='password'><br/>");
        out.write("验证码：<input type='text' name='code'><img src='/WebRise/session/ImageServlet'><br/>");
        out.write("<input type='submit' value='登录'><br/></form>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
