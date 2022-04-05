package com.example.damzxynostore.controller.customer;

import com.example.damzxynostore.dao.OrderTableDAO;
import com.example.damzxynostore.dao.ProductDAO;
import com.example.damzxynostore.dao.WishlistDAO;
import com.example.damzxynostore.entities.OrderTableDTO;
import com.example.damzxynostore.entities.ProductDTO;
import com.example.damzxynostore.entities.WishlistDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SaveProductServlet", value = "/SaveProductServlet")
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object productToAdd = request.getParameter("add_to_wishlist");
        if (productToAdd != null){
            WishlistDTO wishlistDTO = new WishlistDTO();
            wishlistDTO.setProduct_id(Integer.valueOf((String)productToAdd));
            wishlistDTO.setCustomer_id((Integer) request.getSession().getAttribute("userId"));
            WishlistDAO wishlistDAO = new WishlistDAO();
            wishlistDAO.create(wishlistDTO);
            System.out.println("successfully added");
        } else {
            productToAdd = request.getParameter("add_to_cart");
            double productPrice = new ProductDAO().getPrice(Integer.valueOf((String)productToAdd));


            OrderTableDTO orderTableDTO = new OrderTableDTO();
            orderTableDTO.setOrderDate(new Date());
            orderTableDTO.setCustomerId((Integer) request.getSession().getAttribute("userId"));
            orderTableDTO.setOrderTotal(productPrice);
            orderTableDTO.setOrderStatus("Pending");

            OrderTableDAO orderTableDAO = new OrderTableDAO();
            orderTableDAO.create(orderTableDTO);
        }

        request.getRequestDispatcher("user/index.jsp").forward(request, response);
    }
}
