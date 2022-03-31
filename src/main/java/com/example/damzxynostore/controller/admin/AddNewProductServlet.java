package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.dao.ProductDAO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.entities.ProductDTO;
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

//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "Add New Product" + "</h1>");
//        out.println("</body></html>");

        HttpSession httpSession = request.getSession();

       ProductDTO productDTO = new ProductDTO();
       productDTO.setProductName(request.getParameter("product_name"));
       productDTO.setPrice(Double.parseDouble(request.getParameter("product_price")));
//       productDTO.setCategoryId(Integer.parseInt(request.getParameter("product_category")));
       productDTO.setCategoryId(00000);
       productDTO.setDescription(request.getParameter("product_description"));
        ProductDAO productDAO = new ProductDAO();
        productDAO.create(productDTO);
    }
}
