<%@ page import="com.example.damzxynostore.entities.WishlistDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.damzxynostore.dao.WishlistDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.damzxynostore.entities.ProductDTO" %>
<%@ page import="com.example.damzxynostore.dao.ProductDAO" %>
<%@ page import="com.example.damzxynostore.dao.CategoryDAO" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 04/04/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .product_box_container{
        display: flex;
        gap: 15px;
        justify-content: center;
    }


    .product_box{
        background-color: #70c5c0;
        color: crimson;
        width: 180px;
        height: 220px;
        border: solid 3px brown;
        border-radius: 25px;
        padding: 2px;
    }

    button {
        margin-bottom: 5px;
        background-color: #5cb85c;
    }

    button:visited{
        background-color: blue;
    }
</style>
<%
    StringBuilder stringBuilder = new StringBuilder();
    int userID = (int) session.getAttribute("userId");
    List<WishlistDTO> wishlistDTOS = new WishlistDAO().getWishLists(userID);
    if (wishlistDTOS == null){
        stringBuilder.append("You do not have any product in your wishlisht");
    } else {
        for (WishlistDTO wishlistDTO : wishlistDTOS){
            ProductDTO productDTO = new ProductDAO().get(wishlistDTO.getProduct_id());
            String productCategory = new CategoryDAO().getName(productDTO.getCategoryId()).getCategoryName();
            stringBuilder.append("<div class = 'product_box'>")
                    .append("<h4>").append(productDTO.getProductName()).append("</h4><br />")
                    .append("<p>").append(productCategory).append("</p>")
                    .append("<p style = 'color: green;'>").append(productDTO.getPrice()).append("</p>")
                    .append("<button name = 'add_to_cart' value = '")
                        .append(productDTO.getProductId()).append("' id = '").append(productDTO.getProductName()).append("'>Add to Cart</button><br/ >");
            stringBuilder.append("</div>");
        }
    }

%>
<head>
    <title>Wish List</title>
</head>
<body>
<jsp:include page='util/header.jsp' /><br><hr><br>"
<center><h3><%=session.getAttribute("username")%>'s Wishlist!</h3></center>
    <%=stringBuilder.toString()%>
</body>
</html>
