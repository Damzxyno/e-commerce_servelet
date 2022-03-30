package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.utils.PasswordHashing;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "AddNewProductServlet", value = "/AddNewProductServlet")
public class AddNewProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Add New Product" + "</h1>");
        out.println("</body></html>");

        HttpSession httpSession = request.getSession();

        //fetch data from registration page
        String firstName = request.getParameter("first_name");
        System.out.println(firstName);
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        password = PasswordHashing.encryptPassword(password);



        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress(address);
        customerDTO.setEmail(email);
        customerDTO.setLastName(lastName);
        customerDTO.setFirstName(firstName);
        customerDTO.setPhone(phone);
        customerDTO.setPassword(password);
        customerDTO.setDate(new Date());


        CustomerDAO customerDAO = new CustomerDAO();


        if (!customerDAO.create(customerDTO)) {
            String errorMessage = "failed";
            httpSession.setAttribute("Registration Error", errorMessage);
            response.sendRedirect("user/successful_registration.jsp");
        }else{
            httpSession.setAttribute("Registration Error", "successfully registered");
            response.sendRedirect("user/unsuccessful_registration.jsp");
        }

    }
}
