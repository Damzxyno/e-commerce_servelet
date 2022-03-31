<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 29/03/2022
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = "login.jsp";
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
    Object role =  session.getAttribute("role");
    if (role == null) requestDispatcher.forward(request, response);
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Damzxyno Store Administration Dashboard</title>

</head>
<body>
<jsp:include page="util.jsp" />;
<hr>
<div align="center">
    <h1>Administrative Dashboard</h1>
<nav>
    <p>QUICK ACTIONS: </p>
    <a href="admin/create_new_product.jsp">Add New Product</a>
    <a href="admin/create_new_category.jsp">Create New Category</a>
    <a href="admin/view_all_product.jsp">Create New User</a>
</nav>
</div>


</body>
</html>