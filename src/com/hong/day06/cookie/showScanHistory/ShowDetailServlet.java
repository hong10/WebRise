package com.hong.day06.cookie.showScanHistory;

import com.hong.day06.domain.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by hong on 2016/5/18.
 */
@WebServlet(name = "ShowDetailServlet", urlPatterns = {"/showScanHistory/ShowDetailServlet"})
public class ShowDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

//        System.out.println(id);
//        System.out.println(BookDB.findBookByName(id));

        out.write(BookDB.findBookByName(id).toString());

        //create cookie
        String ids = makeIds(request, id);
        Cookie cookie = new Cookie("bookHistory", ids);
        cookie.setMaxAge(Integer.MAX_VALUE);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }

    //当前情况                                                          所查看的书的id                     应该写给客户端的cookie的值
    //1第一次，cookie为null				 									 1                                      1
    //2第一次，cookie不为null，不是bookHistory									 1										1
    //3bookHistory=1															 2                                      2-1
    //4bookHistory=2-1														 1                                      1-2
    //5bookHistory=2-1														 3										3-2-1
    //6bookHistory=1-3-2														 2										2-1-3
    //7bookHistory=1-3-2                                                      4                                      4-1-3

    private String makeIds(HttpServletRequest request, String id) {
        Cookie[] cookies = request.getCookies();
        //1第一次，cookie为null
        if (cookies == null) {
            return id;
        }
        Cookie cookie = null;//存放指定的bookHistory这个cookie
        //2第一次，cookie不为null，不是bookHistory
        for (Cookie c : cookies) {
            if ("bookHistory".equals(c.getName())) {
                cookie = c;
                break;
            }
        }

        if (cookie == null) {
            return id;
        }

        String value = cookie.getValue();
        String[] oldIds = value.split("\\-");
        LinkedList<String> ll = new LinkedList<String>(Arrays.asList(oldIds));
        if (ll.size() < 3) {
            // 3  4  5
            if (ll.contains(id)) {
                ll.remove(id);
            }
            ll.addFirst(id);
        } else {
            // 6  7
            if (ll.contains(id)) {
                ll.removeLast();
            }
            ll.addFirst(id);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; ll != null && i < ll.size(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(ll.get(i));
        }

        return sb.toString();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}