<%@ page import="com.example.damzxynostore.entities.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.damzxynostore.dao.CategoryDAO" %>

<%
    StringBuilder stringBuilder = new StringBuilder();
    List<CategoryDTO> categoryDTOS = new CategoryDAO().listAll();

    stringBuilder.append("<select id = 'product_category' name = 'product_category'>");
    for (CategoryDTO categoryDTO : categoryDTOS) {
        String categoryName = categoryDTO.getCategoryName();
        stringBuilder.append("<option value = '")
                .append(categoryName)
                .append("'>")
                .append(categoryName)
                .append("</option>");
    }
    stringBuilder.append("</select>");
%>
<%= stringBuilder.toString()%>