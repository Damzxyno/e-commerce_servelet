package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.AdminDAO;
import com.example.damzxynostore.entities.AdminDTO;
import jakarta.servlet.RequestDispatcher;
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

        AdminDAO adminDAO = new AdminDAO();
        System.out.println(request.getParameter("email"));
        AdminDTO adminDTO = adminDAO.get(request.getParameter("email"));

        if (adminDTO.getPassword().equals(request.getParameter("password"))) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("role", "admin");
            httpSession.setAttribute("username", adminDTO.getFirstName());
            String dashboardPage = "admin/dashboard.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(dashboardPage);
            requestDispatcher.forward(request, response);
        }



    }


}
