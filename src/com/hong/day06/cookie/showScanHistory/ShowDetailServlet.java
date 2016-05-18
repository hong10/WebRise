package com.hong.day06.cookie.showScanHistory;

import com.hong.day06.domain.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}