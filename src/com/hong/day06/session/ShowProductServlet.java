package com.hong.day06.session;

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
 * 显示商品列表
 */
@WebServlet(name = "ShowProductServlet", urlPatterns = {"/session/ShowProductServlet"})
public class ShowProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<br/><h1>最新上架的书籍：</h1><br/>");
        //get books
        Map<String, Book> allBoos = BookDB.findAllBooks();
        for (Map.Entry<String, Book> entry : allBoos.entrySet()) {
            //bookName+ <a href='/WebRise/session/BuyProductServlet?id=bookName'/>购买</a><br/>
            out.write(entry.getValue().getName() + "&nbsp;&nbsp;<a href='" + request.getContextPath() + "/session/BuyProductServlet?bookName=" + entry.getKey() + "'/>购买</a><br/>");
        }

        out.write("<hr/><a href='" + request.getContextPath() + "/session/ShowCartServlet'>查看购物车</a><br/>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}