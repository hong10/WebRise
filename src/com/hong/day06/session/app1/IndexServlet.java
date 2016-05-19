package com.hong.day06.session.app1;

import com.hong.day06.domain.User;

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
@WebServlet(name = "IndexServlet", urlPatterns = {"/session/IndexServlet"})
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            //有用户登录成功
            //欢迎user.getName()! &nbsp;<a>注销</a><br/>
            out.write("欢迎：" + user.getName() + "! &nbsp;<a href='" + request.getContextPath() + "/session/LogoutServlet'>注销</a><br/>");

        } else {
            //login
            out.write("<a href='" + request.getContextPath() + "/session/LoginIndexServlet'>登录</a><br/>");
        }
        out.write("<hr>这是主页");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
