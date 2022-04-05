package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.AdminDAO;
import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.entities.AdminDTO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.utils.PasswordHashing;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "RegisterNewAdminServlet", value = "/RegisterNewAdminServlet")
public class RegisterNewAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Admin Registration" + "</h1>");
        out.println("</body></html>");

        HttpSession httpSession = request.getSession();

        //fetch data from registration page
        String password = request.getParameter("password");
        password = PasswordHashing.encryptPassword(password);

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail(request.getParameter("email"));
        adminDTO.setFirstName(request.getParameter("first_name"));
        adminDTO.setLastName(request.getParameter("last_name"));
        adminDTO.setPassword(password);

        AdminDAO adminDAO = new AdminDAO();

        if (adminDAO.create(adminDTO)) {
            response.sendRedirect("user/successful_registration.jsp");
        }else{
            String errorMessage = "failed";
            httpSession.setAttribute("Registration Error", errorMessage);
            response.sendRedirect("user/unsuccessful_registration.jsp");
        }

    }
}
