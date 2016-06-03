package com.hong.toAndroid;

import com.google.gson.Gson;
import com.hong.domain.Result;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/6/3.
 */
@WebServlet(name = "MockLoginServlet", urlPatterns = {"/toAndroid/MockLoginServlet"})
public class MockLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Gson gson = new Gson();
        String responseStr = null;

        System.out.println(username + " : " + password);

        if ("hong".equals(username) && "123".equals(password)) {
            responseStr = gson.toJson(new Result(200, "success"));
        } else {
            responseStr = gson.toJson(new Result(404, "username or password is not correct"));
        }
        response.getWriter().write(responseStr);
        System.out.println(responseStr);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
