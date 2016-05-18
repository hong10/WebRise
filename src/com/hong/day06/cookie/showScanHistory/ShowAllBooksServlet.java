package com.hong.day06.cookie.showScanHistory;

import com.hong.day06.domain.Book;
import com.hong.day06.domain.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}