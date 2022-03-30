package com.example.damzxynostore.controller.admin;

import java.io.*;

import com.example.damzxynostore.dao.AdminDAO;
import com.example.damzxynostore.entities.AdminDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Damzxyno Administration Page" + "</h1>");
        out.println("</body></html>");
        String page = "admin/dashboard.jsp";

        AdminDAO adminDAO = new AdminDAO();
        System.out.println(request.getParameter("email"));
        AdminDTO adminDTO = adminDAO.get(request.getParameter("email"));

        System.out.println(adminDTO.getPassword());

        if (adminDTO.getPassword().equals(request.getParameter("password"))) System.out.println("Oun sise");


        //get request data
        String numEmail = request.getParameter("numEmail");
        String password = request.getParameter("password");
        response.sendRedirect(page);

    }


}
