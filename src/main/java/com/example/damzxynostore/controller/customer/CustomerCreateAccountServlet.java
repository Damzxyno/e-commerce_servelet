package com.example.damzxynostore.controller.customer;

import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.utils.PasswordHashing;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "CustomerCreateAccountServlet", value = "/CustomerCreateAccountServlet")
public class CustomerCreateAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Servlet Registration example" + "</h1>");
        out.println("</body></html>");

        HttpSession httpSession = request.getSession();

        //fetch data from registration page
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        httpSession.setAttribute("email",email);
        httpSession.setAttribute("id",email);

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


        if (customerDAO.create(customerDTO)) {
            response.sendRedirect("user/successful_registration.jsp");
        }else{
            String errorMessage = "failed";
            httpSession.setAttribute("Registration Error", errorMessage);
            response.sendRedirect("user/unsuccessful_registration.jsp");
        }

    }
    }

