<%@ page import="com.example.damzxynostore.entities.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.damzxynostore.dao.ProductDAO" %><%
    StringBuilder stringBuilder = new StringBuilder();
    List<ProductDTO> productDTOList = new ProductDAO().listAll();
    int sn = 1;
    for (ProductDTO productDTO : productDTOList){
        String productName = productDTO.getProductName();
        stringBuilder.append(sn).append("<input type = 'checkbox' name = '").append("product_to_be_deleted")
                .append("' value = '").append(productName).append("' id = '")
                .append(productName).append("' />")
                .append("<Label for = '").append(productName).append("'>")
                .append(productName).append("</label> <br/>");
        sn++;
    }

%>

<%= stringBuilder.toString()%>