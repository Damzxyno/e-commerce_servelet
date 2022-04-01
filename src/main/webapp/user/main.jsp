<%@ page import="com.example.damzxynostore.entities.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.damzxynostore.dao.ProductDAO" %>
<%@ page import="com.example.damzxynostore.dao.CategoryDAO" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<style>
    .product_box_container{
        display: flex;
        gap: 15px;
        justify-content: center;
    }


    .product_box{
        background-color: black;
        color: wheat;
        width: 180px;
        height: 200px;
        border: solid 3px brown;
        border-radius: 25px;
        padding: 2px;

    }
</style>
<%
    StringBuilder stringBuilder = new StringBuilder();
    Locale nigeria = new Locale("en", "ng");
    NumberFormat nairaFormat = NumberFormat.getCurrencyInstance(nigeria);
    List<ProductDTO> productDTOS = new ProductDAO().listAll();

    for (ProductDTO productDTO : productDTOS){
        String productCategory = new CategoryDAO().getName(productDTO.getCategoryId()).getCategoryName();
        String price = nairaFormat.format(productDTO.getPrice());
        String productName = productDTO.getProductName();
        stringBuilder.append("<div class = 'product_box'>")
                .append("<h4>").append(productName).append("</h4><br />")
                .append("<p>").append(productCategory).append("</p>")
                .append("<p style = 'color: green;'>").append(price).append("</p>");

        if (session.getAttribute("role") != null){
            stringBuilder.append("<label for = 'add_to_cart'>Add to Cart? </label>")
                    .append("<input type = 'checkbox' value = ")
                    .append(productName).append("' id = '").append(productName).append("'/>");
        }

        stringBuilder.append("</div>");
    }
%>




<div class="product_box_container" align="center">
    <%= stringBuilder.toString()%>
</div>