package com.hong.day06.cookie.showScanHistory;

import com.hong.day06.domain.Book;
import com.hong.day06.domain.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by hong on 2016/5/18.
 */
@WebServlet(name = "ShowAllBooksServlet", urlPatterns = {"/showScanHistory/ShowAllBooksServlet"})
public class ShowAllBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<h1>最新书籍：<br/></h1>");

        Map<String, Book> allBooks = BookDB.findAllBooks();
        for (Map.Entry<String, Book> entry : allBooks.entrySet()) {
            //书名&nbsp; <a href='/WebRise/showScanHistory/ShowDetailServlet'>详情</a>
            out.write(entry.getValue().getName() + "&nbsp;&nbsp;<a href='" + request.getContextPath() + "/showScanHistory/ShowDetailServlet?id=" + entry.getKey() + "'>详情</a><br/>");
        }

        out.write("<hr>浏览记录: <br/>");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("bookHistory".equals(cookies[i].getName())) {
                String ids = cookies[i].getValue();
                String[] bookHistory = ids.split("\\-");
                for (String id : bookHistory) {
                    out.write(BookDB.findBookByName(id).getName() + "<br/>");
                }

                break;
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}