package com.example.damzxynostore.controller.customer;

import com.example.damzxynostore.dao.WishlistDAO;
import com.example.damzxynostore.entities.WishlistDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WishlistServlet", value = "/WishlistServlet")
public class WishlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/wishlist.jsp");
    requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
