package com.example.damzxynostore.controller.customer;

import com.example.damzxynostore.dao.AdminDAO;
import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.entities.AdminDTO;
import com.example.damzxynostore.entities.CustomerDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerLogInServlet", value = "/CustomerLogInServlet")
public class CustomerLogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO customerDAO = new CustomerDAO();
        CustomerDTO customerDTO = customerDAO.get(request.getParameter("email"));
        String page = "user/index.jsp";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (customerDTO == null ) {
            out.println("<center><h1>Damzxyno Store</h1></center>");
            out.println("<h3 style = 'color: red;' >" + "Email doesn't exit in the database!" + "</h3>");
        } else if (customerDTO.getPassword().equals(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("role", "user");
            session.setAttribute("username", customerDTO.getFirstName());
            session.setAttribute("userId", customerDTO.getCustomerId());
            session.setAttribute("homepage", "user/index.jsp");
            response.sendRedirect(page);
        } else {
            out.println("<h1>" + "Password is incorrect!" + "</h1>");
        }
        out.println("<a href = 'user/login.jsp'>Click here to try again!</a>");
        out.println("</body></html>");

    }
}
