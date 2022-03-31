<%@ page import="com.example.damzxynostore.dao.CustomerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.damzxynostore.entities.CustomerDTO" %>
<%
    CustomerDAO customerDAO = new CustomerDAO();
    List<CustomerDTO> customerDTOS= customerDAO.listAll();
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("<table>")
            .append("<td>").append("SN").append("</td>")
            .append("<td>").append("Last Name").append("</td>")
            .append("<td>").append("First Name").append("</td>")
            .append("<td>").append("Address").append("</td>")
            .append("<td>").append("Phone").append("</td>");

    int sn = 1;
    for (CustomerDTO customerDTO : customerDTOS){
        stringBuilder.append("<tr>")
                .append("<td>").append(sn).append("</td>")
                .append("<td>").append(customerDTO.getLastName()).append("</td>")
                .append("<td>").append(customerDTO.getFirstName()).append("</td>")
                .append("<td>").append(customerDTO.getAddress()).append("</td>")
                .append("<td>").append(customerDTO.getPhone()).append("</td>")
                     .append("<tr>");
        sn++;
    }
    stringBuilder.append("</table>");
%>
<div><%= stringBuilder.toString()%></div>
