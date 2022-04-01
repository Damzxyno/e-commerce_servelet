package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] productsToBeDeleted = request.getParameterValues("product_to_be_deleted");
        ProductDAO productDAO = new ProductDAO();

        for (String productName : productsToBeDeleted){
            System.out.println(productName);
            productDAO.delete(productName);
        }

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><h1>The following products were successfully deleted!</h1> <ol>");

        for (String productName : productsToBeDeleted){
            printWriter.println("<li>");
            printWriter.println(productName);
            printWriter.println("</li>");
        }

        printWriter.println("</ol>");
        printWriter.println("<a href= 'admin/dashboard.jsp'>Dashboard</a>");
        printWriter.println("<a href= 'admin/delete_product.jsp'>Delete More!</a>");

    }
}
