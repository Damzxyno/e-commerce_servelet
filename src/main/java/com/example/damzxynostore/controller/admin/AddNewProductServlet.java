package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.CategoryDAO;
import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.dao.ProductDAO;
import com.example.damzxynostore.entities.CategoryDTO;
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
        CategoryDTO categoryDTO = new CategoryDAO().get(request.getParameter("product_category"));
       ProductDTO productDTO = new ProductDTO();
       productDTO.setProductName(request.getParameter("product_name"));
       productDTO.setPrice(Double.parseDouble(request.getParameter("product_price")));
       productDTO.setCategoryId(categoryDTO.getCategoryId());
       productDTO.setDescription(request.getParameter("product_description"));
       ProductDAO productDAO = new ProductDAO();
       boolean createdProduct = productDAO.create(productDTO);

       response.setContentType("text/html");
       PrintWriter printWriter = response.getWriter();
       printWriter.println("<html><body><center><h1>Damzxyno Store</h1></center>");
        printWriter.println("\t");
        printWriter.println(productDTO.getProductName());
        if (createdProduct) {
           printWriter.println(" was successfully created! <br />");
       }   else {
            printWriter.println(" already exist!");
        }
        printWriter.println("<a href = 'admin/create_new_product.jsp'>Click here to create another product</a>");
        printWriter.println("</body></html>");
    }
}
