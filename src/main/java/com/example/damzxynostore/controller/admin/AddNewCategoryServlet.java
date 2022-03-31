package com.example.damzxynostore.controller.admin;

import com.example.damzxynostore.dao.CategoryDAO;
import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.entities.CategoryDTO;
import com.example.damzxynostore.entities.CustomerDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNewCategoryServlet", value = "/AddNewCategoryServlet")
public class AddNewCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String categoryName = request.getParameter("category_name");
        System.out.println(categoryName);

        CategoryDAO categoryDAO = new CategoryDAO();
        CategoryDTO categoryDTO  = categoryDAO.get(categoryName);
        String htmlResponse = "<html><body> <h1> ";

        if (categoryDTO == null){
            categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryName(categoryName);
            categoryDAO.create(categoryDTO);
            htmlResponse += "Category created successfully!</h1>" +
                    "<a href = 'admin/create_new_category.jsp'>Go back to create category</a> ";

        } else {
             htmlResponse += "Category already exist!</h1>" +
                    "<a href = 'admin/create_new_category.jsp'>Go back to create category</a> ";
        }

        htmlResponse+= "</body></html>";
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(htmlResponse);
    }
}
