package com.hong.day06.session.app1;

import com.hong.day06.domain.User;
import com.hong.day06.domain.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 显示登录结果，如果登录成功，2s后跳转到主页
 * Created by Administrator on 2016/5/19.
 */
@WebServlet(name = "ResultServlet", urlPatterns = {"/session/ResultServlet"})
public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        HttpSession session = request.getSession();

        boolean result = UserDB.findUserByNameAndPassword(username, password);
        if (result) {
            session.setAttribute("user", new User(username, password));

            if (session != null && code.equals(session.getAttribute("code"))) {
                //login success
                out.write("登录成功！2秒后自动跳转到主页......");
                //Refresh:2;URL=/day04/1.html
                response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/session/IndexServlet");
            } else {
                out.write("验证码错误");
            }

        } else {
            out.write("用户名或密码错误");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
