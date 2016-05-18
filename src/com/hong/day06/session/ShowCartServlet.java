package com.hong.day06.session;

import com.hong.day06.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 显示购物车详情
 * Created by hong on 2016/5/17.
 */
@WebServlet(name = "ShowCartServlet", urlPatterns = {"/session/ShowCartServlet"})
public class ShowCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        //判断session是否为空
        if (session == null) {
            out.write("您还没有购买任何商品！");
            return;
        }

        //判断购物车是否为空
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            out.write("购物车是空的，请先购买一些商品吧！");
            return;
        }

        out.write("您购买的商品如下：<br/>");
        for (Book book : cart) {
            out.write(book.getName() + "<br/>");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}