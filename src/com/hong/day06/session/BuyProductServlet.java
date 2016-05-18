package com.hong.day06.session;

import com.hong.day06.domain.Book;
import com.hong.day06.domain.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 购买商品
 * Created by hong on 2016/5/17.
 */
@WebServlet(name = "BuyProductServlet", urlPatterns = {"/session/BuyProductServlet"})
public class BuyProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. getBookByName
        String name = request.getParameter("bookName");
        Book book = BookDB.findBookByName(name);

        HttpSession session = request.getSession();

        List<Book> cart = (List<Book>) session.getAttribute("cart");
        //2. create session
        //3. 判断是否为空
        if (cart == null) {
            //没有session
            cart = new ArrayList<Book>();
            //放入session
            session.setAttribute("cart", cart);
        }
        cart.add(book);

        //4. 界面显示
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //购买成功! &nbsp;<a href='/WebRise/session/ShowProductServlet'>继续购买</a><br/>
        out.write("购买成功! &nbsp;<a href='" + request.getContextPath() + "/session/ShowProductServlet'>继续购买</a><br/>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}