package com.hong.day06.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过cookie技术，获取用户上次访问时间
 * Created by hong on 2016/5/15.
 */
@WebServlet(name = "CookieDemo1", urlPatterns = {"/"})
public class CookieDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("上次访问的时间： ");

        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if ("lastAccessTime".equals(c.getName())) {
                String value = c.getValue();
                long time = Long.parseLong(value);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                out.write(df.format(new Date(time)));
//                out.write(new Date(time).toLocaleString());

            }
        }


        //将上次访问的时间，写到浏览器的cookie中
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        response.addCookie(cookie);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}